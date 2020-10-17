package com.person.atm.model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Error Dni incorrecto")
public class DocumentErrorException extends Exception{

    public DocumentErrorException(){};

}