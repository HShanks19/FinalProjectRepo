package com.qa.citizen.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import com.qa.citizen.rest.DTOs.LocationAtmDTO;
import com.qa.citizen.rest.DTOs.LocationEposDTO;
import com.qa.citizen.rest.DTOs.WhereaboutsDTO;
import com.qa.citizen.service.IntegrationTestService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // loads the context
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class WhereaboutsDTOControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private IntegrationTestService service;

	// WhereaboutsDTOControllerIntegrationTest
	@Test
	public void testGetWhereabouts() throws Exception {

		// build a mock request
		RequestBuilder mockRequest = post("/getWhereabouts/").contentType(MediaType.APPLICATION_JSON)
				.content(service.createReceivedCitizenAsJSON());

		// return a list of WhereaboutsDTO objects that match the citizen object
		List<WhereaboutsDTO> whereaboutsDTOList = new ArrayList<>();

		List<LocationAtmDTO> locationATMDTOList = new ArrayList<>();
		LocationAtmDTO returnedLocationAtmDto = new LocationAtmDTO("2015-05-03T17:36:59.673", 889L, "Barclays Bank",
				"Poole Road", "BH4 9BB", 50.7230678360432, -1.90339316505373);
		locationATMDTOList.add(returnedLocationAtmDto);

		List<LocationEposDTO> locationEposDTOList = new ArrayList<>();
		LocationEposDTO returnedLocationEposDTO = new LocationEposDTO("2015-05-01T18:00:53.615Z", 13657L,
				"Wash and Dry", "Seamoor Road", "BH4 9AE", 50.7224925556361, -1.90384768381408);
		locationEposDTOList.add(returnedLocationEposDTO);

		WhereaboutsDTO whereaboutsDTO = new WhereaboutsDTO(225907L, 2139399399319671L, locationATMDTOList,
				locationEposDTOList);

		whereaboutsDTOList.add(whereaboutsDTO);

		// convert returned list to json
		String returnedListAsJSON = this.mapper.writeValueAsString(whereaboutsDTOList);

		// check status is 200 - OK
		ResultMatcher matchStatus = status().isOk();

		// check that response body is correct
		ResultMatcher matchBody = content().json(returnedListAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

}
