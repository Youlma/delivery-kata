package com.delivery.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Désactive CSRF si ce n'est pas nécessaire
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll() // Autorise toutes les requêtes vers /auth/**
                .anyRequest().authenticated()) // Toutes les autres requêtes nécessitent une authentification
            .httpBasic(); // Utilise Basic Authentication ou configurez JWT selon vos besoins

        return http.build();
    }
}