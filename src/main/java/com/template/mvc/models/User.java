package com.template.mvc.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import org.springframework.data.annotation.Id;

@Document(collection = "users")
public class User {

    //streucture model for databese
    @Id
    private String _id;
    private String username;
    private String location;
    private String profile;
    private String password;
    private String usermail;
    private Date createdAt;
    private Date updatedAt;

    // constructor
    // Constructor with required fields
    public User(String username, String location, String profile, String password, String usermail) {
        this.username = username;
        this.location = location;
        this.profile = profile;
        this.password = password;
        this.usermail = usermail;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    // Getters and setters...


    public String get_id() {
        return username;
    }

    public void set_id(String _id) {
        this._id = _id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreated_at(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
