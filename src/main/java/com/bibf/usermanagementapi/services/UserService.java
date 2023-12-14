package com.bibf.usermanagementapi.services;

import com.bibf.usermanagementapi.exceptions.MySpecialException;
import com.bibf.usermanagementapi.models.User;
import com.bibf.usermanagementapi.repositories.UserRepository;
import com.bibf.usermanagementapi.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

// @Service annotation is used to mark the class as a service provider
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User addUser(UserRequest user) {
        //ADDED: #1 The user repository save() method is easy!
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new NoSuchElementException("The Email " + user.getEmail() + " is already used.");
        }

        // UserRequest Validation is added, however this validation is comming from controller
        // Now the Model does not have any validation and model cant accept the structure of the request
        // because the model has integer id, which is not available in UserRequest Model

        User newUser = new User(user.getName(), user.getEmail(), user.getPassword());

        return userRepository.save(newUser);
    }
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        // #1 throw an exception if there are no results
        if(users.isEmpty()) {
            throw new MySpecialException("No Users Found");
        }
        return users;
    }
    public User getUser(Integer userId) {
        //return userRepository.findById(userId).get();
        // #2 throw exception if the user is not found
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("The user with ID:" + userId + " not found."));
    }

    public User updateUser(Integer userId, User user) {
        User existingUser = getUser(userId);

        if(user.getName() != null) {existingUser.setName(user.getName());}
        if(user.getEmail() != null) {existingUser.setEmail(user.getEmail());}
        if(user.getPassword() != null) {existingUser.setPassword(user.getPassword());}
        //TODO: Add Validation
        return userRepository.save(existingUser);
    }

    public User getUserByEmail(String email) {
        // get user by email from database
        return userRepository.findByEmail(email).orElseThrow();
    }

    public String deleteUser(Integer userId) {
        // delete user with userId, return success.
        userRepository.deleteById(userId);
        return "User with id " + userId + " deleted successfully!";
    }

}
