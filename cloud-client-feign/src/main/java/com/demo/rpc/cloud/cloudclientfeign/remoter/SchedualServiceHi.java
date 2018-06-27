package com.demo.rpc.cloud.cloudclientfeign.remoter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hello",fallback = SchedualServiceHiHystric.class) //指定需要调用的服务名称
public interface SchedualServiceHi {

    @RequestMapping(value = "hello",method = RequestMethod.GET) //该服务下的那个接口
    String sayHiFromClientOne(@RequestParam("param") String param);//接口参数
}
