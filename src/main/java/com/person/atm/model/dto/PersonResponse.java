package com.person.atm.model.dto;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String document;
  private Boolean fingerprint;
  private Boolean blacklist;

}
