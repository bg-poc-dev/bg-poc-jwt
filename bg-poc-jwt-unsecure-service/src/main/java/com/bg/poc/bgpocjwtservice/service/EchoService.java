package com.bg.poc.bgpocjwtservice.service;

import com.bg.poc.bgpocjwtservice.context.UserContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EchoService {

    public String echo(String call) {
        return String.format("%1s was sent by user with id %2s", call, Optional.ofNullable(UserContextHolder.getContext())
                .map(c -> c.getUserId()).orElse("unknown"));

    }
}
