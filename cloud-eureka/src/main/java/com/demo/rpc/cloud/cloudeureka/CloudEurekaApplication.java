package com.demo.rpc.cloud.cloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Spirng cloud 注册中心
 */
@SpringBootApplication
@EnableEurekaServer     //该注解声明本应用为Eureka服务器（注册中心）
public class CloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaApplication.class, args);
    }
}
