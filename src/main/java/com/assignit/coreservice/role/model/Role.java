package com.assignit.coreservice.role.model;

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
@Table(name = "AIT_ROLE_TABLE")
public class Role implements Serializable {
    @Id
    @Column(name = "ART_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ART_NAME")
    private String name;

    @Column(name = "ART_CODE")
    private String code;
}

