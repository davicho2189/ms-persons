package com.person.atm.controller;

import com.person.atm.model.dto.PersonResponse;
import com.person.atm.model.exceptions.DocumentErrorException;
import com.person.atm.repository.service.PersonService;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Person microservicio")
@RestController
@RequestMapping("core")
public class PersonController {

  @Autowired
  private PersonService personService;

  /**   
   * ApiOperation.
   **/
  @ApiOperation(value = "Obtener persona por dni ", response = PersonResponse.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
      @ApiResponse(code = 451, message = "Error Persona Lista Negra"),
      @ApiResponse(code = 406, message = "Error Dni incorrecto"),
      @ApiResponse(code = 404, message = "not found!!!") })
  @GetMapping("/persons/{documentNumber}")
  public Single<PersonResponse> getPerson(@PathVariable String documentNumber) throws Exception {

    try {

      if (!Pattern.compile("[0-9]{8}").matcher(documentNumber).matches()) {
        throw new DocumentErrorException();
      }
      return personService.findByDocument(documentNumber);

    } catch (Exception ex) {
      throw ex;
    }

  }
}
