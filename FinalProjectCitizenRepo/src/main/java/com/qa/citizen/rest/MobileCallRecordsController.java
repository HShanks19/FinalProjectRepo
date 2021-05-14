package com.qa.citizen.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.MobileCallRecords;
import com.qa.citizen.service.MobileCallRecordsService;

@RestController
@CrossOrigin
public class MobileCallRecordsController {

	private MobileCallRecordsService service;

	public MobileCallRecordsController(MobileCallRecordsService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getMobileCallRecords/{phoneNumber}")
	public List<MobileCallRecords> getCallsByPhoneNumber(@PathVariable String phoneNumber) {
		return this.service.getCallsByPhoneNumber(phoneNumber);
	}

	@PostMapping("/getAllMobileCallRecords/")
	public ResponseEntity<List<MobileCallRecords>> sortAndFilterMobileCallRecords(
			@RequestBody MobileCallRecords mobileCallRecords) {
		return ResponseEntity.ok(this.service.sortAndFilterMobileCallRecords(mobileCallRecords));
	}

}
