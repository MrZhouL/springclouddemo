package com.demo.rpc.cloud.cloudclientfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients     //该注解将扫描所欲@FeignClient注解
@SpringBootApplication
public class CloudClientFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudClientFeignApplication.class, args);
    }
}
