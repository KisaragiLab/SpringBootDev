package com.example.demo.springboot.prePost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class ClassA {

    private ClassB classB;
    public ClassA(ClassB classB) {
        super();
        this.classB = classB;
        System.out.println("ClassA has been instantiated");
    }

    @PostConstruct
    public void initialise() {
        classB.getReady();
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("Clean up!");
    }

}

@Component
class ClassB {
    
    public void getReady() {
        System.out.println("Some business logic");
    }

}

@Configuration
@ComponentScan
public class PrePostAnnotationLauncher {
    
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostAnnotationLauncher.class)) {
            System.out.println(context.getBean(ClassA.class));
        }
	}

}
