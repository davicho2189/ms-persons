package com.person.atm.controller;

import com.person.atm.model.Exceptions.DocumentErrorException;
import com.person.atm.model.dto.PersonResponse;
import com.person.atm.repository.service.PersonService;
import io.reactivex.Single;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

@Api(value = "Person microservicio" )
@Slf4j
@RestController
@RequestMapping("core")
public class PersonController {

    @Autowired
    private PersonService personService;


    @ApiOperation(value = "Obtener persona por dni ", response = PersonResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 451, message = "Error Persona Lista Negra"),
            @ApiResponse(code = 406, message = "Error Dni incorrecto"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/persons/{documentNumber}")
    public Single<PersonResponse> GetPerson(
            @PathVariable String documentNumber
    ) throws Exception {

        try {

            if(!Pattern.compile("[0-9]{8}").matcher(documentNumber).matches())
                throw new DocumentErrorException();
            return personService.findByDocument( documentNumber);

        }catch(Exception ex){
            throw ex;
        }

    }
}
