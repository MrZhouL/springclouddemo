/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ServerController
 * Author:   zhoulei
 * Date:     2018/6/23 下午3:22
 * Description: 服务接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.rpc.cloud.cloudservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈服务接口〉
 *
 * @author zhoulei
 * @create 2018/6/23
 * @since 1.0.0
 */
@RefreshScope //使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
@RestController
public class ServerController {
    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam("param") String param){

        return "rpc:"+param+", 来自于端口："+port;
    }

    @Value("${neo.hello}")
    String ppp;

    @RequestMapping("/testEnv")
    public String testEnv(){
        return ppp;
    }

}
