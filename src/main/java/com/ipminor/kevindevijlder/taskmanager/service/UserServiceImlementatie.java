package com.ipminor.kevindevijlder.taskmanager.service;

import com.ipminor.kevindevijlder.taskmanager.dto.CreateUserDTO;
import com.ipminor.kevindevijlder.taskmanager.dto.UserDTO;
import com.ipminor.kevindevijlder.taskmanager.model.Roles;
import com.ipminor.kevindevijlder.taskmanager.model.User;
import com.ipminor.kevindevijlder.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImlementatie implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImlementatie(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("{user.doesntexist}");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name())));
    }

    @Override
    public boolean createUser(CreateUserDTO userDTO) {
        boolean alreadyexists = false;
        if(userRepository.findByUsername(userDTO.getUsername()) != null){
            alreadyexists=true;
            return alreadyexists;
        } else {
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setPasswordconfirmed(passwordEncoder.encode(userDTO.getPasswordconfirmed()));
            user.setFullname(userDTO.getFullname());
            user.setEmail(userDTO.getEmail());
            user.setRole(Roles.USER);
            user = userRepository.saveAndFlush(user);
            return alreadyexists;
        }
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    private UserDTO convert(User user) {
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        return dto;
    }

}
