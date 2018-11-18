package com.recruit.paythem.service;

import com.recruit.paythem.dto.ResponseDto;

public interface BillingService {

	/**
	 * <p>
	 * Gives head hunter billing summary
	 * </p>
	 * 
	 * @param headHunterId
	 * @param month
	 * @return
	 * @throws Exception
	 */
	ResponseDto getMonthlyBillInfo(int headHunterId, int month) throws Exception;

}
