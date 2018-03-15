package com.bg.poc.bgpocjwtapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class AuthHeaderFilter extends ZuulFilter {

    @Value("${bg.users.authorization.bgUserId}")
    private String bgUserId;

    @Value("${bg.users.authorization.bgUserIdHeader}")
    private String bgUserIdHeader;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext.getCurrentContext().getResponse().addHeader(bgUserIdHeader, extractUserId());
        return null;
    }

    private String extractUserId() {
        return (String) Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getDetails)
                .map(d -> (OAuth2AuthenticationDetails) d)
                .map(d -> (Map) d.getDecodedDetails())
                .map(d -> d.get(bgUserId)).orElse("");
    }
}
