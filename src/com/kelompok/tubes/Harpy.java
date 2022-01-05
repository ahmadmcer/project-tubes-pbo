package com.kelompok.tubes;

public class Harpy extends Enemy{
    public Harpy(int level){
        this.name = "Harpy";
        this.health = 20 * level;
        this.maxHealth = 20 * level;
        this.attack = 20 * level;
        this.defense = 10 * level;
        this.experience = 12 * level;
        this.level = level;
    }
}
