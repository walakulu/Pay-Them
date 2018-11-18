package com.recruit.paythem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.enums.ResponseMessage;
import com.recruit.paythem.service.HeadHunterService;

@RestController
@CrossOrigin
public class HeadHunterController {

	@Autowired
	private HeadHunterService headHunterService;

	/**
	 * <p>
	 * This controller method gives all the registered head hunters in detail.
	 * <p>
	 * 
	 * @return {@code ResponseEntity}
	 * @throws Exception
	 */
	@GetMapping(value = "head-hunters")
	public ResponseEntity<?> getAllHeadHunters() throws Exception {

		ResponseDto responseDto = headHunterService.getAllHeadHunters();
		responseDto.setMessageCode(ResponseMessage.SUCCESS.getCode());
		responseDto.setMessage(ResponseMessage.SUCCESS.getMessage());

		return ResponseEntity.ok(responseDto);
	}

}
