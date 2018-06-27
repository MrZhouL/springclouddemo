# 服务消费者（rest+ribbon）

ribbon 是一个基于HTTP和TCP客户端的负载均衡器，通过客户端中配置的ribbonServerList服务器列表去轮询访问以达到均衡负载的作用。

其核心组件：
- Rule --从服务列表中如何获取一个有效的服务
- Ping --后台运行线程用来判断服务是否可用
- serverList --服务列表

# 项程构建

新建SpringBoot项目，使用sts，
选择需要的SpringBoot版本
勾选Eureka Discovery依赖 Routing选项的Ribbon依赖 及Web依赖



# 服务编写
具体查看类

# 在ribbon中使用熔断器（Hystrix）

在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），在Spring Cloud可以用RestTemplate+Ribbon和Feign来调用。为了保证其高可用，单个服务通常会集群部署。由于网络原因或者自身的原因，服务并不能保证100%可用，如果单个服务出现问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应。

为了解决这个问题，业界提出了断路器模型。

引入hystrix依赖

```xml
 <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```

详细查看代码

# 参考
[史上最简单的SpringCloud教程 | 第四篇:断路器（Hystrix）](https://blog.csdn.net/forezp/article/details/69934399)

[Circuit Breaker: Hystrix Clients](http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/multi/multi__circuit_breaker_hystrix_clients.html)