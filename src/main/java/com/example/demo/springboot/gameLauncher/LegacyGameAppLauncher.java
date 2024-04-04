package com.example.demo.springboot.gameLauncher;

import com.example.demo.springboot.gameLauncher.game.GameRunner;
import com.example.demo.springboot.gameLauncher.game.MarioGame;
import com.example.demo.springboot.gameLauncher.game.PacmanGame;
import com.example.demo.springboot.gameLauncher.game.SuperContraGame;

public class LegacyGameAppLauncher {
    
    public static void main(String[] args) {
        MarioGame marioGame = new MarioGame();
        GameRunner gameRunnerForMario = new GameRunner(marioGame);
        gameRunnerForMario.run();

        SuperContraGame superContraGame = new SuperContraGame();
        GameRunner gameRunnerForContra = new GameRunner(superContraGame);
        gameRunnerForContra.run();

        PacmanGame pacmanGame = new PacmanGame();
        GameRunner gameRunnerForPacman = new GameRunner(pacmanGame);
        gameRunnerForPacman.run();
	}

}
