package com.qa.citizen.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.Citizen;
import com.qa.citizen.rest.DTOs.WhereaboutsDTO;
import com.qa.citizen.service.WhereaboutsDTOService;

@RestController
@CrossOrigin
public class WhereaboutsDTOController {

	WhereaboutsDTOService service;

	public WhereaboutsDTOController(WhereaboutsDTOService service) {
		super();
		this.service = service;
	}

	@PostMapping("/getWhereabouts/")
	public ResponseEntity<List<WhereaboutsDTO>> getWhereabouts(@RequestBody Citizen citizen) {
		return ResponseEntity.ok(this.service.getWhereabouts(citizen));
	}

}
