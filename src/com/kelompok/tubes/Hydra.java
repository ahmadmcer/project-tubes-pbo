package com.kelompok.tubes;

public class Hydra extends Enemy{
    public Hydra(int level){
        this.name = "Hydra";
        this.health = 50 * level;
        this.maxHealth = 50 * level;
        this.attack = 30 * level;
        this.defense = 20 * level;
        this.experience = 35 * level;
        this.level = level;
    }
}
