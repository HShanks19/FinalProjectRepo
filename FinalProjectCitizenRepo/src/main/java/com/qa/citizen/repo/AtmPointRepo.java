package com.qa.citizen.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.citizen.domain.AtmPoint;



@Repository
public interface AtmPointRepo extends JpaRepository<AtmPoint, Long>{

	

}
