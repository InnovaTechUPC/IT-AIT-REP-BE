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
@Table(name = "AIT_FEATURES_TABLE")
public class Feature implements Serializable {

    @Id
    @Column(name = "AFT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AFT_TITLE")
    private String title;

    @Column(name = "AFT_CONTENT")
    private String content;

    @Column(name = "AFT_ACTION")
    private String action;

    @Column(name = "AFT_ICON")
    private String icon;
}
