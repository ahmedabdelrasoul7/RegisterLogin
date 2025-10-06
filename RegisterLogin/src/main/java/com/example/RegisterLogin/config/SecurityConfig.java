package com.example.RegisterLogin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService users(PasswordEncoder encoder) {
        InMemoryUserDetailsManager uds = new InMemoryUserDetailsManager();
        uds.createUser(User.withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build());
        return uds;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
               // .antMatchers("/api/v1/employee/save").permitAll() // لو عايز السماح بالتسجيل
                .antMatchers("/api/v1/employee/save", "/api/v1/employee/login").permitAll()
                .antMatchers(org.springframework.http.HttpMethod.OPTIONS, "/**").permitAll() // السماح بـ preflight
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        http.cors(); // تفعيل CORS
        return http.build();
    }
}