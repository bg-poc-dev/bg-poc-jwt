package com.bg.poc.bgpocjwtservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class EchoService {

    public String echo(String call) {

        Map<String, Object> details = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getDetails)
                .map(d -> (OAuth2AuthenticationDetails) d)
                .map(d -> (Map) d.getDecodedDetails())
                .orElseThrow(() -> new IllegalStateException("No Principal object discovered"));

        return String.format("%1s was sent by user with id %2s", call,
                details.entrySet().stream().filter(e -> "user_id".equals(e.getKey()))
                        .findFirst().map(e -> e.getValue()).orElseThrow(() -> new IllegalStateException("No user_id value discovered"))
        );

    }
}
