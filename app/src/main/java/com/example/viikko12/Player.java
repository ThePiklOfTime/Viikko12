package com.example.viikko12;

public class Player {
    private int damage;
    private int score;

    public Player() {
        this.damage = 5;
        this.score = 0;
    }
    public void attack(Monster monster) {
        monster.takeDamage(damage);
    }

    public int getScore() {
        return score;
    }
    public void addToScore(int add) {
        this.score += add;
    }
}

