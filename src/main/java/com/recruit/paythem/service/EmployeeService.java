package com.recruit.paythem.service;

import com.recruit.paythem.dto.ResponseDto;

public interface EmployeeService {

	ResponseDto getEmployeeList(int recruitmentId) throws Exception;
}
