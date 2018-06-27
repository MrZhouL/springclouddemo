/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: RequestFilter
 * Author:   zhoulei
 * Date:     2018/6/24 下午6:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.rpc.cloud.cloudzuulgetway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 通过继承ZuulFilter类实现过滤功能，与SpringMVC 的HandlerInterceptor类似
 *
 * @author zhoulei
 * @create 2018/6/24
 * @since 1.0.0
 */
public class RequestFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(RequestFilter.class);
    /**
     * 返回一个字符串，表示该过滤器在何时调用
     * pre ： 在请求被路由器之前调用
     * routing ： 在路由请求时被调用
     * error ： 在请求是发生错误时调用
     * post ： 在routing和error过滤器之后调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 标识该过滤器链中执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 标示该过滤器是否开启，默认false
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext content = RequestContext.getCurrentContext();
        javax.servlet.http.HttpServletRequest request = content.getRequest();
        String token = request.getParameter("token");
        if (token == null || !token.equals("1")){
            log.warn("token is null or token illegal ");
            content.setResponseBody("token error");
            content.setSendZuulResponse(false);
        }
        log.info("ok");
        return null;
    }
}
