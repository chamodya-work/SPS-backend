package com.example.SPSProjectBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class GlobalCorsConfig {
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**") // allow all endpoints
//                        //.allowedOrigins("http://localhost:3000") // ✅ use this in dev
//                        .allowedOrigins("*") // ⚠️ allow all origins (not recommended for prod)
//                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
//                       // .allowedHeaders("*")
//                       // .allowCredentials(true);
//            }
//        };
//    }
//}


//this is testing config

@Configuration
public class GlobalCorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // allow all endpoints
                        .allowedOrigins("http://localhost:3000","http://localhost:8096","http://localhost:8097","http://10.128.1.227:8096") //make sure you have to use this for working login
//                        .allowedOrigins("*") // when use this the need specific path not *
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);

            }
        };
    }
}