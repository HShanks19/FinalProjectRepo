package com.qa.citizen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.citizen.domain.Bankcard;

@Repository
public interface BankcardRepo extends JpaRepository<Bankcard, Long> {

	List<Bankcard> findByAccountNumber(Long bankAccount);

	@Query(value = "SELECT * from bankcard WHERE bank_account_id = ?1", nativeQuery = true)
	Bankcard findByBankAccountId(Long id);

	List<Bankcard> findByBankCardId(Long bankCardId);

	Bankcard findByCardNumber(Long id);

}
