package com.template.mvc.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.mvc.models.User;
import com.template.mvc.repository.UserRepository;

@Service
public class userService {

    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(userService.class);
    @Autowired
    public userService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        LOGGER.info("services : fetch all users");
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
