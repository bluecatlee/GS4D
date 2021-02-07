package com.github.bluecatlee.gs4d.cache;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class CacheMain {

    public static void main(String[] var0) throws IOException, InterruptedException {
        ClassPathXmlApplicationContext var1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        var1.start();
        System.out.println("spring 启动好了");

        while(true) {
            Thread.sleep(10000L);
        }
    }

}
