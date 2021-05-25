package com.qa.citizen.domain;

import org.junit.jupiter.api.Test;

import com.qa.citizen.rest.DTOs.AssociatesDTO;
import com.qa.citizen.rest.DTOs.AtmPointDTO;
import com.qa.citizen.rest.DTOs.AtmTransactionsDTO;
import com.qa.citizen.rest.DTOs.BankcardDTO;
import com.qa.citizen.rest.DTOs.CitizenDTO;
import com.qa.citizen.rest.DTOs.ColleaguesDTO;
import com.qa.citizen.rest.DTOs.EposDTO;
import com.qa.citizen.rest.DTOs.EposTransactionsDTO;
import com.qa.citizen.rest.DTOs.HouseholdDTO;
import com.qa.citizen.rest.DTOs.LocationAtmDTO;
import com.qa.citizen.rest.DTOs.LocationEposDTO;
import com.qa.citizen.rest.DTOs.MobileCallRecordsDTO;
import com.qa.citizen.rest.DTOs.PeopleBankAccountDTO;
import com.qa.citizen.rest.DTOs.PeopleMobileDTO;
import com.qa.citizen.rest.DTOs.VehicleRegistrationDTO;
import com.qa.citizen.rest.DTOs.WhereaboutsDTO;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CoverageTest {

	@Test
	public void testAssociatesDTO() {
		EqualsVerifier.simple().forClass(AssociatesDTO.class).verify();
	}

	@Test
	public void testAtmPointDTO() {
		EqualsVerifier.simple().forClass(AtmPointDTO.class).verify();
	}

	@Test
	public void testAtmTransactionsDTO() {
		EqualsVerifier.simple().forClass(AtmTransactionsDTO.class).verify();
	}

	@Test
	public void testBankcardDTO() {
		EqualsVerifier.simple().forClass(BankcardDTO.class).verify();
	}

	@Test
	public void testCitizenDTO() {
		EqualsVerifier.simple().forClass(CitizenDTO.class).verify();
	}

	@Test
	public void testColleaguesDTO() {
		EqualsVerifier.simple().forClass(ColleaguesDTO.class).verify();
	}

	@Test
	public void testEposDTO() {
		EqualsVerifier.simple().forClass(EposDTO.class).verify();
	}

	@Test
	public void testEposTransactionsDTO() {
		EqualsVerifier.simple().forClass(EposTransactionsDTO.class).verify();
	}

	@Test
	public void testHouseholdDTO() {
		EqualsVerifier.simple().forClass(HouseholdDTO.class).verify();
	}

	@Test
	public void LocationAtmDTO() {
		EqualsVerifier.simple().forClass(LocationAtmDTO.class).verify();
	}

	@Test
	public void testLocationEposDTO() {
		EqualsVerifier.simple().forClass(LocationEposDTO.class).verify();
	}

	@Test
	public void testMobileCallRecordsDTO() {
		EqualsVerifier.simple().forClass(MobileCallRecordsDTO.class).verify();
	}

	@Test
	public void testPeopleBankAccountDTO() {
		EqualsVerifier.simple().forClass(PeopleBankAccountDTO.class).verify();
	}

	@Test
	public void testPeopleMobileDTO() {
		EqualsVerifier.simple().forClass(PeopleMobileDTO.class).verify();
	}

	@Test
	public void testVehicleRegistrationDTO() {
		EqualsVerifier.simple().forClass(VehicleRegistrationDTO.class).verify();
	}

	@Test
	public void testWhereaboutsDTO() {
		EqualsVerifier.simple().forClass(WhereaboutsDTO.class).verify();
	}

}
