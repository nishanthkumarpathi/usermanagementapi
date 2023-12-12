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


}
