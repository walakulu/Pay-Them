package com.recruit.paythem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.recruit.paythem.dto.ResponseDto;
import com.recruit.paythem.enums.ResponseMessage;
import com.recruit.paythem.service.RecruitmentService;

@RestController
@CrossOrigin
public class RecruitmentController {

	@Autowired
	private RecruitmentService recruitmentService;

	/**
	 * <p>
	 * This controller method gives recruitment details.
	 * </p>
	 * 
	 * @param headHunterId
	 *            the Head Hunter Id
	 * @param group
	 *            represents individual or group recruitment
	 * @param month
	 *            the month
	 * @return {@code ResponseEntity}
	 * @throws Exception
	 */
	@GetMapping(value = "recruitment/head-hunter/{head-hunter-id}/group/{group}/month/{month}")
	public ResponseEntity<?> getIndividualRecruitmentByHeadHunter(@PathVariable("head-hunter-id") int headHunterId,
			@PathVariable("group") String group, @PathVariable("month") int month) throws Exception {

		ResponseDto responseDto = recruitmentService.findRecruitmentDetails(headHunterId, group, month);
		responseDto.setMessageCode(ResponseMessage.SUCCESS.getCode());
		responseDto.setMessage(ResponseMessage.SUCCESS.getMessage());

		return ResponseEntity.ok(responseDto);
	}

}
