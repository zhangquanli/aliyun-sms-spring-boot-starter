# aliyun-sms-spring-boot-starter
基于 Spring Boot 框架，快速集成阿里云短信服务

## 快速集成
- 在 `pom.xml` 文件中引入依赖
```xml
<dependency>
    <groupId>com.github.zhangquanli</groupId>
    <artifactId>aliyun-sms-spring-boot-starter</artifactId>
    <version>1.0.1</version>
</dependency>
```
- 在 `application.properties` 或 `application.yml` 文件中，进行配置
```properties
aliyun.sms.access-key-id=accessKeyId
aliyun.sms.access-key-secret=accessKeySecret
```
```yaml
aliyun:
  sms:
    access-key-id: accessKeyId
    access-key-secret: accessKeySecret
```

## 快速开发
- 在 Spring Boot 项目中，可以直接注入 `AliyunSms` 接口
```java
@Resource
private AliyunSms aliyunSms;
```
- 使用 `AliyunSms` 接口封装好的方法，快速集成阿里云短信服务

## 更新日志
### 1.0.1
1. 修复【修改短信模板请求参数不正确】的bug

### 1.0.0
1. 封装阿里云短信服务相关接口
