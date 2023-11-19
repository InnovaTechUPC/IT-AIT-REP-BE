package com.assignit.coreservice.dao;

import com.assignit.coreservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {

}
