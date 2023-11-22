package com.example.UnoLibrary;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/security/**")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true)
                .exposedHeaders("Access-Control-Allow-Origin");

        registry.addMapping("/api/**")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true)
                .exposedHeaders("Access-Control-Allow-Origin");
    }
}
