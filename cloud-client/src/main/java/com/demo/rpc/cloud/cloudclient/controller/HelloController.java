/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: HelloController
 * Author:   zhoulei
 * Date:     2018/6/24 上午11:04
 * Description: 调用服务端测速类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.rpc.cloud.cloudclient.controller;

import com.demo.rpc.cloud.cloudclient.server.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈调用服务端测速类〉
 *
 * @author zhoulei
 * @create 2018/6/24
 * @since 1.0.0
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
}
