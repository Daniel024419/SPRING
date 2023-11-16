package com.template.mvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//service
import com.template.mvc.services.userService;

//import user model
import com.template.mvc.models.User;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/users")
public class UserController { 
   

    @Autowired 
    private static final Logger LOGGER = LoggerFactory.getLogger(userService.class);

  
    private final userService userService;
    public UserController(userService userService) {
        this.userService = userService;
    }

     @GetMapping("/fetch-users")
     public List<User> getAllUsers() {

        LOGGER.info("controller :  fetch all users...");
         return userService.getAllUsers();
     }

     @PostMapping("/save-user")
     public User createUser(@RequestBody Map<String, String> userData) {

        LOGGER.info("controller :  save all user...");

         User user = new User(
            userData.get("userId"),
             userData.get("username"),
             userData.get("location"),
             userData.get("profile"),
             userData.get("password"),
             userData.get("usermail")
         );
     
         // Send user data to userService for saving
         return userService.saveUser(user);
     }

}
