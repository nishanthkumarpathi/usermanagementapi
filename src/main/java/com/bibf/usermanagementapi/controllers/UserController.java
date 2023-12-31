package com.bibf.usermanagementapi.controllers;

import com.bibf.usermanagementapi.models.User;
import com.bibf.usermanagementapi.requests.UserRequest;
import com.bibf.usermanagementapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController annotation is used to create RESTful web services using Spring MVC
@RestController
public class UserController {

    // @Autowired annotation is used for automatic dependency injection.
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody UserRequest user){
        return userService.addUser(user);
    }

    /* GET ALL: Access by sending a GET request to http://localhost:8080/users */
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.ACCEPTED) //not necessary as it is the default response.
    public List<User> getUsers(){
        return userService.getUsers();
    }

    /* GET ONE: Access by sending a GET request to http://localhost:8080/users/12 */
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Integer userId){
        return userService.getUser(userId);
    }

    /* UPDATE USER: Access by sending a PUT request to http://localhost:8080/users/12 with a JSON Body */
    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Integer userId, @RequestBody User user){
        return userService.updateUser(userId,user);
    }

    /* GET USER BY EMAIL: Access by sending a GET request to http://localhost:8080/users/email/hamad@gmail.com */
    @GetMapping("/users/email/{email}")
    public User getUserByEmail(@PathVariable("email") String email){
        return userService.getUserByEmail(email);
    }


    /* DELETE USER: Access by sending a GET request to http://localhost:8080/users/12 with a JSON Body */
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Integer userId){
        return userService.deleteUser(userId);
    }

}
