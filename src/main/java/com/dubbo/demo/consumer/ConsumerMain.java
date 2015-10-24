package com.dubbo.demo.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
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

        HelloService helloService = (HelloService) classPathXmlApplicationContext.getBean("helloService");

        helloService.hello("World1");
        Future<String> future1 = RpcContext.getContext().getFuture();

        helloService.hello("World2");
        Future<String> future2 = RpcContext.getContext().getFuture();

        System.out.println("=====================================");
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println("=====================================");
    }
}
