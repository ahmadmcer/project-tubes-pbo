package com.kelompok.tubes;

public class Witch extends Enemy{
    public Witch(int health, int maxHealth, int attack, int defense, int level, int speed) {
        super(health, maxHealth, attack, defense, level, speed);
        this.name = "Witch";
    }
}
