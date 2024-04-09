package com.kisaragiLab.demo.springboot.helloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HellowWorldLauncher {
    
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));

            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("personMethodCall"));
            System.out.println(context.getBean("personParameters"));

            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean(Address.class)); // Alt way
            System.out.println(context.getBean("personWithQualifier"));
        }
    }

}
