/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: HiController
 * Author:   zhoulei
 * Date:     2018/6/24 下午12:42
 * Description: 使用feign调用远程接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.rpc.cloud.cloudclientfeign.controller;

import com.demo.rpc.cloud.cloudclientfeign.remoter.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈使用feign调用远程接口〉
 *
 * @author zhoulei
 * @create 2018/6/24
 * @since 1.0.0
 */
@RestController
public class HiController {
    @Autowired
    private SchedualServiceHi schedualServiceHi;

    @RequestMapping("/hi")
    public String sayHi(@RequestParam("name")String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }

}
