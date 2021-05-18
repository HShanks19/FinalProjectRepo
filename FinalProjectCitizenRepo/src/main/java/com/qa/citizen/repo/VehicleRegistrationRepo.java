package com.qa.citizen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.citizen.domain.VehicleRegistration;

@Repository
public interface VehicleRegistrationRepo extends JpaRepository<VehicleRegistration, Long> {

	List<VehicleRegistration> findByForenamesAndSurnameAndDateOfBirth(String forenames, String surname, String dob);

}
