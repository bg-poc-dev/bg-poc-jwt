package com.bg.poc.bgpocjwtservice.config;

import com.bg.poc.bgpocjwtservice.controller.UserIdFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

@Configuration
public class UserIdFilterConfig {

    @Autowired
    private UserIdFilter userIdFilter;

    @Bean
    public FilterRegistrationBean dawsonApiFilter(GenericFilterBean userIdFilter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(userIdFilter);
        registration.addUrlPatterns("/echo/*");
        return registration;
    }
}
