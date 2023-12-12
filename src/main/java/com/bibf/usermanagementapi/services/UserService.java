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

}
