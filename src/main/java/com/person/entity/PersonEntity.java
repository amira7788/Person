package com.person.entity;

import com.person.model.Person;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "PERSON")
@NoArgsConstructor
public class PersonEntity implements Serializable {

  private static final long serialVersionUID = -8003246612943943723L;

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int personId;

  private String firstName;

  public Person toPerson(){
    return Person.builder().firstName(firstName).personId(personId).build();
  }
}
