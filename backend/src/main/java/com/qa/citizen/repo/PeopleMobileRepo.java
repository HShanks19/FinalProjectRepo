package com.qa.citizen.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.citizen.domain.PeopleMobile;

@Repository
public interface PeopleMobileRepo extends JpaRepository<PeopleMobile, Long>{

	PeopleMobile findByPhoneNumber(String phoneNumber);
}
