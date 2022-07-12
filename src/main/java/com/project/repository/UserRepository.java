package com.project.repository;

import com.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// When autowired, this repository can perform database operations on the "user" table.
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}