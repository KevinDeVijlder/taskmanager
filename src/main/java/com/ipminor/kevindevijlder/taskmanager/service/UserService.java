package com.ipminor.kevindevijlder.taskmanager.service;

import com.ipminor.kevindevijlder.taskmanager.dto.CreateUserDTO;
import com.ipminor.kevindevijlder.taskmanager.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO createUser(CreateUserDTO userDTO);

    void deleteUser(long userId);
}
