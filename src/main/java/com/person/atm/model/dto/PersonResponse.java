package com.person.atm.model.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
