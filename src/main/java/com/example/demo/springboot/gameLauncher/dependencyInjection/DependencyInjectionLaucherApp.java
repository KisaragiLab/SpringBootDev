package com.example.demo.springboot.gameLauncher.dependencyInjection;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusiness {
    // @Autowired   // Field injection
    Dependency1 dependency1;

    // @Autowired   // Field injection
    Dependency2 dependency2;

    @Autowired  // Constructor injection
    public YourBusiness(Dependency1 dependency1, Dependency2 dependency2) {
        super();
        System.out.println("Constructor Injection");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }
    

    @Autowired  // Setter injection
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter Injection - Dependency1");
        this.dependency1 = dependency1;
    }

    @Autowired  // Setter injection
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter Injection - Dependency2");
        this.dependency2 = dependency2;
    }

    public Dependency1 getDependency1() {
        return dependency1;
    }

    public Dependency2 getDependency2() {
        return dependency2;
    }

    public String toStirng() {
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1 {
    
}

@Component
class Dependency2 {
    
}

@Configuration
@ComponentScan
public class DependencyInjectionLaucherApp {
    
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DependencyInjectionLaucherApp.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(YourBusiness.class).toStirng());
        }
	}

}
