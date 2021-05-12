package com.qa.citizen.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.citizen.domain.PeopleBankAccount;

@Repository
public interface PeopleBankAccountRepo extends JpaRepository<PeopleBankAccount, Long> {

}
