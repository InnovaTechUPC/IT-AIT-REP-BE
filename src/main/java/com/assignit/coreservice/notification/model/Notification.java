package com.assignit.coreservice.notification.model;

import com.assignit.coreservice.project.model.Project;
import com.assignit.coreservice.shared.parse.BooleanToStringConverter;
import com.assignit.coreservice.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "AIT_NOTIFICATION_TABLE")
public class Notification implements Serializable {
    @Id
    @Column(name = "ANT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AUT_ID", referencedColumnName = "AUT_ID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "APT_ID", referencedColumnName = "APT_ID", nullable = false)
    private Project project;

    @Column(name = "ANT_CONTENT")
    private String content;

    @Column(name = "ANT_PUBLISH_DATE")
    private Date date;

    @Column(name = "ANT_FAVOURITE")
    @Convert(converter = BooleanToStringConverter.class)
    private Boolean favourite;
}
