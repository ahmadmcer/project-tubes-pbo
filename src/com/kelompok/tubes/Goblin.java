package com.kelompok.tubes;

public class Goblin extends Enemy{
    public Goblin(int health, int maxHealth, int attack, int defense, int level, int speed) {
        super(health, maxHealth, attack, defense, level, speed);
        this.name = "Goblin";
    }
}
