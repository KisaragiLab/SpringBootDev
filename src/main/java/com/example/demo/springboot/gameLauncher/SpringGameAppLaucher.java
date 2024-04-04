package com.example.demo.springboot.gameLauncher;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.springboot.gameLauncher.game.GameControl;
import com.example.demo.springboot.gameLauncher.game.GameRunner;

@Configuration
@ComponentScan("com.example.demo.springboot.gameLauncher")
public class SpringGameAppLaucher {
    
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringGameAppLaucher.class)) {
            context.getBean(GameControl.class).up();
            context.getBean(GameRunner.class).run();
        }
	}

}
