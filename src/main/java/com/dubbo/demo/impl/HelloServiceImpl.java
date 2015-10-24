package com.dubbo.demo.impl;

import com.dubbo.demo.HelloService;

import java.util.Date;

/**
 * @author Jerry Lee
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        System.out.println("received " + name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Hello, " + name +  " " + System.currentTimeMillis() + "!";
    }
}
