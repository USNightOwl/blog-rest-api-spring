package com.nxhawk.blogapi.config;

import com.nxhawk.blogapi.entity.Role;
import com.nxhawk.blogapi.entity.User;
import com.nxhawk.blogapi.repository.RoleRepository;
import com.nxhawk.blogapi.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class ApplicationInitConfig {
    @Bean
    public ApplicationRunner initDatabase(RoleRepository roleRepository, UserRepository userRepository,
                                          PasswordEncoder passwordEncoder) {
        return args -> {
            if (roleRepository.count() == 0) {
                roleRepository.saveAll(List.of(new Role("ROLE_ADMIN"), new Role("ROLE_USER")));
            }
        };
    }
}
