package com.qa.citizen.rest.DTOs;

public class EposDTO {

	public EposDTO(String vendor, String streetname, String postcode) {
		super();
		this.vendor = vendor;
		this.streetname = streetname;
		this.postcode = postcode;
	}

	public EposDTO() {
		super();
	}

	private String vendor;

	private String streetname;

	private String postcode;

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((streetname == null) ? 0 : streetname.hashCode());
		result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
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
		EposDTO other = (EposDTO) obj;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (streetname == null) {
			if (other.streetname != null)
				return false;
		} else if (!streetname.equals(other.streetname))
			return false;
		if (vendor == null) {
			if (other.vendor != null)
				return false;
		} else if (!vendor.equals(other.vendor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EposDTO [vendor=" + vendor + ", streetname=" + streetname + ", postcode=" + postcode + "]";
	}

}
