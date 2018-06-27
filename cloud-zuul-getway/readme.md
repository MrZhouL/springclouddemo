# zuul 网关

Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，比如／api/user转发到到user服务，/api/shop转发到到shop服务。zuul默认和Ribbon结合实现了负载均衡的功能。


依赖

```xml
 <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
 </dependency>
```

配置
```xml
spring.application.name=getway
server.port=8087
eureka.client.service-url.defaultZone=http://localhost:8082/eureka

#zuul.routes.*.path 拦截请求的路径，其中*号为自定义的分组标记，如我需要将api/a 转发到hello服务。用于路由配置
zuul.routes.servera.path=/api-a/**

#zuul.routes.*.service-id 根据分组标记（*号的内容）将拦截到的请求转发到某个服务提供方的名称
zuul.routes.servera.service-id=hello

#zuul.rotes.*.url   将拦截的请求转发到具体的URL地址
```

也可以这样
```yml
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8082/eureka/
server:
  port: 8087
spring:
  application:
    name: service-zuul
zuul:
  routes:
    api-a:
      path: /api-a/**
      serviceId: hello
    api-b:
      path: /api-b/**
      serviceId: service-feign
```

过滤器权限验证
详细查看RequestFilter
```java
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
```

最后还需要在程序入口处注入该过滤器，使其生效

```java
    @Bean
    public RequestFilter logFilter(){
        return new RequestFilter();
    }
```