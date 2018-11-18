package com.recruit.paythem.enums;

public enum FieldName {
	RECRUITMENT_ID("recruitmentId"), 
	HEADHUNTER_ID("headHunterId");
	private String fieldName;

	FieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName
	 *            the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

}
