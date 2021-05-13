package com.qa.citizen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.citizen.domain.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Long> {

	// All Values passed by User
	@Query(value = "SELECT * from Citizen WHERE forenames = ?1 and surname = ?2 and home_address = ?3 and date_of_birth = ?4 and place_of_birth = ?5", nativeQuery = true)
	List<Citizen> findCitizenByForenamesAndSurnameAndHomeAddressAndDateOfBirthAndPlaceOfBirth(String forenames,
			String surname, String address, String dob, String pob);

	// 4 Values passed by User
	@Query(value = "SELECT * from Citizen WHERE surname = ?1 and home_address = ?2 and date_of_birth = ?3 and place_of_birth = ?4", nativeQuery = true)
	List<Citizen> findBySurnameAndHomeAddressAndDateOfBirthAndPlaceOfBirth(String surname, String address, String dob,
			String pob);

	@Query(value = "SELECT * from Citizen WHERE forenames = ?1 and home_address = ?2 and date_of_birth = ?3 and place_of_birth = ?4", nativeQuery = true)
	List<Citizen> findByForenamesAndHomeAddressAndDateOfBirthAndPlaceOfBirth(String forenames, String address,
			String dob, String pob);

	@Query(value = "SELECT * from Citizen WHERE forenames = ?1 and surname = ?2 and date_of_birth = ?3 and place_of_birth = ?4", nativeQuery = true)
	List<Citizen> findByForenamesAndSurnameAndDateOfBirthAndPlaceOfBirth(String forenames, String surname, String dob,
			String pob);

	@Query(value = "SELECT * from Citizen WHERE forenames = ?1 and surname = ?2 and home_address = ?3 and place_of_birth = ?4", nativeQuery = true)
	List<Citizen> findByForenamesAndSurnameAndAddressAndPlaceOfBirth(String forenames, String surname, String address,
			String pob);

	@Query(value = "SELECT * from Citizen WHERE forenames = ?1 and surname = ?2 and home_address = ?3 and date_of_birth = ?4", nativeQuery = true)
	List<Citizen> findByForenamesAndSurnameAndAddressAndDateOfBirth(String forenames, String surname, String address,
			String dob);

	// 3 Values passed by User
	@Query(value = "SELECT * from Citizen WHERE home_address = ?1 and date_of_birth = ?2 and place_of_birth = ?3", nativeQuery = true)
	List<Citizen> findByHomeAddressAndDateOfBirthAndPlaceOfBirth(String address, String dob, String pob);

	List<Citizen> findBySurnameAndDateOfBirthAndPlaceOfBirth(String surname, String dob, String pob);

	List<Citizen> findBySurnameAndHomeAddressAndPlaceOfBirth(String surname, String address, String pob);

	List<Citizen> findBySurnameAndHomeAddressAndDateOfBirth(String surname, String address, String dob);

	List<Citizen> findByForenamesAndDateOfBirthAndPlaceOfBirth(String forenames, String dob, String pob);

	List<Citizen> findByForenamesAndHomeAddressAndPlaceOfBirth(String forenames, String address, String pob);

	List<Citizen> findByForenamesAndHomeAddressAndDateOfBirth(String forenames, String address, String dob);

	List<Citizen> findByForenamesAndSurnameAndPlaceOfBirth(String forenames, String surname, String pob);

	List<Citizen> findByForenamesAndSurnameAndDateOfBirth(String forenames, String surname, String dob);

	List<Citizen> findByForenamesAndSurnameAndHomeAddress(String forenames, String surname, String address);

	// 2 Values passed by User
	List<Citizen> findByForenamesAndSurname(String forenames, String surname);

	List<Citizen> findByForenamesAndHomeAddress(String forenames, String address);

	List<Citizen> findByForenamesAndDateOfBirth(String forenames, String dob);

	List<Citizen> findByForenamesAndPlaceOfBirth(String forenames, String pob);

	List<Citizen> findBySurnameAndHomeAddress(String surname, String address);

	List<Citizen> findBySurnameAndDateOfBirth(String surname, String dob);

	List<Citizen> findBySurnameAndPlaceOfBirth(String surname, String dob);

	List<Citizen> findByHomeAddressAndDateOfBirth(String address, String dob);

	List<Citizen> findByHomeAddressAndPlaceOfBirth(String address, String dob);

	List<Citizen> findByDateOfBirthAndPlaceOfBirth(String dob, String pob);

	// 1 Value passed by User
	List<Citizen> findByForenames(String forenames);

	List<Citizen> findBySurname(String surname);

	List<Citizen> findByHomeAddress(String address);

	List<Citizen> findByDateOfBirth(String dateOfBirth);

	List<Citizen> findByPlaceOfBirth(String placeOfBirth);

	List<Citizen> findBySex(String sex);

}
