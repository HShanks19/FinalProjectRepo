package com.qa.citizen.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.qa.citizen.domain.Citizen;
import com.qa.citizen.repo.CitizenRepo;

@DataJpaTest
@ActiveProfiles("test")
public class CitizenRepoTest {

	@Autowired
	private CitizenRepo repo;

	@Test
	public void testfindByForenames() {
		List<Citizen> citizenList = new ArrayList<Citizen>();
		Citizen citizen = new Citizen(9171862863L, "Michael Shane", "Cochrane", "37 SPUR HILL AVENUE, POOLE, BH14 9PJ",
				"1955-09-25", "LONDON", "Male");
		citizenList.add(citizen);

		assertThat(this.repo.findByForenames("Michael Shane")).containsAll(citizenList);
	}

}
