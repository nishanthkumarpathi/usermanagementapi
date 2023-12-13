package com.bibf.usermanagementapi.services;

import com.bibf.usermanagementapi.models.User;
import com.bibf.usermanagementapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// @Service annotation is used to mark the class as a service provider
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        //ADDED: #1 The user repository save() method is easy!
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Integer userId) {
        //return userRepository.findById(userId).get();
        return userRepository.findById(userId).orElseThrow();
    }

    public User updateUser(Integer userId, User user) {
        User existingUser = getUser(userId);

        if(user.getName() != null) {existingUser.setName(user.getName());}
        if(user.getEmail() != null) {existingUser.setEmail(user.getEmail());}
        if(user.getPassword() != null) {existingUser.setPassword(user.getPassword());}

        //TODO: Add Validation

        return userRepository.save(existingUser);
    }



}
