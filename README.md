# spring-cloud-learn

# 目录介绍

```lua
spring-cloud-learn
├── common -- 共模块抽取
     ├── common-core 公共核心模块
     └── common-web web公共模块
├── eureka -- 注册中心[8761]
├── gateway -- 服务网关[9000]
└── graphical -- 图形模块聚合 
     ├── admin-server -- Spring Boot Admin监控[9010]
     └── zipkin -- 服务链路追踪[9411]
└── services -- 服务业务聚合
     └── user-service -- 用户服务[9040]
```

# 遇到错误

* 启动报错 
```text
java.nio.charset.MalformedInputException: Input length = 1
```
解决办法:
```text
 File --> Settings --> Editor --->File Encodings 将所有的格式都转成utf-8格式
```


* 整合zipkin访问zipkin ui

```text
java.lang.IllegalArgumentException: Prometheus requires that all meters with the same name have the same set of tag keys. There is already an existing meter named 'http_server_requests_seconds' containing tag keys [method, status, uri]. The meter you are attempting to register has keys [exception, method, outcome, status, uri].
```
解决办法:
```yaml
management:
  metrics:
    web:
      server:
        auto-time-requests: false
```
