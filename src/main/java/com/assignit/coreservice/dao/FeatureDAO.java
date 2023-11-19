package com.assignit.coreservice.dao;

import com.assignit.coreservice.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureDAO extends JpaRepository<Feature, Long> {

}
