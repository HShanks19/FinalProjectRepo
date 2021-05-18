package com.qa.citizen.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.citizen.domain.VehicleRegistration;


@Repository
public interface VehicleRegistrationRepo extends JpaRepository<VehicleRegistration, Long> {

}
