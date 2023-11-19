package com.assignit.coreservice.project.dao;

import com.assignit.coreservice.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDAO extends JpaRepository<Project, Long> {

}
