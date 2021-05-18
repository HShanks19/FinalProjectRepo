package com.qa.citizen.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.citizen.domain.Epos;

@Repository
public interface EposRepo extends JpaRepository<Epos, Long>{


}
