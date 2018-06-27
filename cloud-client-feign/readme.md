# 服务消费者（Feign）

Feign 是一个声明式的Web服务客户端，通过简单的注解便可像调用本地方法一样调用远程服务。
Spring Cloud为Feign添加了Spring MVC的注解支持，并整合了Ribbon和Eureka 来为Feign提供负载均衡功能。


# 在Feign中使用Hystrix熔断器
引入依赖,不用！！
Feign是自带断路器的，在D版本的Spring Cloud中，它没有默认打开。需要在配置文件中配置打开它，在配置文件加以下
```xml
 feign.hystrix.enabled=true
```
或者
```yml
feign:
    hystrix:
       enabled: true
```

只需要在FeignClient的SchedualServiceHi接口的注解中加上fallback的指定类就行了：
```java
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
```

SchedualServiceHiHystric需要实现SchedualServiceHi 接口，并注入到Ioc容器中，代码如下：

```java
    public class SchedualServiceHiHystric implements SchedualServiceHi {
        @Override
        public String sayHiFromClientOne(String name) {
            return "sorry "+name;
        }
    }
```


# 测试
启动cloud-eureka cloud-service
启动cloud-client-feign

关闭cloud-service
访问服务结果

sorry name
# 参考
[史上最简单的SpringCloud教程 | 第三篇: 服务消费者（Feign）](https://blog.csdn.net/forezp/article/details/69808079)