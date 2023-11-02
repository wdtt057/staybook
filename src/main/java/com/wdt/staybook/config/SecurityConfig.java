package com.wdt.staybook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(HttpMethod.POST,"/register/**")
                        .permitAll()
                        .anyRequest().authenticated()
                )
        ;
        httpSecurity.csrf(csrf -> csrf.disable());
        return httpSecurity.build();
    }
}