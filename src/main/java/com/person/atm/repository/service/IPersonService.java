package com.person.atm.repository.service;

import com.person.atm.model.dto.PersonResponse;
import io.reactivex.Single;

public interface IPersonService {

  public Single<PersonResponse> findByDocument(String dni) throws Exception;
  
  public void updatePersonFingerprint(Long dni) throws Exception;
}
