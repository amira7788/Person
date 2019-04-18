package com.person.service.impl;

import com.person.model.Person;
import com.person.repository.PersonRepository;
import com.person.service.PersonService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository personRepo;

  @Override
  public Optional<Person> getPersonById(int personId) {
    return  personRepo.findById(personId).map(s ->  s.toPerson());
  }
}
