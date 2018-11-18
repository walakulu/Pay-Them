package com.recruit.paythem.service.impl;

public interface BillingStrategy {

	double calculateBill(int recruitmentIdCount,double individualSalary);

}
