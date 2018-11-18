package com.recruit.paythem.dto;

import java.io.Serializable;

public class ResponseDto implements Serializable {

	public static class Builder {
		private String messageCode;
		private String message;
		private Object response;

		public Builder() {

		}

		public ResponseDto build() {
			return new ResponseDto(this);
		}

		public Builder withMessageCode(String messageCode) {
			this.messageCode = messageCode;
			return this;
		}

		public Builder withMessage(String message) {
			this.message = message;
			return this;
		}

		public Builder withResponseObject(Object response) {
			this.response = response;
			return this;
		}

	}

	private static final long serialVersionUID = -4686394340053139563L;

	private String messageCode;
	private String message;
	private Object response;

	private ResponseDto() {

	}

	private ResponseDto(Builder builder) {
		this.messageCode = builder.messageCode;
		this.message = builder.message;
		this.response = builder.response;
	}

	public ResponseDto(String messageCode, String message, Object response) {
		this.messageCode = messageCode;
		this.message = message;
		this.response = response;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((messageCode == null) ? 0 : messageCode.hashCode());
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseDto other = (ResponseDto) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (messageCode == null) {
			if (other.messageCode != null)
				return false;
		} else if (!messageCode.equals(other.messageCode))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		return true;
	}
	
	

}
