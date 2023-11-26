package com.assignit.coreservice.user.dao;

import com.assignit.coreservice.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

}
