package com.nxhawk.blogapi.service.impl;

import com.nxhawk.blogapi.entity.Role;
import com.nxhawk.blogapi.entity.User;
import com.nxhawk.blogapi.exception.BlogAPIException;
import com.nxhawk.blogapi.payload.RegisterDto;
import com.nxhawk.blogapi.repository.RoleRepository;
import com.nxhawk.blogapi.repository.UserRepository;
import com.nxhawk.blogapi.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    @Override
    public String register(RegisterDto registerDto) {
        // add check for username exists in database
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        // create new user
        User user = new User();
        user.setName(registerDto.getUsername());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());

        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        // set roles
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return "User registered successfully!.";
    }
}
