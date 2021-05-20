package com.qa.citizen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.citizen.domain.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Long> {

	List<Citizen> findByForenames(String forenames);

	List<Citizen> findBySurname(String surname);

	List<Citizen> findByHomeAddress(String address);

	List<Citizen> findByDateOfBirth(String dateOfBirth);

	List<Citizen> findByPlaceOfBirth(String placeOfBirth);

	List<Citizen> findBySex(String sex);


}
