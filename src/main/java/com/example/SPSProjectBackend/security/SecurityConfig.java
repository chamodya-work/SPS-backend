package com.example.SPSProjectBackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable) // Disable Spring Security's CORS
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/").permitAll()
                        .anyRequest().permitAll() // ✅ No authentication required
                )
                .build();
    }

    // public BCryptPasswordEncoder bCryptPasswordEncoder(){
    // return new BCryptPasswordEncoder();
    // }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
    // throws Exception {
    // return httpSecurity
    // .csrf(AbstractHttpConfigurer::disable)
    // .cors(Customizer.withDefaults())
    // .authorizeHttpRequests(auth -> auth
    // .requestMatchers(
    // "/api/v1/**",
    // "/api/v1/verify/**",
    // "/api/report/**",
    // "/api/application/**",
    // "/api/spestcnd/**",
    // "/api/v1/auth/login",
    // "/api/v1/register",
    // "/api/commission/**",
    // "/api/pcesthmt/**",
    // "/api/applicants/**",
    // "/api/piv-details/**",
    // "/api/wiring-land-details/**",
    // "/api/estimate-details/**",
    // "/api/approval-history/**",
    // "/api/pegschdmt/**" // ✅ Allow your Pegschdmt endpoint
    // ).permitAll()
    // .anyRequest().authenticated()
    // )
    // .httpBasic(Customizer.withDefaults())
    // .build();
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll())
                .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // ✅ Allow both backend test ports and your React dev port
        configuration.setAllowedOrigins(List.of(
                "http://localhost:5173", // React (Vite)
                "http://localhost:8088", // Backend
                "http://localhost:8096", // Other local tools if needed
                "http://localhost:3000" // React (Create React App)
        ));

        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public CommandLineRunner printGeneratedPassword() {
        return args -> System.out.println("Generated Security Password: admin123");
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.withUsername("user")
                .password(bCryptPasswordEncoder().encode("admin123"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
