package com.recruit.paythem.enums;

public enum EmployeeType {

	MASON("Mason"), CARPENTER("Carpenter");

	private String employeeType;

	EmployeeType(String type) {
		this.employeeType = type;
		}

	public String getEmployeeType() {
		return employeeType;
	}

}
