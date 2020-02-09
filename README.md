# Mikoto-Log

## 项目介绍
Mikoto-log 是一个用于记录接口入参出参耗时的日志框架

## 安装
通过maven引入
```xml
<dependency>
    <groupId>io.github.lmikoto</groupId>
    <artifactId>mikoto-log</artifactId>
    <version>1.0.0.RELEASE</version>
</dependency>
```
## 使用
在启动类上加上`@EnableMikoLog`注解
```java
@SpringBootApplication
@EnableMikoLog
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
```
在需要记录日志的方法上添加`@Log`注解