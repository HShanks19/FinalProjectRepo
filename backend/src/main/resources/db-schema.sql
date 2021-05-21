DROP TABLE IF EXISTS atm_point;

CREATE TABLE atm_point(
	atm_id BIGINT PRIMARY KEY,
	operator VARCHAR(255),
	street_name VARCHAR(255),
	postcode VARCHAR(255),
	latitude DOUBLE, 
	longitude DOUBLE
);

DROP TABLE IF EXISTS people_bank_account;

CREATE TABLE people_bank_account(
	bank_account_id BIGINT UNIQUE PRIMARY KEY,
	account_number BIGINT UNIQUE,
	bank VARCHAR(255),
	forenames VARCHAR(255),
	surname VARCHAR(255),
	date_of_birth VARCHAR(255),
	home_address VARCHAR(255)
);

DROP TABLE IF EXISTS bankcard;

CREATE TABLE bankcard(
	bank_card_id BIGINT UNIQUE PRIMARY KEY,
	card_number BIGINT UNIQUE,
	sort_code VARCHAR(255),
	bank_account_id BIGINT,
	account_number BIGINT,
	bank VARCHAR(255),
	FOREIGN KEY (account_number) REFERENCES people_bank_account(account_number)
);

DROP TABLE IF EXISTS atm_transaction;

CREATE TABLE atm_transaction(
	timestamp VARCHAR(255),
	atm_id BIGINT, 
	bank_card_number BIGINT,
	type VARCHAR(255),
	amount DOUBLE,
	FOREIGN KEY (atm_id) REFERENCES atm_point(atm_id),
	FOREIGN KEY (bank_card_number) REFERENCES bankcard(card_number)
);

DROP TABLE IF EXISTS epos;

CREATE TABLE epos(
	id BIGINT UNIQUE PRIMARY KEY,
	vendor VARCHAR(255),
	street_name VARCHAR(255),
	postcode VARCHAR(255),
	latitude DOUBLE,
	longitude DOUBLE
);

DROP TABLE IF EXISTS epos_transactions;

CREATE TABLE epos_transactions(
	timestamp VARCHAR(255),
	epos_id BIGINT,
	bank_card_number BIGINT,
	payee_account BIGINT,
	amount DOUBLE,
	FOREIGN KEY (epos_id) REFERENCES epos(id),
	FOREIGN KEY (bank_card_number) REFERENCES bankcard(card_number)
);

DROP TABLE IF EXISTS citizen;

CREATE TABLE citizen(
	citizenID BIGINT PRIMARY KEY,
	forenames VARCHAR(255),
	surname VARCHAR(255),
	home_address VARCHAR(255),
	date_of_birth VARCHAR(255),
	place_of_birth VARCHAR(255),
	sex VARCHAR(255)
);

CREATE TABLE people_business_address(
	person_name VARCHAR(255),
	home_address VARCHAR(255),
	date_of_birth VARCHAR(255),
	business_name VARCHAR(255),
	business_address VARCHAR(255)
);

DROP TABLE IF EXISTS people_mobile;

CREATE TABLE people_mobile(
	forenames VARCHAR(255),
	surname VARCHAR(255),
	date_of_birth VARCHAR(255),
	address VARCHAR(255),
	town VARCHAR(255),
	postcode VARCHAR(255),
	phone_number VARCHAR(255) UNIQUE,
	network VARCHAR(255)
);

DROP TABLE IF EXISTS mobile_call_records;

CREATE TABLE mobile_call_records(
	timestamp VARCHAR(255),
	caller_MSISDN VARCHAR(255),
	call_cell_tower_id BIGINT,
	receiver_MSISDN VARCHAR(255),
	receiver_tower_id BIGINT,
	FOREIGN KEY (caller_MSISDN) REFERENCES people_mobile(phone_number),
	FOREIGN KEY (receiver_MSISDN) REFERENCES people_mobile(phone_number)
);

DROP TABLE IF EXISTS vehicle_registration;

CREATE TABLE vehicle_registration(
	registration_id BIGINT PRIMARY KEY,
	registration_date VARCHAR(255),
	vehicle_registration_no VARCHAR(255),
	make VARCHAR(255),
	model VARCHAR(255),
	colour VARCHAR(255),
	forenames VARCHAR(255),
	surname VARCHAR(255),
	address VARCHAR(255),
	date_of_birth VARCHAR(255),
	driver_licence_id VARCHAR(255)
);