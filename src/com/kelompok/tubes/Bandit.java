package com.kelompok.tubes;

public class Bandit extends Enemy{
    public Bandit(int level){
        this.name = "Bandit";
        this.health = 15 * level;
        this.maxHealth = 15 * level;
        this.attack = 15 * level;
        this.defense = 10 * level;
        this.experience = 10 * level;
        this.level = level;
    }
}
