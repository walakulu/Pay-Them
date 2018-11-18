package com.recruit.paythem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.recruit.paythem.domain.Employee;
import com.recruit.paythem.dto.EmployeeDto;
import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.enums.FieldName;
import com.recruit.paythem.exception.EntityNotFoundException;
import com.recruit.paythem.repository.EmployeeRepository;
import com.recruit.paythem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResponseDto getEmployeeList(int recruitmentId) throws Exception {

		List<Employee> employeeList = employeeRepository.findEmployeesByRecruitmentId(recruitmentId);

		ResponseDto resposnseDto = null;
		List<EmployeeDto> employeeDtoList;
		if (CollectionUtils.isEmpty(employeeList)) {

			throw new EntityNotFoundException(FieldName.RECRUITMENT_ID, recruitmentId);
		} else {
			employeeDtoList = new ArrayList<>();
			employeeList.forEach(employee -> {
				EmployeeDto employeeDto = new EmployeeDto();
				employeeDto.setEmployeeId(employee.getId());
				employeeDto.setName(employee.getName());
				employeeDto.setCatagory(employee.getCatagory().getType());
				employeeDtoList.add(employeeDto);

			});
			resposnseDto = new ResponseDto.Builder().withResponseObject(employeeDtoList).build();
		}
		return resposnseDto;
	}

}
