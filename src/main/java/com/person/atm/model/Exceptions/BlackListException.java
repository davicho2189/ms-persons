package com.person.atm.model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Error Persona Lista Negra")
public class BlackListException extends Exception{

    public BlackListException(){};

}