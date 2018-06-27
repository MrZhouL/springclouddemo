# 服务提供者
就是最苦逼的工蚁，提供各种访问接口服务


# 从配置服务器中获取配置并refresh

该项目相当于配置中心的client端

目的：

从github项目中读取配置文件，每当修改是自动更新到项目中

仓库中的配置文件会被转换成web接口，访问可以参照以下的规则：

- /{application}/{profile}[/{label}]
- /{application}-{profile}.yml
- /{label}/{application}-{profile}.yml
- /{application}-{profile}.properties
- /{label}/{application}-{profile}.properties

以neo-config-dev.properties为例子，它的application是neo-config，profile是dev。client会根据填写的参数来选择读取对应的配置。

1. 添加依赖
```xml
<!--注册服务-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <!--config客户端-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <!--config refresh-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <!--web-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```

2. 配置文件
bootstrap.properties
```properties
spring.cloud.config.name=neo-config
spring.cloud.config.profile=dev
spring.cloud.config.label=master
#spring.cloud.config.uri

spring.cloud.config.discovery.enabled=true
spring.cloud.config.discovery.service-id=cloud-config-service
```

- spring.application.name：对应{application}部分
- spring.cloud.config.profile：对应{profile}部分
- spring.cloud.config.label：对应git的分支。如果配置中心使用的是本地存储，则该参数无用
- spring.cloud.config.uri：配置中心的具体地址

- spring.cloud.config.discovery.enabled ：开启Config服务发现支持
- spring.cloud.config.discovery.service-id：指定配置中心的service-id，便于扩展为高可用配置集群。

application.properties
```properties
management.endpoints.web.exposure.include=*
```

management.endpoints.web.exposure.include :启用/refresh端点，以便我们可以演示动态配置更改

默认情况下，配置值在客户端启动时读取，而不是再次读取。您可以强制一个bean 刷新其配置 - 从Config Server中获取更新的值 - 通过MessageRestController使用Spring Cloud Config 进行注释@RefreshScope，然后触发刷新事件。

```java
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
```

3. 测试

```
$ curl localhost:8080/actuator/refresh -d {} -H "Content-Type: application/json"
```

# 参考
[centralized-configuration](https://spring.io/guides/gs/centralized-configuration/)
[springcloud(八)：配置中心服务化和高可用](http://www.ityouknow.com/springcloud/2017/05/25/springcloud-config-eureka.html)
[springcloud(六)：配置中心git示例](http://www.ityouknow.com/springcloud/2017/05/22/springcloud-config-git.html)