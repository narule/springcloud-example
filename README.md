# springcloud-example
springcloud projects hwo to use


springcloud

--config 统一配置中心
  config-server 配置中心应用
  config-client 读取配置的客户端应用

--eureka 服务注册发现
  eureka-server 服务注册中心
  eureka-client 服务注册者，真正提供服务的应用

--feign 远程服务调用
  
--gateway 网关路由


## 先启动server-config
上面的项目都可以启动，但是要注意先启动 config-server 其他应用的配置都是通过访问config-server完成
