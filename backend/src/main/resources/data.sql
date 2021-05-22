INSERT INTO CITIZEN (citizenID, forenames, surname, home_address, date_of_birth, place_of_birth, sex) 
VALUES (9171862863,'Michael Shane', 'Cochrane', '37 SPUR HILL AVENUE, POOLE, BH14 9PJ', '1955-09-25', 'LONDON', 'Male');

INSERT INTO CITIZEN (citizenID, forenames, surname, home_address, date_of_birth, place_of_birth, sex) 
VALUES (3554464415,'Colin', 'Parsons', '37 SPUR HILL AVENUE, POOLE, BH14 9PJ', '1994-01-19', 'MANCHESTER', 'Male');

INSERT INTO PEOPLE_MOBILE (forenames, surname, date_of_birth, address, town, postcode, phone_number, network) 
VALUES ('Michael Shane', 'Cochrane', '1955-09-25', '37 SPUR HILL AVENUE', 'POOLE', 'BH14 9PJ', '07700 098484', 'O2');

INSERT INTO VEHICLE_REGISTRATION (registration_id, address, colour, date_of_birth, driver_licence_id, forenames, make, model, registration_date, surname, vehicle_registration_no) 
VALUES (131240, '37 SPUR HILL AVENUE, POOLE, BH14 9PJ', 'red', '1955-09-25', 'COCHR509255MS9RM 41', 'Michael Shane', 'Toyota', 'Yaris', '1999-01-16', 'Cochrane', 'UN28 EIN');

INSERT INTO PEOPLE_BUSINESS_ADDRESS (person_name, business_address, business_name, date_of_birth, home_address) 
VALUES ('Michael Shane Cochrane', 'Seamoor Road, BH4 9AE', 'Wash and Dry', '1955-09-25', '37 SPUR HILL AVENUE, POOLE, BH14 9PJ');

INSERT INTO PEOPLE_BUSINESS_ADDRESS (person_name, business_address, business_name, date_of_birth, home_address) 
VALUES ('Linda Lynda Anderson', 'Seamoor Road, BH4 9AE', 'Chop', '1959-05-06', '26 STEEPLE CLOSE, POOLE, BH17 9BJ');

INSERT INTO ATM_POINT (atm_id, operator, street_name, postcode, latitude, longitude)
VALUES (889, 'Barclays Bank', 'Poole Road', 'BH4 9BB', 50.7230678360432, -1.90339316505373);

INSERT INTO PEOPLE_BANK_ACCOUNT (bank_account_id, account_number, bank, forenames, surname, date_of_birth, home_address) 
VALUES (225907, 67875272, 'The Royal Bank of Scotland', 'Michael Shane', 'Cochrane', '1955-09-25', '37 SPUR HILL AVENUE, POOLE, BH14 9PJ');

INSERT INTO BANKCARD (bank_card_id, card_number, sort_code, bank_account_id, account_number, bank) 
VALUES (142222, 2139399399319671, '31-01-93', 225907, 67875272, 'The Royal Bank of Scotland');

INSERT INTO ATM_TRANSACTION (timestamp, amount, type, atm_id, bank_card_number) 
VALUES ('2015-05-03T17:36:59.673', 50.0, 'Cash Withdrawal', 889, 2139399399319671);

INSERT INTO EPOS (id, vendor, street_name, postcode, latitude, longitude)
VALUES (13657, 'Wash and Dry', 'Seamoor Road', 'BH4 9AE', 50.7224925556361, -1.90384768381408);

INSERT INTO EPOS_TRANSACTIONS (timestamp, epos_id, bank_card_number, payee_account, amount)
VALUES ('2015-05-01T18:00:53.615Z', 13657, 2139399399319671, 37234419, 26.02);

INSERT INTO MOBILE_CALL_RECORDS (timestamp, caller_MSISDN, call_cell_tower_id, receiver_MSISDN, receiver_tower_id)
VALUES ('2015-05-02T15:31:13.335', '07700 098484', 0, '07700 192766', 'Mathew Terry James');

