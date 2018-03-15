package com.bg.poc.bgpocjwtservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@Service
public class EchoService {

    @Value("${bg.users.authorization.bgUserIdHeader}")
    private String bgUserIdHeader;

    @Value("${unsecure.service.url}")
    private String serviceUrl;

    public String echo(String call) {
        String userId = userId();

        return String.format("Request: [%1s] was sent by user with id %2s, response from unsecured service was received: [%3s]", call, userId, exchange(call, userId));
    }

    private String exchange(String request, String userId) {

        HttpHeaders headers = new HttpHeaders();
        headers.add(bgUserIdHeader, userId);
        HttpEntity<String> httpEntity = new HttpEntity<>(request, headers);

        ResponseEntity<String> answer = new RestTemplate()
                .exchange(serviceUrl + "/echo?call=" + request, HttpMethod.GET, httpEntity, String.class);

        return answer.getBody();
    }


    private String userId() {
        Map<String, Object> details = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getDetails)
                .map(d -> (OAuth2AuthenticationDetails) d)
                .map(d -> (Map) d.getDecodedDetails())
                .orElseThrow(() -> new IllegalStateException("No Principal object discovered"));

        return (String) details.entrySet().stream().filter(e -> "user_id".equals(e.getKey()))
                .findFirst().map(e -> e.getValue()).orElseThrow(() -> new IllegalStateException("Unknown user"));
    }

}
