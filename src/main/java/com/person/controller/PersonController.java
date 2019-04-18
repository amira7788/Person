package com.person.controller;

import com.person.model.Person;
import com.person.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/person")
@Api(tags = "test-api")
public class PersonController {

  @Autowired
  private PersonService personService;

  /**
   *
   * @param personId supplied as path variable
   * @return expose GET endpoint to return  {@link Person} for the supplied person id
   * return HTTP 404 in case person is not found in database
   */
  @GetMapping(value = "/{personId}")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Appel avec succès"),
      @ApiResponse(code = 400, message = "Erreur validation de surface/métier"),
      @ApiResponse(code = 500, message = "Erreur interne du serveur")
  })
  public Optional<Person> getPerson(@PathVariable("personId") int personId) {
    return personService.getPersonById(personId);
  }

}
