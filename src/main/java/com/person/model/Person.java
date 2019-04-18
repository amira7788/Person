package com.person.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements Serializable{

  private static final long serialVersionUID = 3570556679061270028L;

  private int personId;
  private String firstName;

}
