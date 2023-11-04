package com.assignit.coreservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Erikc-Cortez
 * @version 20-10-2023
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "AIT_USER_TABLE")
public class User implements Serializable {

    @Id
    @Column(name = "UT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UT_NAME")
    private String name;

    @Column(name = "UT_POINT")
    private Long points;
}
