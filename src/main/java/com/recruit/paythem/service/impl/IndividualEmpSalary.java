package com.recruit.paythem.service.impl;

import org.springframework.stereotype.Component;

import com.recruit.paythem.enums.EmployeeType;
import com.recruit.paythem.util.AppConstants;

@Component
public class IndividualEmpSalary {

	public double getIndividualSalaryByEmpType(EmployeeType employeeType) {

		switch (employeeType) {
		case MASON:
			return AppConstants.MASON_SALARY;

		case CARPENTER:
			return AppConstants.CARPENTER_SALARY;
		default:
			return 0;

		}
	}

}
