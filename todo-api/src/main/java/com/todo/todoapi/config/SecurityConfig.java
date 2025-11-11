package com.todo.todoapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desabilita CSRF para facilitar testes com POSTMAN
            .authorizeHttpRequests(authz -> authz
                // Permite acesso público ao H2 Console (apenas para desenvolvimento)
                .requestMatchers("/h2-console/**").permitAll()
                
                // Permite acesso público aos endpoints de leitura (GET)
                .requestMatchers(HttpMethod.GET, "/api/tasks/**").permitAll()
                
                // Requer autenticação para operações de escrita (POST, PUT, DELETE)
                .requestMatchers(HttpMethod.POST, "/api/tasks/**").authenticated()
                .requestMatchers(HttpMethod.PUT, "/api/tasks/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/api/tasks/**").authenticated()
                
                // Qualquer outra requisição requer autenticação
                .anyRequest().authenticated()
            )
            .headers(headers -> headers
                .frameOptions(frame -> frame.sameOrigin()) // Permite H2 Console em iframe
            )
            .httpBasic(httpBasic -> httpBasic.realmName("Todo API")); // Autenticação Basic Auth
        
        return http.build();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        // Cria usuários em memória para testes
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN")
                .build();
        
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user123"))
                .roles("USER")
                .build();
        
        return new InMemoryUserDetailsManager(admin, user);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}