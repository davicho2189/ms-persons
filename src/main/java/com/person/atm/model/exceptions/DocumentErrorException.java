package com.person.atm.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Error Dni incorrecto")
public class DocumentErrorException extends Exception {

  /**
   * serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  public DocumentErrorException() {
  }

}