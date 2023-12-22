package com.venuetype.model;

import java.io.Serializable;
import java.util.Objects;

public class VenueTypeVO implements Serializable {
	private Integer venTypeId;
	private String venTypeName;

	public Integer getVenTypeId() {
		return venTypeId;
	}

	public void setVenTypeId(Integer venTypeId) {
		this.venTypeId = venTypeId;
	}

	public String getVenTypeName() {
		return venTypeName;
	}

	public void setVenTypeName(String venTypeName) {
		this.venTypeName = venTypeName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(venTypeId, venTypeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VenueTypeVO other = (VenueTypeVO) obj;
		return Objects.equals(venTypeId, other.venTypeId) && Objects.equals(venTypeName, other.venTypeName);
	}

}
