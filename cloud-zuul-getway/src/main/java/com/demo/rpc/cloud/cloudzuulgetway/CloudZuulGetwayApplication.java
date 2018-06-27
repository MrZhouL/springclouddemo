package com.demo.rpc.cloud.cloudzuulgetway;

import com.demo.rpc.cloud.cloudzuulgetway.filter.RequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class CloudZuulGetwayApplication {

    public static void main(String[] args) {

        SpringApplication.run(CloudZuulGetwayApplication.class, args);
    }

    @Bean
    public RequestFilter logFilter(){
        return new RequestFilter();
    }
}
