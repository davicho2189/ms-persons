package com.person.atm.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name="person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="name_person")
    private String namePerson;
    private String document;
    @Column(name="finger_print")
    private Boolean fingerprint;
    @Column(name="black_list")
    private Boolean blacklist;
}
