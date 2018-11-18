package com.recruit.paythem.dto;

import java.io.Serializable;


public class BillInfoDto implements Serializable {
	private static final long serialVersionUID = 7839478203215473950L;

	public static class Builder {
		private boolean isGroup;
		private String billCatagory;
		private int recruitCount;
		private double total;

		public Builder() {
		}

		public BillInfoDto build() {
			return new BillInfoDto(this);
		}

		public Builder isGroup(boolean isGroup) {
			this.isGroup = isGroup;
			return this;
		}

		public Builder withBillCatagory(String billCatagory) {
			this.billCatagory = billCatagory;
			return this;
		}

		public Builder withRecruitCount(int recruitCount) {
			this.recruitCount = recruitCount;
			return this;
		}

		public Builder withTotal(double total) {
			this.total = total;
			return this;
		}
	}

	private boolean isGroup;
	private String billCatagory;
	private int recruitCount;
	private double total;

	private BillInfoDto(Builder builder) {
		this.isGroup = builder.isGroup;
		this.billCatagory = builder.billCatagory;
		this.recruitCount = builder.recruitCount;
		this.total = builder.total;

	}

	public boolean isGroup() {
		return isGroup;
	}

	public void setGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}

	public String getBillCatagory() {
		return billCatagory;
	}

	public void setBillCatagory(String billCatagory) {
		this.billCatagory = billCatagory;
	}

	public int getRecruitCount() {
		return recruitCount;
	}

	public void setRecruitCount(int recruitCount) {
		this.recruitCount = recruitCount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billCatagory == null) ? 0 : billCatagory.hashCode());
		result = prime * result + (isGroup ? 1231 : 1237);
		result = prime * result + recruitCount;
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		BillInfoDto other = (BillInfoDto) obj;
		if (billCatagory == null) {
			if (other.billCatagory != null)
				return false;
		} else if (!billCatagory.equals(other.billCatagory))
			return false;
		if (isGroup != other.isGroup)
			return false;
		if (recruitCount != other.recruitCount)
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}
	
	

}
