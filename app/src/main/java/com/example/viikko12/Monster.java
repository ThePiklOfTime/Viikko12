package com.example.viikko12;

public abstract class Monster {
    protected String name;
    protected int life;
    protected int maxLife;

    public Monster(String name, int maxLife) {
        this.name = name;
        this.maxLife = maxLife;
        this.life = maxLife;
    }
    public void takeDamage(int Damage) {
        this.life -= Damage;
        if (this.life < 0) {
            this.life = 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public int getMaxLife() {
        return maxLife;
    }
}
