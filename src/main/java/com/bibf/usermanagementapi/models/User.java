package com.bibf.usermanagementapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private String email;
    private String password;
}


// @Component Annotation is used to create a Bean of the Class
// @AllArgsConstructor Annotation is used to create a Constructor with all the Fields in the Class
// @NoArgsConstructor Annotation is used to create a Constructor with no Fields in the Class
// @Getter Annotation is used to create Getters for all the Fields in the Class
// @Setter Annotation is used to create Setters for all the Fields in the Class