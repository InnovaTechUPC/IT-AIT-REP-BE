package com.assignit.coreservice.controller;

import com.assignit.coreservice.beans.TaskBean;
import com.assignit.coreservice.service.TaskService;
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
@RequestMapping("/service/task")
@Tag(name = "TaskController", description = "Task EndPoint")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: ", e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long taskId) {
        try {
            return new ResponseEntity<>(taskService.getById(taskId), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: ", e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<?> findTasksByIdProject(@PathVariable("id") Long idProject) {
        try {
            return new ResponseEntity<>(taskService.getTasksByIdProject(idProject), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: ", e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createTask(@RequestBody TaskBean taskBean) {
        try {
            taskService.createTask(taskBean);
            return new ResponseEntity<>("created", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable("id") Long taskId, @RequestBody TaskBean taskBean) {
        try {
            taskService.updateTask(taskId, taskBean);
            return new ResponseEntity<>("updated", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long taskId) {
        try {
            taskService.deleteTask(taskId);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
