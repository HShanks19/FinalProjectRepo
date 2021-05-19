package com.qa.citizen.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.Citizen;
import com.qa.citizen.rest.DTOs.CitizenDTO;
import com.qa.citizen.service.CitizenService;

@RestController
@CrossOrigin
public class CitizenController {

	private CitizenService service;

	public CitizenController(CitizenService service) {
		super();
		this.service = service;
	}

	@PostMapping("/getMatchingCitizens/")
	public ResponseEntity<List<Citizen>> sortAndFilterCitizens(@RequestBody Citizen citizen) {
		return ResponseEntity.ok(this.service.sortAndFilterCitizens(citizen));
	}

	@GetMapping("/getBiographicalInfo/{id}")
	public ResponseEntity<List<CitizenDTO>> sortAndFilterCitizensMapToDTO(@PathVariable Long id) {
		Citizen found = this.service.getCitizenById(id);
		return ResponseEntity.ok(this.service.sortAndFilterCitizensMapToDTO(found));
	}

}
