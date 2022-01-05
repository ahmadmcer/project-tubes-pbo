package com.kelompok.tubes;

public class Slime extends Enemy{
    public Slime(int health, int maxHealth, int attack, int defense, int level, int speed) {
        super(health, maxHealth, attack, defense, level, speed);
        this.name = "Slime";
    }
}
