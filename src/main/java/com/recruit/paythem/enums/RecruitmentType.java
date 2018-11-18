package com.recruit.paythem.enums;

public enum RecruitmentType {
	INDIVIDUAL("N"), GROUP("Y");

	private String recrumentType;

	RecruitmentType(String type) {
		this.recrumentType = type;

	}

	public String getRecrumentType() {
		return recrumentType;
	}

}
