package com.person.atm.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_MODIFIED, reason = "Error al actualizar incorrecto")
public class PersonUpdateException extends Exception {

  /**
   * serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  public PersonUpdateException() {
  }

}