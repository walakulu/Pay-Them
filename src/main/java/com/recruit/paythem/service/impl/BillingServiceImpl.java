package com.recruit.paythem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.recruit.paythem.dto.BillInfoDto;
import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.enums.EmployeeType;
import com.recruit.paythem.enums.RecruitmentType;
import com.recruit.paythem.enums.ResponseMessage;
import com.recruit.paythem.exception.EntityNotFoundException;
import com.recruit.paythem.repository.BillingRepository;
import com.recruit.paythem.service.BillingService;

/**
 * <p>
 * This class is responsible for assembling billing entity objects.
 * </p>
 * 
 * @author Hasitha Maduranga
 *
 */
@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private BillCalculator billCalculator;

	@Autowired
	private BillingRepository billingRepository;
	
	@Autowired
	private IndividualEmpSalary individualEmpSalary;

	@Override
	public ResponseDto getMonthlyBillInfo(int headHunterId, int month) throws Exception {

		ResponseDto resposnseDto = null;
		List<BillInfoDto> billInfoList = new ArrayList<>();

		for (RecruitmentType recruitmentType : RecruitmentType.values()) {
			// should populate for both Mason & Capenter for specified type
			for (EmployeeType employeeType : EmployeeType.values()) {
				populateBillInfo(billInfoList, recruitmentType, employeeType,headHunterId, month);
			}
		}

		if (CollectionUtils.isEmpty(billInfoList)) {
			throw new EntityNotFoundException(ResponseMessage.NO_BILL_INFO.getMessage());
		} else {
			resposnseDto = new ResponseDto.Builder()
					.withResponseObject(billInfoList)
					.build();

		}
		return resposnseDto;
	}

	/**
	 * <p>
	 * Populates {@code BillInfoDto} objects and assemble in to the given
	 * {@code List<BillInfoDto} reference.
	 * </p>
	 * 
	 * @param billInfoList
	 * @param type
	 * @param headHunterId
	 * @param month
	 */
	private void populateBillInfo(List<BillInfoDto> billInfoList, RecruitmentType recruitmentType,EmployeeType employeeType, int headHunterId, int month) {
		boolean isGroupRecruitment=false;
		
		if (recruitmentType == RecruitmentType.GROUP) {
			isGroupRecruitment=true;
		}
		// get recruitment record count which are not paid
		int recruitmentIdCount = billingRepository.findBillingCountByHeadHunterIdTypeGroupAndMonth(headHunterId,
				employeeType.getEmployeeType(), (isGroupRecruitment == true) ? "Y" : "N", month);
	
		BillInfoDto buildBillInfoDto = new BillInfoDto.Builder()
				.isGroup(isGroupRecruitment)
				.withBillCatagory(employeeType.getEmployeeType())
				.withRecruitCount(recruitmentIdCount)
				.withTotal(billCalculator.calculateBill(recruitmentType, recruitmentIdCount, individualEmpSalary.getIndividualSalaryByEmpType(employeeType)))
				.build();
		
		billInfoList.add(buildBillInfoDto);

	}

}
