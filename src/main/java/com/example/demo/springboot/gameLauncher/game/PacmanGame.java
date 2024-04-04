package com.example.demo.springboot.gameLauncher.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacmanGame implements GameControl {

    public void up() {
        System.out.println("Move up");
    }

    public void down() {
        System.out.println("Move down");
    }
    
    public void left() {
        System.out.println("Move left");
    }
    
    public void right() {
        System.out.println("Move right");
    }

}
