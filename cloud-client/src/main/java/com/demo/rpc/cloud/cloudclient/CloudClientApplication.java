package com.demo.rpc.cloud.cloudclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@EnableHystrix  //开启熔断器
@SpringBootApplication
public class CloudClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudClientApplication.class, args);
    }

    @Bean
    @LoadBalanced   //该注解将开启ribbon的负载均衡模式。开启后ribbon将拦截RestTemplate发起的请求并实现负载均衡。
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //@Autowired
    //private RestTemplate restTemplate;


    //public String say(){
    //    return restTemplate.getForObject("http://hello/hello?param=cloud",String.class);
    //}
}
