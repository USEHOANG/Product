package sping.api.spingboot.api.User.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import sping.api.spingboot.api.User.service.CustomUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()  // Cho phép truy cập vào /auth mà không cần xác thực
                        .requestMatchers("/api/manager/**").hasRole("MANAGER")  // Kiểm tra ROLE_MANAGER
                        .requestMatchers("/api/employee/**").hasRole("EMPLOYEE")  // Kiểm tra ROLE_EMPLOYEE
//                        .requestMatchers("/api/category/**").hasRole("MANAGER")  // Kiểm tra ROLE_MANAGER cho category
                        .anyRequest().authenticated()  // Các request khác yêu cầu xác thực
                )
                .httpBasic();  // Sử dụng HTTP basic authentication
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)  // Cung cấp userDetailsService để xác thực người dùng
                .passwordEncoder(passwordEncoder())  // Sử dụng BCryptPasswordEncoder để giải mã mật khẩu
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);  // Dùng bcrypt với độ khó 10
    }
}
