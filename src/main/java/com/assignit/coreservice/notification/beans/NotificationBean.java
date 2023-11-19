package com.assignit.coreservice.notification.beans;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class NotificationBean implements Serializable {
    @Expose
    private Long id;

    @Expose
    private Long userId;

    @Expose
    private Long projectId;

    @Expose
    private String content;

    @Expose
    private Date date;

    @Expose
    private Boolean favourite;
}
