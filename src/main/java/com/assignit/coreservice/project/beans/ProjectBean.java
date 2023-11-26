package com.assignit.coreservice.project.beans;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ProjectBean implements Serializable {

    @Expose
    private Long id;

    @Expose
    private String name;

    @Expose
    private String description;

    @Expose
    private Date date;

    @Expose
    private String status;

    @Expose
    private String progress;

    @Expose
    private Long totalMembers;
}
