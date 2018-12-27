**重要的事情说三遍**

统一阿里巴巴编码规范，每个人必须安装对应插件！

统一阿里巴巴编码规范，每个人必须安装对应插件！

统一阿里巴巴编码规范，每个人必须安装对应插件！

### 框架简介
* 简单好用的代码生成，微服务每个模块每层都可自动生成，只做核心代码开发，省去大量开发时间
* 统一异常，分为业务，检验，系统异常，任何地方抛出异常都可直接转化为前端提示，无需过多编码
* 快速的数据字典
* 业务状态管理

### 技术选型
* 核心框架：jboot 1.7.5/jfinal 3.4
* 模板引擎：jfinal enjoy
* 注册中心：consul/zookeeper
* RPC：motan/dubbo
* RPC治理：motan-manager
* 安全框架：shiro/jwt
* 缓存框架：ehcache/redis
* 容错隔离：hystrix
* 调用监控：hystrix-dashboard
* 链路跟踪：zipkin


### 模块说明
项目为使用Maven构建的多模块项目

* ncloud: 父模块，主要管理依赖
* ncloud-base: 框架相关代码
* ncloud-oauth: 权限认证模块
* ncloud-upms: upms接口模块
* ncloud-upms-service: upms接口服务模块，包含api, model, provider三个子模块
* ncloud-upms-service-api: upms服务API模块，定义服务端与客户端API标准
* ncloud-upms-service-model: upms服务实体模块，定义服务所需model，vo，状态类
* ncloud-upms-service-provider: upms服务实现模块，针对API的实现

### 项目使用

**请使用JDK8及以上版本，数据库为MySQL**

    1. 启动consul或zookeeper，目前配置文件默认是consul+motan，如需替换dubbo+zookeeper 可参考下面的配置进行更改
    2. 启动redis，需要配置密码为123456，可在配置文件进行修改
    3. 如需更改db/redis/consul/zookeeper等配置请更新客户端配置文件：ncloud-upms/resources/jboot.properties
    4. 如需更改db/redis/consul/zookeeper等配置请更新服务端配置文件：ncloud-upms-service-provider/resources/jboot.properties
    5. 启动客户端，客户端启动入口：net.ninemm.upms.run.Application(ncloud-upms)
    6. 启动服务端，服务端启动入口：net.ninemm.upms.run.Application(ncloud-upms-service-provider)
    7. 
    
    附加：
    监控相关功能需要安装对应服务才可正常使用
    注册中心监控需要安装：consul或zookeeper
    服务调用监控需要安装：hystrix-dashboard
    链路跟踪监控需要安装：zipkin-server
    服务治理需要安装：motan-manager
    这些都可以在网上下载或自己编译
    
### 配置说明
可以在配置文件中更改db, consul, zookeeper, cache, mq等配置

motan + consul配置示例

    #use motan  + consul
    jboot.rpc.type = motan
    jboot.rpc.registryType = consul
    jboot.rpc.registryAddress = 127.0.0.1:8500
    
dubbo + zookeeper配置示例

    #use dubbo + zookeeper
    jboot.rpc.type = dubbo
    jboot.rpc.registryType = zookeeper
    jboot.rpc.registryAddress = 127.0.0.1:2181
    
### 代码生成
对jboot代码生成进行了配置文件的封装，使用更简单方便

1、 配置代码生成配置文件，包含数据库配置与代码生成包相关配置
    
    配置文件位置：
    各模块中 resources/jboot.properties
    
2、执行代码生成类     

    代码生成入口：
    service interface api 生成：net.ninemm.upms.gencode.GenCode (tcloud-service-api)
    model 实体生成： net.ninemm.upms.gencode.GenCode (tcloud-service-model)
    service impl 实现层生成： net.ninemm.upms.gencode.GenCode (tcloud-service-api-provider)
    
provider实现类生成配置文件示例：

    #---------------------------------------------------------------------------------#
    # Generator Config
    # jboot.admin.serviceimpl.ge.entity.package: the entity package;
    # jboot.admin.serviceimpl.ge.servicepackage：service 接口 package
    # jboot.admin.serviceimpl.ge.serviceimplpackage：service 实现类 package
    # jboot.admin.serviceimpl.ge.removedtablenameprefixes: 需要移除表名前缀只留下后部分，多个逗号隔开
    # jboot.admin.serviceimpl.ge.includedtable: 生成指定表表名列表，多个逗号隔开
    # jboot.admin.serviceimpl.ge.excludedtable: 生成时不包含表名列表，多个逗号隔开
    # jboot.admin.serviceimpl.ge.excludedtableprefixes: 生成时不包含表前缀，多个逗号隔开
    #---------------------------------------------------------------------------------#
    jboot.admin.serviceimpl.ge.modelpackage=io.jboot.admin.service.entity.model
    jboot.admin.serviceimpl.ge.servicepackage=io.jboot.admin.service.api
    jboot.admin.serviceimpl.ge.serviceimplpackage=io.jboot.admin.service.provider
    jboot.admin.serviceimpl.ge.removedtablenameprefixes=sys_
    jboot.admin.serviceimpl.ge.excludedtable=
    jboot.admin.serviceimpl.ge.excludedtableprefixes=temp_,v_    
    
