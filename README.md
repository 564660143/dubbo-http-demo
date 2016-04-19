Dubbo Http Protocol Demo
========================

Run Provider
---------------------

```bash
mvn jetty:run
```

Or run by main using embedded jetty:

```bash
mvn -Pembedded-jetty package exec:java -Dexec.mainClass=com.dubbo.demo.provider.ProviderMain
```

Run Consumer
----------------------

```bash
mvn package exec:java -Dexec.mainClass=com.dubbo.demo.consumer.ConsumerMain
```

Related Documents
----------------------------

- [Dubbo HTTP Protocol](http://code.alibabatech.com/wiki/display/dubbo/User+Guide-zh#UserGuide-zh-http%3A%2F%2F)
- [Spring中的ContextLoaderListener使用](http://wangpj.iteye.com/blog/882939)
