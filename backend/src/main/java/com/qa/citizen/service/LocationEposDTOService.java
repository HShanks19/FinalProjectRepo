package com.qa.citizen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.Epos;
import com.qa.citizen.domain.EposTransactions;
import com.qa.citizen.rest.DTOs.LocationEposDTO;

@Service
public class LocationEposDTOService {

	public List<LocationEposDTO> getLocationEposDTOList(List<EposTransactions> eposTransactionList) {

		List<LocationEposDTO> locationEposDtoList = new ArrayList<>();

		for (EposTransactions transaction : eposTransactionList) {
			LocationEposDTO locationEposDto = new LocationEposDTO();
			locationEposDto.setTimestamp(transaction.getTimestamp());
			Epos epos = transaction.getId();
			Long eposId = epos.getId();
			locationEposDto.setId(eposId);
			locationEposDto.setVendor(epos.getVendor());
			locationEposDto.setStreetName(epos.getStreetName());
			locationEposDto.setPostcode(epos.getPostcode());
			locationEposDto.setLatitude(epos.getLatitude());
			locationEposDto.setLongitude(epos.getLongitude());
			locationEposDtoList.add(locationEposDto);
		}

		return locationEposDtoList;

	}

}
