package com.template.mvc.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.template.mvc.models.User;
import com.template.mvc.repository.UserRepository;

@Service
public class userService {
@Autowired
    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(userService.class);
    
    //create instance of the user repository
    public userService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
   
    //fetch all services
    public List<User> getAllUsers() {
        LOGGER.info("services : fetch all users..");
        return userRepository.findAll();
    }
    
   
    //save new users
    public User saveUser(User user) {
        LOGGER.info("services : saving all users..");
        return userRepository.save(user);
    }

    //delete users
    public void deleteUserById(String _id) {

        LOGGER.info("services : delete user by _id..");
        userRepository.deleteById(_id);
    }
    

    public ResponseEntity<String> updateUserById(String _id, User updatedUser) {
        try {
            // Check if the user with the given _id exists
            Optional<User> existingUserOptional = userRepository.findById(_id);

            if (existingUserOptional.isPresent()) {
                User existingUser = existingUserOptional.get();
                // Update fields of the existing user with the new data
                existingUser.setUsername(updatedUser.getUsername());
                existingUser.setLocation(updatedUser.getLocation());
                existingUser.setProfile(updatedUser.getProfile());
                existingUser.setPassword(updatedUser.getPassword());
                existingUser.setUsermail(updatedUser.getUsermail());
                existingUser.setUpdatedAt(new Date()); // Set the updatedAt field to the current date

                // Save the updated user
                userRepository.save(existingUser);

                LOGGER.info("User updated successfully with id: {}", _id);
                return ResponseEntity.ok("User updated successfully");
            } else {
                // Handle the case where the user with the given _id is not found
                LOGGER.warn("User not found with id: {}", _id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with that id");
            }
        } catch (Exception e) {
            // Handle any exceptions that might occur during the update
            LOGGER.error("Error updating user with id: {}", _id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user, Please try again");
        }
    }

}
