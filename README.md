# spring-boot
spring boot + jcache + swagger2 + druid + shiro + spring session + webscoket(基于netty)

项目功能描述

一个关于Spring boot的学习项目，使用Spring boot 2.0。

拓展Spring boot默认的数据源，引入阿里巴巴的Druid数据库，同时用户仍然可以向原来一样轻松切换数据源。

引入swagger2，无需任何额外的工作，即可将任意的Restful接口映射为API。

使用Ecache 3.x来做缓存介质，使用Spring cache注解驱动来生成和修改缓存。

引入防重复提交功能，包含Ajax注解增强。

全新的异常增强。

引入Quartz，使用简单的注解来处理定时任务。

加入基于netty的webScoket。

加入Spring session处理session在负载均衡上的一致性。

加入Apache shiro实现权限验证

如何使用

导入maven项目，maven -> install
