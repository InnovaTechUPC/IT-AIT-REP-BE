package com.assignit.coreservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Erikc-Cortez
 * @version 20-10-2023
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "AIT_PROJECT_TABLE")
public class Project implements Serializable {

    @Id
    @Column(name = "APT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "APT_NAME")
    private String name;

    @Column(name = "APT_DESCRIPTION")
    private String description;

    @Column(name = "APT_DATE")
    private Date date;

    @Column(name = "APT_STATUS")
    private String status;

    @Column(name = "APT_PROGRESS")
    private String progress;
}