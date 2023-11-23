package com.example.UnoLibrary.Seguranca;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean<AcessFilter> registrationBean() {
        FilterRegistrationBean<AcessFilter> register = new FilterRegistrationBean<>();
        register.setFilter(new AcessFilter());

        register.addUrlPatterns("/apii/*");
        return register;
    }
}


