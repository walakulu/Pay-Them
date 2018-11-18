package com.recruit.paythem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.enums.ResponseMessage;
import com.recruit.paythem.service.BillingService;

@RestController
@CrossOrigin
public class BillingController {

	@Autowired
	private BillingService billingService;

	/**
	 * <p>
	 * This controller gives bill summary details.
	 * <p>
	 * 
	 * @param headHunterId
	 *            the HeadHunter ID
	 * @param month
	 *            the month of the billing/recruited
	 * @return {@code ResponseEntity}
	 * @throws Exception
	 */
	@GetMapping(value = "billing/head-hunter/{head-hunter-id}/month/{month}")
	public ResponseEntity<?> getMonthlyBillInfo(@PathVariable("head-hunter-id") int headHunterId,
													@PathVariable("month") int month)throws Exception {
		ResponseDto responseDto = billingService.getMonthlyBillInfo(headHunterId, month);
		responseDto.setMessageCode(ResponseMessage.SUCCESS.getCode());
		responseDto.setMessage(ResponseMessage.SUCCESS.getMessage());

		return ResponseEntity.ok(responseDto);
	}

}
