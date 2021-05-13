package com.qa.citizen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.Citizen;
import com.qa.citizen.repo.CitizenRepo;

@Service
public class CitizenService {

	private CitizenRepo repo;

	public CitizenService(CitizenRepo repo) {
		super();
		this.repo = repo;
	}

	public List<Citizen> getCitizen() {
		return this.repo.findAll();
	}

	public Citizen getCitizenById(Long id) {
		Optional<Citizen> optCitizen = this.repo.findById(id);
		return optCitizen.get();
	}

	public List<Citizen> findCitizenByCompleteSearch(Citizen citizen) {

		// Counter
		int numOfpassedValues = 0;

		boolean forenameBlank = citizen.getForenames().isBlank();
		boolean surnameBlank = citizen.getSurname().isBlank();
		boolean addressBlank = citizen.getHomeAddress().isBlank();
		boolean dobBlank = citizen.getDateOfBirth().isBlank();
		boolean pobBlank = citizen.getPlaceOfBirth().isBlank();

		String forenames = citizen.getForenames();
		String surname = citizen.getSurname();
		String address = citizen.getHomeAddress();
		String dob = citizen.getDateOfBirth();
		String pob = citizen.getPlaceOfBirth();

		// List to be returned to User
		List<Citizen> generatedList = new ArrayList<>();

		boolean[] values = { forenameBlank, surnameBlank, addressBlank, dobBlank, pobBlank };

		// Determine how many non null values have been passed by the user
		for (boolean value : values) {
			if (value == !true) {
				numOfpassedValues++;
				System.out.println(numOfpassedValues);
			}
		}

		// Run if the user has passed in all values
		if (!forenameBlank && !surnameBlank && !addressBlank && !dobBlank && !pobBlank) {
			generatedList = this.repo.findCitizenByForenamesAndSurnameAndHomeAddressAndDateOfBirthAndPlaceOfBirth(
					forenames, surname, address, dob, pob);
		}

		// If 4 values have been passed by the user
		if (numOfpassedValues == 4 && forenameBlank) {
			generatedList = this.repo.findBySurnameAndHomeAddressAndDateOfBirthAndPlaceOfBirth(surname, address, dob,
					pob);
		} else if (numOfpassedValues == 4 && surnameBlank) {
			generatedList = this.repo.findByForenamesAndHomeAddressAndDateOfBirthAndPlaceOfBirth(forenames, address,
					dob, pob);
		} else if (numOfpassedValues == 4 && addressBlank) {
			generatedList = this.repo.findByForenamesAndSurnameAndDateOfBirthAndPlaceOfBirth(forenames, surname, dob,
					pob);
		} else if (numOfpassedValues == 4 && dobBlank) {
			generatedList = this.repo.findByForenamesAndSurnameAndAddressAndPlaceOfBirth(forenames, surname, address,
					pob);
		} else if (numOfpassedValues == 4 && pobBlank) {
			generatedList = this.repo.findByForenamesAndSurnameAndAddressAndDateOfBirth(forenames, surname, address,
					dob);
		}

		// If 3 Values have been passed by the user
		if (numOfpassedValues == 3 && forenameBlank) {

			if (surnameBlank) {
				generatedList = this.repo.findByHomeAddressAndDateOfBirthAndPlaceOfBirth(address, dob, pob);
			} else if (addressBlank) {
				generatedList = this.repo.findBySurnameAndDateOfBirthAndPlaceOfBirth(surname, dob, pob);
			} else if (dobBlank) {
				generatedList = this.repo.findBySurnameAndHomeAddressAndPlaceOfBirth(surname, address, pob);
			} else if (pobBlank) {
				generatedList = this.repo.findBySurnameAndHomeAddressAndDateOfBirth(surname, address, dob);
			}

		} else if (numOfpassedValues == 3 && surnameBlank) {

			if (addressBlank) {
				generatedList = this.repo.findByForenamesAndDateOfBirthAndPlaceOfBirth(forenames, dob, pob);
			} else if (dobBlank) {
				generatedList = this.repo.findByForenamesAndHomeAddressAndPlaceOfBirth(forenames, address, pob);
			} else if (pobBlank) {
				generatedList = this.repo.findByForenamesAndHomeAddressAndDateOfBirth(forenames, address, dob);
			}

		} else if (numOfpassedValues == 3 && addressBlank) {

			if (dobBlank) {
				generatedList = this.repo.findByForenamesAndSurnameAndPlaceOfBirth(forenames, surname, pob);
			} else if (pobBlank) {
				generatedList = this.repo.findByForenamesAndSurnameAndDateOfBirth(forenames, surname, dob);
			}

		} else if (numOfpassedValues == 3 && dobBlank) {

			if (pobBlank) {
				generatedList = this.repo.findByForenamesAndSurnameAndHomeAddress(forenames, surname, address);
			}

		}

		// If 2 Values have been passed by the user
		if (numOfpassedValues == 2 && !forenameBlank) {

			if (!surnameBlank) {
				generatedList = this.repo.findByForenamesAndSurname(forenames, surname);
			} else if (!addressBlank) {
				generatedList = this.repo.findByForenamesAndHomeAddress(forenames, address);
			} else if (!dobBlank) {
				generatedList = this.repo.findByForenamesAndDateOfBirth(forenames, dob);
			} else if (!pobBlank) {
				generatedList = this.repo.findByForenamesAndPlaceOfBirth(forenames, pob);
			}

		} else if (numOfpassedValues == 2 && !surnameBlank) {

			if (!addressBlank) {
				generatedList = this.repo.findBySurnameAndHomeAddress(surname, address);
			} else if (!dobBlank) {
				generatedList = this.repo.findBySurnameAndDateOfBirth(surname, dob);
			} else if (!pobBlank) {
				generatedList = this.repo.findBySurnameAndPlaceOfBirth(surname, dob);
			}
		} else if (numOfpassedValues == 2 && !addressBlank) {

			if (!dobBlank) {
				generatedList = this.repo.findByHomeAddressAndDateOfBirth(address, dob);
			} else if (!pobBlank) {
				generatedList = this.repo.findByHomeAddressAndPlaceOfBirth(address, dob);
			}

		} else if (numOfpassedValues == 2 && !dobBlank) {
			generatedList = this.repo.findByDateOfBirthAndPlaceOfBirth(dob, pob);
		}

		// If 1 Value have been passed by the user
		if (!forenameBlank) {
			generatedList = this.repo.findByForenames(forenames);
		} else if (!surnameBlank) {
			generatedList = this.repo.findBySurname(surname);
		} else if (!addressBlank) {
			this.repo.findByHomeAddress(address);
		} else if (!dobBlank) {
			this.repo.findByDateOfBirth(dob);
		} else if (!pobBlank) {
			this.repo.findByPlaceOfBirth(pob);
		}

		return generatedList;

	}

}
