package com.veersa.emailer.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FilterConfig {


    @Bean
    public ApiKeyFilter apiKeyFilterBean() {
        return new ApiKeyFilter();
    }


    @Bean
    public FilterRegistrationBean<ApiKeyFilter> apiKeyFilter(ApiKeyFilter apiKeyFilter) {
        FilterRegistrationBean<ApiKeyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(apiKeyFilter);
        registrationBean.addUrlPatterns("/api/*"); // Protect only API endpoints
        return registrationBean;
    }
}
