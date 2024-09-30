package com.example.ecommerce.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecretFilterConfig {

    @Bean
    public FilterRegistrationBean<SecretKeyFilter> secretKeyFilterConfig(SecretKeyFilter secretKeyFilter) {
        FilterRegistrationBean<SecretKeyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(secretKeyFilter);
        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }

}
