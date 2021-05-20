package com.qa.citizen.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.citizen.domain.PeopleBusinessAddress;

@Repository
public interface PeopleBusinessAddressRepo extends JpaRepository<PeopleBusinessAddress,Long> {

	Optional<PeopleBusinessAddress> findByPersonName(String name);

	List<PeopleBusinessAddress> findByBusinessAddress(String workplaceAddress);

}
