package com.assignit.coreservice.task.beans;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TaskBean implements Serializable {
    @Expose
    private Long id;

    @Expose
    private Long idUser;

    @Expose
    private Long idProject;

    @Expose
    private String description;

    @Expose
    private Float hoursProgress;

    @Expose
    private Float hoursTotal;

    @Expose
    private Boolean completed;
}
