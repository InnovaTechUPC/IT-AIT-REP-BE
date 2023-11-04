package com.assignit.coreservice.dao;

import com.assignit.coreservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

}
