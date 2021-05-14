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

}
