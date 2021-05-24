package com.qa.citizen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.citizen.domain.Citizen;

@Service
public class IntegrationTestService {

	@Autowired
	private ObjectMapper mapper;

	public String createReceivedCitizenAsJSON() throws Exception {

		// get passed something close to a citizen object
		// create passed Citizen
		Citizen passedCitizen = new Citizen();
		passedCitizen.setForenames("Michael Shane");
		passedCitizen.setSurname("Cochrane");

		// convert passed citizen object to json string
		String passedCitizenAsJSON = this.mapper.writeValueAsString(passedCitizen);

		return passedCitizenAsJSON;

	}

}
