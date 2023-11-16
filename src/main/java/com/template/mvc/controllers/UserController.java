package com.template.mvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAllUsers() {
        try {
            LOGGER.info("Controller: Fetch all users...");
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception error) {
            LOGGER.error("Error fetching users: {}", error.getMessage(), error);
            // Return an error response with a message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Something happened  fetching users: ");
        }
    }

    @PostMapping("/save-users")
    public ResponseEntity<?> createUser(@RequestBody Map<String, String> userData) {

        try {
            User user = new User(
                    
                    userData.get("username"),
                    userData.get("location"),
                    userData.get("profile"),
                    userData.get("password"),
                    userData.get("usermail"));

            // Send user data to userService for saving
            User savedUser = userService.saveUser(user);

            // log info
            LOGGER.info("Controller: Save users...");
            // Return a success response with the saved user
            return ResponseEntity.ok(savedUser);
        } catch (DataAccessException error) {
            // Handle or log the exception
            LOGGER.error("Error saving user: {}", error.getMessage(), error);

            // Return an error response with a message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Something happened saving user, Please try again");
        }
    }

    // delete user
    @DeleteMapping("/delete-users")
    public ResponseEntity<String> deleteUser(@RequestParam(name = "_id") String _id) {
          LOGGER.info("Controller: delete users...");

        try {
            userService.deleteUserById(_id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception error) {
            LOGGER.error("Error deleting user: {}", error.getMessage(), error);

            // For demonstration purposes, let's print the stack trace to the console
            error.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something happened  deleting user , Please try again");
        }



       
    }
 //update user with _id

 @PutMapping("/update-users")
 public ResponseEntity<String> updateUser(@RequestBody User updatedUser) {
     try {
         LOGGER.info("Controller: Update users...");
 
         // Extract the _id from the User object
         String _id = updatedUser.get_id();
 
         // Call the update method in the service
         return userService.updateUserById(_id, updatedUser);
     } catch (Exception e) {
         LOGGER.error("Error updating user", e);
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user");
     }
 }
 

    

}
