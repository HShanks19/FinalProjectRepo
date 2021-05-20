package com.qa.citizen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.citizen.domain.Bankcard;
import com.qa.citizen.domain.EposTransactions;

@Repository
public interface EposTransactionsRepo extends JpaRepository<EposTransactions, Long> {

	List<EposTransactions> findByBankCardNumber(Bankcard bankCardNumber);

}
