package com.example.demo.springboot.lazyInitialisation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {
    
    private ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("Some initialisation logic");
        this.classA = classA;
    }

}

@Configuration
@ComponentScan
public class LazyInitialisationLauncher {
    
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LazyInitialisationLauncher.class)) {
            System.out.println(context.getBean(ClassB.class));
        }
	}

}
