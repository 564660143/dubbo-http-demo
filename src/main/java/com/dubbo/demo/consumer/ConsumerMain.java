package com.dubbo.demo.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.dubbo.demo.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Future;

/**
 * @author Jerry Lee
 */
public class ConsumerMain {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application-context-consumer.xml");
        classPathXmlApplicationContext.start();

        GenericService helloService = (GenericService) classPathXmlApplicationContext.getBean("helloService");

        helloService.$invoke("hello", new String[]{"java.lang.String"}, new Object[]{"World1"});
        Future<String> future1 = RpcContext.getContext().getFuture();

        helloService.$invoke("hello", new String[]{"java.lang.String"}, new Object[]{"World2"});
        Future<String> future2 = RpcContext.getContext().getFuture();

        System.out.println("=====================================");
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println("=====================================");
    }
}
