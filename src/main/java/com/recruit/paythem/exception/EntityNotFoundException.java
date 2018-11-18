package com.recruit.paythem.exception;

import com.recruit.paythem.enums.FieldName;

public class EntityNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int resourceId;
	private FieldName fieldName;

	public EntityNotFoundException(String message) {
		super(message);

	}

	public EntityNotFoundException(FieldName fieldName, int resourceId) {
		this.fieldName = fieldName;
		this.resourceId = resourceId;

	}

	/**
	 * @return the resourceId
	 */
	public int getResourceId() {
		return resourceId;
	}

	/**
	 * @param resourceId
	 *            the resourceId to set
	 */
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * @return the fieldName
	 */
	public FieldName getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName
	 *            the fieldName to set
	 */
	public void setFieldName(FieldName fieldName) {
		this.fieldName = fieldName;
	}

}
