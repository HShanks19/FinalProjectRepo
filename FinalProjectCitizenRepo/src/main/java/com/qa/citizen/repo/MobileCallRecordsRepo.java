package com.qa.citizen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.citizen.domain.MobileCallRecords;

@Repository
public interface MobileCallRecordsRepo extends JpaRepository<MobileCallRecords, Long>{

	List<MobileCallRecords> findByCallerMSISDN(String callerMSISDN);
	

}
