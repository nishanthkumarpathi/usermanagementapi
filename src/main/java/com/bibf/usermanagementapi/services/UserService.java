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

}
