package com.recruit.paythem.dto;

import java.io.Serializable;

public class HeadHunterDto implements Serializable {
	private static final long serialVersionUID = 5549348438371373624L;

	public static class Builder {
		private int id;
		private String name;

		public Builder() {

		}

		public HeadHunterDto build() {
			return new HeadHunterDto(this);
		}

		public Builder withId(int id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

	}

	private int id;
	private String name;

	private HeadHunterDto(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
	}

	private HeadHunterDto() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		HeadHunterDto other = (HeadHunterDto) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
