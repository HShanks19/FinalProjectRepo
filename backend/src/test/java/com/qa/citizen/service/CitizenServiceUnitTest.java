package com.qa.citizen.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.citizen.domain.Citizen;
import com.qa.citizen.repo.CitizenRepo;

@SpringBootTest
@ActiveProfiles("test")
public class CitizenServiceUnitTest {

	@Autowired
	private CitizenService citizenService;

	@MockBean
	private CitizenRepo citizenRepo;

	@Test
	public void testGetCitizen() {

		List<Citizen> returnedCitizenList = new ArrayList<>();

		Citizen michael = new Citizen(9171862863L, "Michael Shane", "Cochrane", "37 SPUR HILL AVENUE, POOLE, BH14 9PJ",
				"1955-09-25", "LONDON", "Male");
		Citizen mathew = new Citizen(1647328256L, "Mathew Terry", "James", "8 SUMMERFIELDS, BOURNEMOUTH, BH7 7RN",
				"1958-08-18", "COATBRIDGE", "Male");
		Citizen colin = new Citizen(3554464415L, "Colin", "Parsons", "37 SPUR HILL AVENUE, POOLE, BH14 9PJ",
				"1994-01-19", "MANCHESTER", "Male");

		returnedCitizenList.add(michael);
		returnedCitizenList.add(mathew);
		returnedCitizenList.add(colin);

		Mockito.when(this.citizenRepo.findAll()).thenReturn(returnedCitizenList);

		assertThat(this.citizenService.getCitizen()).isEqualTo(returnedCitizenList);

	}

}
