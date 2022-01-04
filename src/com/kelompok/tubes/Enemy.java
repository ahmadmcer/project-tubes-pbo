package com.kelompok.tubes;

import java.util.Arrays;
import java.util.List;

public class Enemy {
    private String name;
    private int health;
    private int maxHealth;
    private int attack;
    private int defense;
    private int level;

    public Enemy(String name, int health, int maxHealth, int attack, int defense, int level) {
        this.name = name;
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

    List<Enemy> enemies = Arrays.asList(
            new Goblin("Goblin", 15, 15, 3, 3, 1),
            new Slime("Slime",10,10,3,3,1),
            new Minotaur("Minotaur",50,50,10,10,10));

}
