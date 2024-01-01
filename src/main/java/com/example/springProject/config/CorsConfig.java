package com.example.springProject.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Permettre l'accès depuis tous les domaines, vous pouvez spécifier des domaines spécifiques si nécessaire
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedHeader("*");
        
        // Autoriser les méthodes nécessaires
       /*  config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");  // Ajout de la méthode OPTIONS
         */
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Autoriser les en-têtes personnalisés
        config.addAllowedHeader("Content-Type");
        config.addAllowedHeader("Authorization");

        // Exposer les en-têtes nécessaires à l'accès côté client
        config.addExposedHeader("Authorization");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
   /*  @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        // Permettre l'accès depuis tous les domaines, vous pouvez spécifier des domaines spécifiques si nécessaire
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedHeader("http://localhost:4200");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedHeader("Content-Type");
        config.addAllowedHeader("Authorization");
        config.addAllowedMethod("*");
        config.addAllowedHeader(null);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
      */
}