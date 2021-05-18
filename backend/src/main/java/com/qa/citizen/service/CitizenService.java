package com.qa.citizen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.qa.citizen.domain.Citizen;
import com.qa.citizen.domain.PeopleMobile;
import com.qa.citizen.domain.VehicleRegistration;
import com.qa.citizen.repo.CitizenRepo;
import com.qa.citizen.rest.DTOs.CitizenDTO;
import com.qa.citizen.rest.DTOs.PeopleMobileDTO;
import com.qa.citizen.rest.DTOs.VehicleRegistrationDTO;

@Service
public class CitizenService {

	private CitizenRepo repo;

	private PeopleMobileService peopleMobileService;

	private VehicleRegistrationService vehicleRegistrationService;

	public CitizenService(CitizenRepo repo, PeopleMobileService peopleMobileService,
			VehicleRegistrationService vehicleRegistrationService) {
		super();
		this.repo = repo;
		this.peopleMobileService = peopleMobileService;
		this.vehicleRegistrationService = vehicleRegistrationService;
	}

	public List<Citizen> getCitizen() {
		return this.repo.findAll();
	}

	public Citizen getCitizenById(Long id) {
		Optional<Citizen> optCitizen = this.repo.findById(id);
		return optCitizen.get();
	}

	public List<Citizen> sortAndFilterCitizens(Citizen citizen) {
		return this.repo.findAll(Example.of(citizen));
	}

	public List<VehicleRegistrationDTO> mapToVehicleRegistrationDTO(List<VehicleRegistration> vehicleRegistration) {

		List<VehicleRegistrationDTO> vehicleRegistrationDTOList = new ArrayList<>();

		for (VehicleRegistration foundvehicle : vehicleRegistration) {
			VehicleRegistrationDTO vehicleRegistrationDTO = new VehicleRegistrationDTO();
			vehicleRegistrationDTO.setColour(foundvehicle.getColour());
			vehicleRegistrationDTO.setMake(foundvehicle.getMake());
			vehicleRegistrationDTO.setModel(foundvehicle.getModel());
			vehicleRegistrationDTO.setRegistrationDate(foundvehicle.getRegistrationDate());
			vehicleRegistrationDTO.setVehicleRegistrationNo(foundvehicle.getVehicleRegistrationNo());

			vehicleRegistrationDTOList.add(vehicleRegistrationDTO);

		}

		return vehicleRegistrationDTOList;

	}

	public List<PeopleMobileDTO> mapToPeopleMobileDTO(List<PeopleMobile> peopleMobile) {

		List<PeopleMobileDTO> peopleMobileDTOList = new ArrayList<>();

		for (PeopleMobile foundMobile : peopleMobile) {
			PeopleMobileDTO peopleMobileDTO = new PeopleMobileDTO();
			peopleMobileDTO.setPhoneNumber(foundMobile.getPhoneNumber());
			peopleMobileDTO.setNetwork(foundMobile.getNetwork());
			peopleMobileDTOList.add(peopleMobileDTO);

		}

		return peopleMobileDTOList;

	}

	public List<CitizenDTO> mapToCitizenDTO(List<Citizen> citizenList) {
		List<CitizenDTO> foundCitizens = new ArrayList<>();

		for (Citizen foundCitizen : citizenList) {
			CitizenDTO citizenDTO = new CitizenDTO();
			citizenDTO.setForenames(foundCitizen.getForenames());
			citizenDTO.setSurname(foundCitizen.getSurname());
			citizenDTO.setHomeAddress(foundCitizen.getHomeAddress());
			citizenDTO.setDateOfBirth(foundCitizen.getDateOfBirth());
			citizenDTO.setPlaceOfBirth(foundCitizen.getPlaceOfBirth());
			citizenDTO.setSex(foundCitizen.getSex());

			List<PeopleMobile> peopleMobile = this.peopleMobileService.getMobileByCitizen(foundCitizen.getForenames(),
					foundCitizen.getSurname(), foundCitizen.getDateOfBirth());

			List<VehicleRegistration> vehicleRegistration = this.vehicleRegistrationService.getVehicleByCitizen(
					foundCitizen.getForenames(), foundCitizen.getSurname(), foundCitizen.getDateOfBirth());

			citizenDTO.setCitizensMobileNumbers(this.mapToPeopleMobileDTO(peopleMobile));
			citizenDTO.setCitizensVehicles(this.mapToVehicleRegistrationDTO(vehicleRegistration));

			foundCitizens.add(citizenDTO);
		}

		return foundCitizens;
	}

	public List<CitizenDTO> sortAndFilterCitizensMapToDTO(Citizen citizen) {
		List<Citizen> citizenList = this.repo.findAll(Example.of(citizen));
		return this.mapToCitizenDTO(citizenList);
	}

}
