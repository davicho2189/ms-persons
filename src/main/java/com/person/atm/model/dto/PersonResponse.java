package com.person.atm.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;
import java.io.Serializable;

@ApiModel("PersonResponse")
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
