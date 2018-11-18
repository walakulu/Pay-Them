package com.recruit.paythem.service.impl;

import com.recruit.paythem.enums.RecruitmentType;

/**
 * <p>
 * Factory for generate billing strategy objects.
 * </p>
 * 
 * @author Hasitha Maduranga
 *
 */
public class BillCalculationStrategyFactory {
	// Strategies for calculating interest.
	private final BillingStrategy individualBillCalculationStrategy = new IndividualBillingStrategy();
	private final BillingStrategy groupBillCalculationStrategy = new GroupBillingStrategy();

	/**
	 * <p>
	 * Gives factory object according to recruitment type.
	 * <p/>
	 * 
	 * @param type
	 *            recruitment type ie: GROUP/INDIVIDUAL
	 * @return {@code BillingStrategy}
	 */
	public BillingStrategy getBillingStrategy(RecruitmentType type) {
		switch (type) {
		case GROUP:
			return groupBillCalculationStrategy;

		default:
			return individualBillCalculationStrategy;

		}

	}

}
