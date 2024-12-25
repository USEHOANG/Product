package sping.api.spingboot.api.User.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import sping.api.spingboot.api.User.entity.User;
import sping.api.spingboot.api.User.enums.Role;
import sping.api.spingboot.api.User.repository.UserRepository;

import java.util.HashSet;

@Configuration
@Slf4j
public class SecurityConfig {


    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Bean
//    ApplicationRunner applicationRunner(UserRepository userRepository){
//        return args -> {
//            if (userRepository.findByUsername("Hoang").isEmpty()){
//                var roles = new HashSet<String>();
//                roles.add(Role.ROLE_MANAGER.name());
//                User user = User.builder()
//                        .username("admin123")
//                        .password(passwordEncoder.encode("123"))
//                        .roles(roles)
//                        .build();
//
//                userRepository.save(user);
//                log.warn("admin user created, please change password");
//            }
//        };
//    }
}
