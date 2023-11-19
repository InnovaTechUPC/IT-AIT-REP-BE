package com.assignit.coreservice.dao;

import com.assignit.coreservice.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDAO extends JpaRepository<Project, Long> {

}
