# aliyun-sms-spring-boot-starter
基于 `Spring Boot` 框架，快速集成【阿里云】【短信】

## 快速集成
1. 在 `pom.xml` 文件中，引入依赖
    ```xml
    <dependency>
        <groupId>com.github.zhangquanli</groupId>
        <artifactId>aliyun-sms-spring-boot-starter</artifactId>
        <version>1.1.0</version>
    </dependency>
    ```
2. 在 `application.properties` 或 `application.yml` 文件中，进行配置
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
1. 在 Spring Boot 项目中，可以直接注入 `AliyunSms` 接口
    ```java
    @Resource
    private AliyunSms aliyunSms;
    ```
2. 使用 `AliyunSms` 接口封装好的方法

## 更新日志
### 1.1.0
1. 优化请求参数结构，增加请求参数校验功能
2. 升级此版本，可能会导致原有部分代码报错，请按照报错提示修改

### 1.0.2
1. 重构代码实现，原有接口保持不变

### 1.0.1
1. 修复【修改短信模板请求参数不正确】的bug

### 1.0.0
1. 封装阿里云短信服务相关接口
