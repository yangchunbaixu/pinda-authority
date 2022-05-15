package com.itheima.pinda;

import com.itheima.pinda.auth.server.EnableAuthServer;
import com.itheima.pinda.user.annotation.EnableLoginArgResolver;
import com.itheima.pinda.validator.config.EnableFormValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import java.net.InetAddress;
import java.net.UnknownHostException;
@SpringBootApplication
@EnableDiscoveryClient  // 开启服务注册发现
@EnableAuthServer      // 生成解析JWT令牌
@EnableFeignClients(value = {  // 开启Feign客户端
        "com.itheima.pinda",
})
@Slf4j
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)  // 通过CGLib生成代理对象
@EnableLoginArgResolver    //  开启当前用户对象的注入
@EnableFormValidator   // 通过 Validator 进行表单检验
public class AuthorityApplication {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AuthorityApplication.class,args);
        // 启动完成后在控制台输出启动成功，并且输出当前服务对应的Swagger文档的路劲

        ConfigurableEnvironment env = applicationContext.getEnvironment();
        log.info("应用'{}'运行成功!  Swagger文档 ： http://{}:{}/doc.heml",
                env.getProperty("spring.applcation.name"),
                InetAddress.getLocalHost().getHostAddress(),  // 获取ip地址
                env.getProperty("server.port")
                );

    }
}
