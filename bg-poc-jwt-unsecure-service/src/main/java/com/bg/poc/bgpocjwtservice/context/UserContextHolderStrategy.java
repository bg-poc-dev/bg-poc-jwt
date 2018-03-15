package com.bg.poc.bgpocjwtservice.context;

public interface UserContextHolderStrategy {

    UserContext getContext();

    void clearContext();

    void setContext(UserContext context);

    UserContext createEmptyContext();
}
