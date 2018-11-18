package com.recruit.paythem.service.impl;

public class IndividualBillingStrategy implements BillingStrategy {

	@Override
	public double calculateBill(int recruitmentIdCount, double individualSalary) {

		return recruitmentIdCount * individualSalary;
	}

}
