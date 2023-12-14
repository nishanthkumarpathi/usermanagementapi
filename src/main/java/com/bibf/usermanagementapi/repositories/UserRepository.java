package com.bibf.usermanagementapi.repositories;

import com.bibf.usermanagementapi.models.User;
import com.bibf.usermanagementapi.requests.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
