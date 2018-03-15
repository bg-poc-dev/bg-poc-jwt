package com.bg.poc.bgpocjwtservice.context.impl;

import com.bg.poc.bgpocjwtservice.context.UserContext;
import com.bg.poc.bgpocjwtservice.context.UserContextHolderStrategy;

public class ThreadlocalUserContextHolderStrategy implements UserContextHolderStrategy {

    private static final ThreadLocal<UserContext> contextHolder = new InheritableThreadLocal<>();

    @Override

    public UserContext getContext() {
        UserContext ctx = contextHolder.get();
        if (ctx == null) {
            ctx = createEmptyContext();
            setContext(ctx);
        }
        return ctx;
    }

    @Override
    public void clearContext() {
        contextHolder.remove();
    }

    @Override
    public void setContext(UserContext context) {
        contextHolder.set(context);
    }

    @Override
    public UserContext createEmptyContext() {
        return new UserContextImpl();
    }
}
