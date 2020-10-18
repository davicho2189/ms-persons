package com.person.atm.model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, reason = "Error Persona Lista Negra")
public class BlackListException extends Exception{

    public BlackListException(){};

}