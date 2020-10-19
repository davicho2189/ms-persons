package com.person.atm.repository.dao;

import com.person.atm.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, Long> {

  Person findByDocument(String dni);
}
