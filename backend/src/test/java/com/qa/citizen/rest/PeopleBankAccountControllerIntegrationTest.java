package com.qa.citizen.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.citizen.domain.Citizen;
import com.qa.citizen.rest.DTOs.AtmTransactionsDTO;
import com.qa.citizen.rest.DTOs.BankcardDTO;
import com.qa.citizen.rest.DTOs.EposTransactionsDTO;
import com.qa.citizen.rest.DTOs.PeopleBankAccountDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // loads the context
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PeopleBankAccountControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

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

	// PeopleBankAccountControllerIntegrationTest
	@Test
	public void testGetMatchingBankAccounts() throws Exception {

		// build a mock request
		RequestBuilder mockRequest = post("/getMatchingBankAccounts/").contentType(MediaType.APPLICATION_JSON)
				.content(createReceivedCitizenAsJSON());

		// return a list of PeopleBankAccountDTO objects that match the citizen object
		// passed
		List<PeopleBankAccountDTO> peopleBankAccountDTOList = new ArrayList<>();
		Set<BankcardDTO> bankCardDTOSet = new HashSet<>();

		Set<AtmTransactionsDTO> atmTransactionsDTOSet = new HashSet<>();
		AtmTransactionsDTO returnedAtmTransactionsDto = new AtmTransactionsDTO("2015-05-03T17:36:59.673",
				"Cash Withdrawal", 50.0, "Barclays Bank", "Poole Road", "BH4 9BB");
		atmTransactionsDTOSet.add(returnedAtmTransactionsDto);

		Set<EposTransactionsDTO> eposTransactionsDTOSet = new HashSet<>();
		EposTransactionsDTO returnedEposTransactionsDto = new EposTransactionsDTO("2015-05-01T18:00:53.615Z", 26.02,
				"Wash and Dry", "Seamoor Road", "BH4 9AE");
		eposTransactionsDTOSet.add(returnedEposTransactionsDto);

		BankcardDTO returnedBankCardDTO = new BankcardDTO("31-01-93", atmTransactionsDTOSet, eposTransactionsDTOSet);
		bankCardDTOSet.add(returnedBankCardDTO);
		PeopleBankAccountDTO returnedPeopleBankAccountDTO = new PeopleBankAccountDTO(bankCardDTOSet,
				"The Royal Bank of Scotland", 67875272L, "Michael Shane", "Cochrane");

		peopleBankAccountDTOList.add(returnedPeopleBankAccountDTO);

		// convert returned list to json
		String returnedListAsJSON = this.mapper.writeValueAsString(peopleBankAccountDTOList);

		// check status is 200 - OK
		ResultMatcher matchStatus = status().isOk();

		// check that response body is correct
		ResultMatcher matchBody = content().json(returnedListAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

}
