package com.assignit.coreservice.ai.beans;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AiRestResponse implements Serializable {

    @Expose
    private String response;
}
