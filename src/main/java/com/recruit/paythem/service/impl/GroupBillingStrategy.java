package com.recruit.paythem.service.impl;

import com.recruit.paythem.util.AppConstants;

public class GroupBillingStrategy implements BillingStrategy {

	private double costPerGroups;
	private double commision;

	@Override
	public double calculateBill(int recruitmentIdCount, double individualSalary) {

//		costPerGroups = AppConstants.GROUP_SIZE * (recruitmentIdCount * individualSalary);
//		commision = costPerGroups * AppConstants.BONUS_PERCENTAGE;
//		int individuals;
//		int groups;
		int individuals=recruitmentIdCount%AppConstants.GROUP_SIZE;
		int groups=recruitmentIdCount/AppConstants.GROUP_SIZE;

		return (costPerGroups + commision);
	}

}
