package com.assignit.coreservice.controller;

import com.assignit.coreservice.beans.ProjectBean;
import com.assignit.coreservice.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Api
@RestController
@RequestMapping("/service/project")
@Tag(name = "ProjectController", description = "Project EndPoint")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: ", e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long projectId) {
        try {
            return new ResponseEntity<>(projectService.getById(projectId), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: ", e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createProject(@RequestBody ProjectBean projectBean) {
        try {
            projectService.createProject(projectBean);
            return new ResponseEntity<>("created", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProject(@PathVariable("id") Long projectId, @RequestBody ProjectBean projectBean) {
        try {
            projectService.updateProject(projectId, projectBean);
            return new ResponseEntity<>("updated", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long projectId) {
        try {
            projectService.deleteProject(projectId);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
