package com.person.service;

import com.person.model.Person;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {


  /**
   *
   * @param personId
   * @return {@link java.util.Optional} {@link Person} objects if present in database
   *         for supplied person ID
   */
  public Optional<Person> getPersonById(int personId);

}
