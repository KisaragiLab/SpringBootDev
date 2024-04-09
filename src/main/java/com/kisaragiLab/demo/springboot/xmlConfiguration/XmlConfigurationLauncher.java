package com.kisaragiLab.demo.springboot.xmlConfiguration;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kisaragiLab.demo.springboot.gameLauncher.game.GameRunner;

public class XmlConfigurationLauncher {
    
    public static void main(String[] args) {
        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            context.getBean(GameRunner.class).run();
        }
	}

}
