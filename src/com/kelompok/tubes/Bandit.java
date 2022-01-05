package com.kelompok.tubes;

public class Bandit extends Enemy{
    public Bandit(int health, int maxHealth, int attack, int defense, int level, int speed) {
        super(health, maxHealth, attack, defense, level, speed);
        this.name = "Bandit";
    }
}
