package com.bibf.usermanagementapi.services;

import com.bibf.usermanagementapi.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// @Service annotation is used to mark the class as a service provider
@Service
public class UserService {

    // Step 1: Create a List of User Database using ArrayList or List
    public static List<User> userDatabase = new ArrayList<>();
    static {
        userDatabase.add(new User(1, "Nishanth Kumar", "nishanth@gmail.comm", "password123"));
        userDatabase.add(new User(2, "Maryam Ahmed", "maryam@gmail.com", "password456"));
        userDatabase.add(new User(3, "Mark Johnson", "markjohnson@example.com", "password789"));
        userDatabase.add(new User(4, "Sarah Lee", "sarahlee@example.com", "passwordabc"));
        userDatabase.add(new User(5, "David Chen", "davidchen@example.com", "passworddef"));
    }

    // Step 2: Create a method to fetch all users from the database
    public List<User> getUsers() {
        // fetch all users and return them
        return userDatabase;
    }

    // Step 3: Create a method to add the user to the database ArrayList
    public User addUser(User user) {
        // add the user to the database and return the user
        userDatabase.add(user);
        return user;
    }

    // Step 4: updateUser method to update the user in the database

    public User getUser(Integer userId) {
        // fetch user from database
        return userDatabase.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public User updateUser(Integer userId, User user) {
        // fetch user with userId, update it and return the new user
        User existingUser = getUser(userId);
        if(existingUser == null){return null;}
        if(user.getName() != null) {existingUser.setName(user.getName());}
        if(user.getEmail() != null) {existingUser.setEmail(user.getEmail());}
        if(user.getPassword() != null) {existingUser.setPassword(user.getPassword());}
        return existingUser;
    }

    public String deleteUser(Integer userId) {
        // delete user with userId, return success.
        if( userDatabase.removeIf(user -> userId.equals(user.getId())) ){
            return "User with id " + userId + " deleted successfully!";
        } else {
            return "User with id " + userId + " not found";
        }
    }

    public User getUserByEmail(String email) {
        // get user by email from database
        return userDatabase.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

}
