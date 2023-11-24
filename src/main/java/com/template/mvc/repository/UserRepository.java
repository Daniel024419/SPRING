package com.template.mvc.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

//import user model
import com.template.mvc.models.User;

public interface UserRepository extends MongoRepository<User, String> {

    // Optional<User> findByUsermail(String usermail);

    // Define a method to find a user by username
    User findByUsermail(String usermail);
    
    // Define a method to update a user by username
    //void updateByUsername(String username, User updatedUser);
    

    // //save user
    // public abstract User saveUser(User user);

    // //delete user by _id
    // public abstract void deleteUserById(String _id);

    // //find user by _id
    // public abstract void findUserById(String _id);

   

}

