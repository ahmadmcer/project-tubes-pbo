package com.kelompok.tubes;

public class Enemy {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attack;
    protected int defense;
    protected int level;

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getLevel() {
        return level;
    }

    public void onHit(int hit) {
        this.health -= hit;
    }
}
