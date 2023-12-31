package com.template.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.template.mvc.models.User;
import com.template.mvc.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

@Autowired
private UserRepository  userRepository;

@Override
public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException {
    

    User user = userRepository.findUserByUsername(username);
    if (user == null) {
        throw new UsernameNotFoundException("User not found");
    }
    
    //retun user object
    return new CustomUserDetails(user);
}

}
