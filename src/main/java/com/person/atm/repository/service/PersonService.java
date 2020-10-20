package com.person.atm.repository.service;

import com.person.atm.model.dto.PersonResponse;
import com.person.atm.model.entity.Person;
import com.person.atm.model.exceptions.BlackListException;
import com.person.atm.model.exceptions.PersonUpdateException;
import com.person.atm.repository.dao.PersonDao;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonService implements IPersonService {

  @Autowired
  private PersonDao personDao;

  @Override
  public Single<PersonResponse> findByDocument(String dni) throws Exception {

    try {
      Person person = personDao.findByDocument(dni);

      if (person.getBlacklist() == true) {
        throw new BlackListException();
      } else {
        return Single.just(person).map(this::toPersonResponse).subscribeOn(Schedulers.io());
      }
    } catch (Exception ex) {
      throw ex;
    }
  }

  /**
   * toPersonResponse parse model to dto.
   **/
  public PersonResponse toPersonResponse(Person person) throws Exception {
    PersonResponse personResponse = new PersonResponse();
    BeanUtils.copyProperties(personResponse, person);
    return personResponse;
  }

  @Override
  public void updatePersonFingerprint(Long id) throws Exception {

    Optional<Person> person = personDao.findById(id);
    
    if (person.isPresent()) {
      
      log.info("update ok");
      person.get().setFingerprint(true);
      personDao.save(person.get());
    } else {
      throw new PersonUpdateException();
    }
  }
}
