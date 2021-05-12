package com.qa.citizen.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.citizen.domain.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Long> {


}
