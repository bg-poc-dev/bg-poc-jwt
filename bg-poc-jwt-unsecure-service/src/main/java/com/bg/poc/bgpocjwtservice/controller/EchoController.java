package com.bg.poc.bgpocjwtservice.controller;

import com.bg.poc.bgpocjwtservice.service.EchoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    private EchoService service;

    public EchoController(EchoService service) {
        this.service = service;
    }

    @GetMapping("/echo")
    public String echo(@RequestParam("call") String call) {
        return service.echo(call);
    }
}
