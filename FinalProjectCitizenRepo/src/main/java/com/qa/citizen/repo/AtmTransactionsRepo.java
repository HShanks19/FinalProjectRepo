package com.qa.citizen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.citizen.domain.AtmTransaction;
import com.qa.citizen.domain.Bankcard;

@Repository
public interface AtmTransactionsRepo extends JpaRepository<AtmTransaction, Long>{

	List<AtmTransaction> findByBankCardNumber(Bankcard cardNumber);

}
