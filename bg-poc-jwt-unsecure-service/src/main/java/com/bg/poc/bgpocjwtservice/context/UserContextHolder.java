package com.bg.poc.bgpocjwtservice.context;

import com.bg.poc.bgpocjwtservice.context.impl.ThreadlocalUserContextHolderStrategy;

public class UserContextHolder {

    private static UserContextHolderStrategy strategy;
    private static int initializeCount = 0;

    static {
        initialize();
    }

    private static void initialize() {
        strategy = new ThreadlocalUserContextHolderStrategy();
        initializeCount++;
    }

    public static void clearContext() {
        strategy.clearContext();
    }

    public static UserContext getContext() {
        return strategy.getContext();
    }

    public static int getInitializeCount() {
        return initializeCount;
    }

    public static void setContext(UserContext context) {
        strategy.setContext(context);
    }

}
