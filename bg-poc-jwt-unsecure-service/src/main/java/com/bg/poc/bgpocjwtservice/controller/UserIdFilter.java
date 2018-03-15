package com.bg.poc.bgpocjwtservice.controller;

import com.bg.poc.bgpocjwtservice.context.UserContextHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class UserIdFilter extends GenericFilterBean {

    @Value("${bg.users.authorization.bgUserIdHeader}")
    private String bgUserIdHeader;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String userId = request.getHeader(bgUserIdHeader);
        UserContextHolder.getContext().setUserId(userId);

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
