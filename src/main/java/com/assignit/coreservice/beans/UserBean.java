package com.assignit.coreservice.beans;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserBean implements Serializable {

    @Expose
    private String name;

    @Expose
    private String roleName;

    @Expose
    private String phone;

    @Expose
    private String email;

    @Expose
    private String status;
}
