package com.recruit.paythem.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.recruit.paythem.dto.BillInfoDto;
import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.enums.EmployeeType;
import com.recruit.paythem.repository.BillingRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillingServiceImplTest {

	@Autowired
	private BillingService billingService;

	@MockBean
	private BillingRepository billingRepository;

	@Test
	public void testGetMonthlyBillInfo() throws Exception {
		List<BillInfoDto> billInfoList = new ArrayList<>();
		
		BillInfoDto masonIndividualBillInfoDto = new BillInfoDto.Builder()
						.isGroup(false)
						.withBillCatagory(EmployeeType.MASON.getEmployeeType())
						.withRecruitCount(2)
						.withTotal(400)
						.build();
		
		BillInfoDto carpenterIndividualBillInfoDto = new BillInfoDto.Builder()
						.isGroup(false)
						.withBillCatagory(EmployeeType.CARPENTER.getEmployeeType())
						.withRecruitCount(1)
						.withTotal(250)
						.build();
		
		BillInfoDto masonGroupBillInfoDto = new BillInfoDto.Builder()
						.isGroup(true)
						.withBillCatagory(EmployeeType.MASON.getEmployeeType())
						.withRecruitCount(1)
						.withTotal(1100)
						.build();
		
		BillInfoDto carpenterGroupBillInfoDto = new BillInfoDto.Builder()
						.isGroup(true)
						.withBillCatagory(EmployeeType.CARPENTER.getEmployeeType())
						.withRecruitCount(0)
						.withTotal(0)
						.build();
		
		billInfoList.add(masonIndividualBillInfoDto);
		billInfoList.add(carpenterIndividualBillInfoDto);
		billInfoList.add(masonGroupBillInfoDto);
		billInfoList.add(carpenterGroupBillInfoDto);
		
		ResponseDto responseDto = new ResponseDto.Builder()
				.withResponseObject(billInfoList)
				.build();

		Mockito.when(billingRepository.findBillingCountByHeadHunterIdTypeGroupAndMonth(1,EmployeeType.MASON.getEmployeeType(),"N",6)).thenReturn(2);
		Mockito.when(billingRepository.findBillingCountByHeadHunterIdTypeGroupAndMonth(1,EmployeeType.CARPENTER.getEmployeeType(),"N",6)).thenReturn(1);
		Mockito.when(billingRepository.findBillingCountByHeadHunterIdTypeGroupAndMonth(1,EmployeeType.MASON.getEmployeeType(),"Y",6)).thenReturn(1);
		Mockito.when(billingRepository.findBillingCountByHeadHunterIdTypeGroupAndMonth(1,EmployeeType.CARPENTER.getEmployeeType(),"Y",6)).thenReturn(0);
		
		assertThat(billingService.getMonthlyBillInfo(1, 6)).isEqualTo(responseDto);
	}

}
