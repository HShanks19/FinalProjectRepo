package com.qa.citizen.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This citizen does not exist")
public class CitizenNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2519610375373176724L;

}
