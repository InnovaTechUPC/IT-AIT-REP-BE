package com.assignit.coreservice.controller;

import com.assignit.coreservice.beans.FeatureBean;
import com.assignit.coreservice.service.FeatureService;
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
@RequestMapping("/service/feature")
@Tag(name = "FeatureController", description = "Feature EndPoint")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(featureService.getAllFeatures(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: ", e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long featureId) {
        try {
            return new ResponseEntity<>(featureService.getById(featureId), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: ", e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createFeature(@RequestBody FeatureBean featureBean) {
        try {
            featureService.createFeature(featureBean);
            return new ResponseEntity<>("created", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeature(@PathVariable("id") Long featureId, @RequestBody FeatureBean featureBean) {
        try {
            featureService.updateFeature(featureId, featureBean);
            return new ResponseEntity<>("updated", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeature(@PathVariable("id") Long featureId) {
        try {
            featureService.deleteFeature(featureId);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
