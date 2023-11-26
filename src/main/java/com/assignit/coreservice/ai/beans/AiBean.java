package com.assignit.coreservice.ai.beans;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AiBean implements Serializable {
    @Expose
    private Long id;

    @Expose
    private Long userId;

    @Expose
    private String prompt;

    @Expose
    private String code;
}