package com.ipminor.kevindevijlder.taskmanager.repository;

import com.ipminor.kevindevijlder.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
