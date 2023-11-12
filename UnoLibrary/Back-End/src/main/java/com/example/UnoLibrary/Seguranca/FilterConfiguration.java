package com.example.UnoLibrary.Seguranca;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Alterar

@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean<AcessFilter> registrationBean(){
        // registrando o filtro
        FilterRegistrationBean<AcessFilter> register = new FilterRegistrationBean<>();
        register.setFilter(new AcessFilter());
        // definindo as URLs para aplicar o filtro
        register.addUrlPatterns("/apiii/*");
        return register;
    }
}


