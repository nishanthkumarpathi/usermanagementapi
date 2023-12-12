package com.bibf.usermanagementapi.repositories;

import com.bibf.usermanagementapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
