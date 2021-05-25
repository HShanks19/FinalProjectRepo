package com.qa.citizen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VehicleRegistration {

	public VehicleRegistration(Long registrationId, String registrationDate, String vehicleRegistrationNo, String make,
			String model, String colour, String forenames, String surname, String address, String dateOfBirth,
			String driverLicenceId) {
		super();
		this.registrationId = registrationId;
		this.registrationDate = registrationDate;
		this.vehicleRegistrationNo = vehicleRegistrationNo;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.forenames = forenames;
		this.surname = surname;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.driverLicenceId = driverLicenceId;
	}

	public VehicleRegistration() {
		super();
	}

	@Id
	@Column(name = "registration_id")
	private Long registrationId;

	@Column(name = "registration_date")
	private String registrationDate;

	@Column(name = "vehicle_registration_no")
	private String vehicleRegistrationNo;

	@Column(name = "make")
	private String make;

	@Column(name = "model")
	private String model;

	@Column(name = "colour")
	private String colour;

	@Column(name = "forenames")
	private String forenames;

	@Column(name = "surname")
	private String surname;

	@Column(name = "address")
	private String address;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@Column(name = "driver_licence_id")
	private String driverLicenceId;

	public Long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getVehicleRegistrationNo() {
		return vehicleRegistrationNo;
	}

	public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDriverLicenceId() {
		return driverLicenceId;
	}

	public void setDriverLicenceId(String driverLicenceId) {
		this.driverLicenceId = driverLicenceId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((driverLicenceId == null) ? 0 : driverLicenceId.hashCode());
		result = prime * result + ((forenames == null) ? 0 : forenames.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((registrationId == null) ? 0 : registrationId.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((vehicleRegistrationNo == null) ? 0 : vehicleRegistrationNo.hashCode());
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
		VehicleRegistration other = (VehicleRegistration) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (driverLicenceId == null) {
			if (other.driverLicenceId != null)
				return false;
		} else if (!driverLicenceId.equals(other.driverLicenceId))
			return false;
		if (forenames == null) {
			if (other.forenames != null)
				return false;
		} else if (!forenames.equals(other.forenames))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (registrationId == null) {
			if (other.registrationId != null)
				return false;
		} else if (!registrationId.equals(other.registrationId))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (vehicleRegistrationNo == null) {
			if (other.vehicleRegistrationNo != null)
				return false;
		} else if (!vehicleRegistrationNo.equals(other.vehicleRegistrationNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VehicleRegistration [registrationId=" + registrationId + ", registrationDate=" + registrationDate
				+ ", vehicleRegistrationNo=" + vehicleRegistrationNo + ", make=" + make + ", model=" + model
				+ ", colour=" + colour + ", forenames=" + forenames + ", surname=" + surname + ", address=" + address
				+ ", dateOfBirth=" + dateOfBirth + ", driverLicenceId=" + driverLicenceId + "]";
	}

}
