package com.kelompok.tubes;

public class Witch extends Enemy{
    public Witch(int level){
        this.name = "Witch";
        this.health = 30 * level;
        this.maxHealth = 30 * level;
        this.attack = 15 * level;
        this.defense = 10 * level;
        this.experience = 15 * level;
        this.level = level;
    }
}
