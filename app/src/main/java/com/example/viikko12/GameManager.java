package com.example.viikko12;

public class GameManager {
    private Player player;
    private static GameManager gameManager;
    public static GameManager getInstance() {
        if (gameManager == null) {
            gameManager = new GameManager();
        }
        return gameManager;
    }

    public Player getPlayer() {
        return this.player;
    }
}
