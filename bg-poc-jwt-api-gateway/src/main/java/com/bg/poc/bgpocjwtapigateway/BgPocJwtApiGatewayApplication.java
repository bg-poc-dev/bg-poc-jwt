package com.bg.poc.bgpocjwtapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class BgPocJwtApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgPocJwtApiGatewayApplication.class, args);
    }
}
