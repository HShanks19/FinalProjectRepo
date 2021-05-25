package com.qa.citizen.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.rest.DTOs.BankcardDTO;
import com.qa.citizen.service.BankcardService;

@RestController
@CrossOrigin
public class BankcardController {

	private BankcardService service;

	public BankcardController(BankcardService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getBankcardsDTObyNumber/{cardNumber}")
	public BankcardDTO getCard(@PathVariable Long cardNumber) {
		return this.service.getDTO(cardNumber);
	}

}
