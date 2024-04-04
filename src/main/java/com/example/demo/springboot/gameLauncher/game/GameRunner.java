package com.example.demo.springboot.gameLauncher.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    private GameControl game;

    public GameRunner(@Qualifier("MarioGameQualifier") GameControl game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }

}
