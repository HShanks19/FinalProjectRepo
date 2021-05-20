package com.qa.citizen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.AtmPoint;
import com.qa.citizen.domain.AtmTransaction;
import com.qa.citizen.rest.DTOs.LocationAtmDTO;

@Service
public class LocationAtmDTOService {

	public List<LocationAtmDTO> getLocationAtmDTOList(List<AtmTransaction> atmTransactionList) {

		List<LocationAtmDTO> locationAtmDtoList = new ArrayList<>();

		for (AtmTransaction transaction : atmTransactionList) {
			LocationAtmDTO locationAtmDto = new LocationAtmDTO();
			locationAtmDto.setTimestamp(transaction.getTimestamp());
			AtmPoint atmPoint = transaction.getAtmId();
			Long atmId = atmPoint.getAtmId();
			locationAtmDto.setAtmId(atmId);
			locationAtmDto.setOperator(atmPoint.getOperator());
			locationAtmDto.setStreetName(atmPoint.getStreetName());
			locationAtmDto.setPostcode(atmPoint.getPostcode());
			locationAtmDto.setLatitude(atmPoint.getLatitude());
			locationAtmDto.setLongitude(atmPoint.getLongitude());
			locationAtmDtoList.add(locationAtmDto);
		}

		return locationAtmDtoList;

	}

}
