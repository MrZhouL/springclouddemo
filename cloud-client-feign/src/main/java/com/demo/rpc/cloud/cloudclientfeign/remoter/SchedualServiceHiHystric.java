/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: SchedualServiceHiHystric
 * Author:   zhoulei
 * Date:     2018/6/24 下午4:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.rpc.cloud.cloudclientfeign.remoter;

import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zhoulei
 * @create 2018/6/24
 * @since 1.0.0
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{

    @Override
    public String sayHiFromClientOne(String param) {
        return "sorry "+param;
    }
}
