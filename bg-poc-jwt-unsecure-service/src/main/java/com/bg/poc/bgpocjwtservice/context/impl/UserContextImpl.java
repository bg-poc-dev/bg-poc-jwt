package com.bg.poc.bgpocjwtservice.context.impl;

import com.bg.poc.bgpocjwtservice.context.UserContext;

public class UserContextImpl implements UserContext {

    private String userId;

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
