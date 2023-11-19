package com.assignit.coreservice.beans;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FeatureBean implements Serializable {

    @Expose
    private Long id;

    @Expose
    private String title;

    @Expose
    private String content;

    @Expose
    private String action;

    @Expose
    private String icon;
}
