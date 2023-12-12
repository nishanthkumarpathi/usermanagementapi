package com.bibf.usermanagementapi.controllers;

import com.bibf.usermanagementapi.models.User;
import com.bibf.usermanagementapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController annotation is used to create RESTful web services using Spring MVC
@RestController
public class UserController {

    // @Autowired annotation is used for automatic dependency injection.
    @Autowired
    private UserService userService;

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

    /* ADD USER: Access by sending a POST request to http://localhost:8080/users with a JSON Body */
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

}
