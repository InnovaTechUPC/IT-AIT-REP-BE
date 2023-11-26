package com.assignit.coreservice.role.dao;

import com.assignit.coreservice.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {

}
