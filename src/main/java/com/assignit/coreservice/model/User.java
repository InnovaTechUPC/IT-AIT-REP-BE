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
    @Column(name = "AUT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ART_ID", referencedColumnName = "ART_ID", nullable = false)
    private Role role;

    @Column(name = "AUT_NAME")
    private String name;

    @Column(name = "AUT_PHONE")
    private String phone;

    @Column(name = "AUT_EMAIL")
    private String email;

    @Column(name = "AUT_STATUS")
    private String status;
}
