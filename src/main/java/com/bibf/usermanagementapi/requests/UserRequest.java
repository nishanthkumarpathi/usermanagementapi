package com.bibf.usermanagementapi.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "A Name is required")
    @Size(max = 25,message = "The Name must be at most 25 characters")
    private String name;

    @NotBlank(message = "Email is Mandatory")
    @Email(message = "Please enter a valid email address")
    private String email;

    @NotBlank(message = "Password is Mandatory")
    @Size(min = 8,message = "The password must contain at least 8 characters")
    private String password;

}
