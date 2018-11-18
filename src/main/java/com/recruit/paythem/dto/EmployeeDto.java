package com.recruit.paythem.dto;

import java.io.Serializable;

public class EmployeeDto implements Serializable {

	private static final long serialVersionUID = -4793371752285081119L;
	private int employeeId;
	private String catagory;
	private String name;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
