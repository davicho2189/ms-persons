package com.person.atm.controller;

import com.person.atm.model.Exceptions.BlackListException;
import com.person.atm.model.Exceptions.DocumentErrorException;
import com.person.atm.model.dto.PersonResponse;
import com.person.atm.repository.service.PersonService;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.regex.Pattern;

@Slf4j
@RestController
@RequestMapping("core")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons/{documentNumber}")
    public Single<PersonResponse> GetPersonInfo(@PathVariable String documentNumber) throws Exception {

        try {

            if(!Pattern.compile("[0-9]{8}").matcher(documentNumber).matches())
                throw new DocumentErrorException();
            return personService.findByDocument( documentNumber);

        }catch(Exception ex){
            throw ex;
        }

    }
}
