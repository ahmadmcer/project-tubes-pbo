package com.kelompok.tubes;

public class Enemy {
    protected String name;
    private int health;
    private int maxHealth;
    private int attack;
    private int defense;
    private int level;

    public Enemy(int health, int maxHealth, int attack, int defense, int level) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.defense = defense;
        this.level = level;
    }

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
