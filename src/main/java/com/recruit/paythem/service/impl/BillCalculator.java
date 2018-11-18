package com.recruit.paythem.service.impl;

import org.springframework.stereotype.Component;

import com.recruit.paythem.enums.RecruitmentType;

/**
 * <p>
 * This class calculates the billing details by using strategy design pattern.
 * </p>
 * 
 * @author Hasitha Maduranga
 *
 */
@Component
public class BillCalculator {

	private final BillCalculationStrategyFactory billCalculationStrategyFactory = new BillCalculationStrategyFactory();

	/**
	 * <p>
	 * This method gets the appropriate billing strategy by using
	 * {@code BillCalculationStrategyFactory}.
	 * </p>
	 * 
	 * @param recruitmentType
	 * @param recruitmentIdCount
	 * @param individualSalary
	 * @return
	 */
	public double calculateBill(RecruitmentType recruitmentType, int recruitmentIdCount, double individualSalary) {
		
		BillingStrategy billingStrategy = billCalculationStrategyFactory.getBillingStrategy(recruitmentType);

		return billingStrategy.calculateBill(recruitmentIdCount, individualSalary);
	}

}
