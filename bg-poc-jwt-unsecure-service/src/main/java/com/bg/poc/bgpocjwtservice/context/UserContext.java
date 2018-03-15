package com.bg.poc.bgpocjwtservice.context;

import java.io.Serializable;

public interface UserContext extends Serializable {

    String getUserId();

    void setUserId(String userId);
}
