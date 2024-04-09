package com.kisaragiLab.demo.springboot.gameLauncher.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("MarioGameQualifier")
public class MarioGame implements GameControl {
    
    public void up() {
        System.out.println("Jump");
    }

    public void down() {
        System.out.println("Go into a hole");
    }
    
    public void left() {
        System.out.println("Go back");
    }
    
    public void right() {
        System.out.println("Accelerate");
    }

}
