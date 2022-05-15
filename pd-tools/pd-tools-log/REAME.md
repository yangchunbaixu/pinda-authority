日志组件：日志实体、事件、拦截器、工具
项目提供日志功能主要有两个方面 ：

1、通过logback框架可以在控制台或者日志文件记录日志信息

2、拦截用户请求，将操作日志保存到数据库

### pd-tools-log涉及到的技术点： 
1、切面Aspect、切点PointCut、通知Advice 
2、Spring Event 异步监听事件 3、logback日志组件 4、函数式接口 5、ThreadLocal

### Logback 构建在三个主要的类上：
Logger，Appender 和 Layout。这三个不同类型的组件一起作用能够让开发者根据消息的类型以及日志的级别来打印日志。

Logger作为日志的记录器，把它关联到应用的对应的context后，主要用于存放日志对象，也可以定义日志类型、级别。各个logger 都被关联到一个 LoggerContext，LoggerContext负责制造logger，也负责以树结构排列各 logger。

Appender主要用于指定日志输出的目的地，目的地可以是控制台、文件、 数据库等。

Layout 负责把事件转换成字符串，输出格式化的日志信息。
### logback的maven坐标
```
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.3</version>
</dependency>
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-core</artifactId>
    <version>1.2.3</version>
</dependency>
```

###  logback初始化步骤
1. logback会在类路径下寻找名为logback-test.xml的文件
2. 如果没有找到，logback会继续寻找名为logback.groovy的文件
3. 如果没有找到，logback会继续寻找名为logback.xml的文件
4. 如果没有找到，将会在类路径下寻找文件META-INFO/services/ch.qos.logback.classic.spi.Configurator，该文件的内容为实现了Configurator接口的实现类的全限定类名
5. 如果以上都没有成功，logback会通过BasicConfigurator为自己进行配置，并且日志将会全部在控制台打印出来
最后一步的目的是为了保证在所有的配置文件都没有被找到的情况下，提供一个默认的配置。