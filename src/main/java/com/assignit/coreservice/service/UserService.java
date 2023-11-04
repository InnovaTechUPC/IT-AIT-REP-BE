package com.assignit.coreservice.service;

import com.assignit.coreservice.dao.UserDAO;
import com.assignit.coreservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserService {

    @Autowired
    private UserDAO userRepository;
    
    public void savePoints(String name, Long points) {
        User user = new User();
        user.setName(name);
        user.setPoints(points);
        userRepository.save(user);
    }
}
