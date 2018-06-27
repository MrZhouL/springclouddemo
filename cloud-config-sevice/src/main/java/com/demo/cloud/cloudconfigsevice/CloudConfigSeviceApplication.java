package com.demo.cloud.cloudconfigsevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class CloudConfigSeviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigSeviceApplication.class, args);
    }
}
