package com.recruit.paythem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.enums.ResponseMessage;
import com.recruit.paythem.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * <p>
	 * This controller method gives all the recruited employee details for given
	 * recruitment id.
	 * </p>
	 * 
	 * @param recruitmentId
	 * @return	{@code ResponseEntity}
	 * @throws Exception
	 */
	@GetMapping(value = "employees/{recruitment-id}")
	public ResponseEntity<?> getEmployeesByRecruitmentId(@PathVariable("recruitment-id") int recruitmentId)
			throws Exception {

		ResponseDto responseDto = employeeService.getEmployeeList(recruitmentId);
		responseDto.setMessageCode(ResponseMessage.SUCCESS.getCode());
		responseDto.setMessage(ResponseMessage.SUCCESS.getMessage());

		return ResponseEntity.ok(responseDto);
	}

}
