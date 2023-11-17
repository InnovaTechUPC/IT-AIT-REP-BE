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
@Table(name = "AIT_TASK_TABLE")
public class Task implements Serializable {

    @Id
    @Column(name = "ATT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AUT_ID", referencedColumnName = "AUT_ID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "APT_ID", referencedColumnName = "APT_ID", nullable = false)
    private Project project;

    @Column(name = "ATT_DESCRIPTION")
    private String description;

    @Column(name = "ATT_HOURS_PROGRESS")
    private Float hoursProgress;

    @Column(name = "ATT_HOURS_TOTAL")
    private Float hoursTotal;
}
