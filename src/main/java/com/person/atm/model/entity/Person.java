package com.person.atm.model.entity;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("person")
@Data
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name_person")
  private String namePerson;
  private String document;
  @Column(name = "finger_print")
  private Boolean fingerprint;
  @Column(name = "black_list")
  private Boolean blacklist;
}
