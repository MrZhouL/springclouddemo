/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: HelloService
 * Author:   zhoulei
 * Date:     2018/6/24 上午11:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.rpc.cloud.cloudclient.server;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zhoulei
 * @create 2018/6/24
 * @since 1.0.0
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")       //对该方法创建了熔断器的功能,并指定了fallbackMethod熔断方法
    public String hiService(String name){

        return restTemplate.getForObject("http://HELLO/hello?param="+name,String.class);
    }

    public String hiError(String name){
        return "hi ,"+name +",不好意思，接口异常";
    }


}
