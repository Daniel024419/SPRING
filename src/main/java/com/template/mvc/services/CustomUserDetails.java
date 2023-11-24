package com.template.mvc.services;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.template.mvc.models.User;


public class CustomUserDetails implements UserDetails {
 

    private User user;
   
    //super constructor
    public CustomUserDetails ( User user){
        super();
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        

        //set authorities
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));

    }

    @Override
    public String getPassword() {
        return user.getPassword();

    }

    @Override
    public String getUsername() {

        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {

    return false;

    }

    @Override
    public boolean isAccountNonLocked() {

    return false;

    }

    @Override
    public boolean isCredentialsNonExpired() {

        return false;

    }

    @Override
    public boolean  isEnabled() {
        
        return true;

    }
}
