package com.assignit.coreservice.ai.model;

import com.assignit.coreservice.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@Table(name = "AIT_AI_TABLE")
public class Ai implements Serializable {
    @Id
    @Column(name = "AAIT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AUT_ID", referencedColumnName = "AUT_ID", nullable = false)
    private User user;

    @Column(name = "AAIT_PROMPT")
    private String prompt;

    @Column(name = "AAIT_RESPONSE")
    private String code;
}