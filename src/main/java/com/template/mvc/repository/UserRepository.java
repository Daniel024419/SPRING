package com.template.mvc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

//import user model
import com.template.mvc.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    // Define a method to find a user by username
    //User findByUsername(String username);
    
    // Define a method to update a user by username
    //void updateByUsername(String username, User updatedUser);
}

