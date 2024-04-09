package com.kisaragiLab.demo.springboot.gameLauncher.game;

import org.springframework.stereotype.Component;

@Component
public class SuperContraGame implements GameControl {

    public void up() {
        System.out.println("up");
    }

    public void down() {
        System.out.println("sit");
    }
    
    public void left() {
        System.out.println("back");
    }
    
    public void right() {
        System.out.println("shoot");
    }

}
