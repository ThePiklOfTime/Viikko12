package com.example.viikko12;

import java.util.Random;

public class GameManager {
    private final Player player = new Player();
    private Monster latestMonster;
    private static GameManager gameManager;

    private GameManager() {

    }
    public static GameManager getInstance() {
        if (gameManager == null) {
            gameManager = new GameManager();
        }
        return gameManager;
    }

    public Player getPlayer() {
        return this.player;
    }
    public Monster generateMonster(){
        Random random = new Random();
        int helloWorld = random.nextInt(10);
        if (helloWorld > 5) {
            Skeleton skeleton = new Skeleton();
            latestMonster = skeleton;
            return skeleton;
        }else {
            Vampire vampire = new Vampire();
            latestMonster = vampire;
            return vampire;
        }

    }

    public Monster getLatestMonster() {
        return latestMonster;
    }
}
