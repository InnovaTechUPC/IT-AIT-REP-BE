package com.assignit.coreservice.controller;

import com.google.gson.Gson;
import com.assignit.coreservice.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Log4j2
@Api
@RestController
@RequestMapping("/service/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Gson gson;
    @PostMapping("/{name}/{points}")
    public ResponseEntity<String> saveNameAndPoints(@PathVariable String name, @PathVariable Long points) {
        try {
            userService.savePoints(name, points);
            return new ResponseEntity<>(this.gson.toJson("ok"), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(gson.toJson("error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
