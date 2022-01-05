package com.kelompok.tubes;

public class Dragon extends Enemy{
    public Dragon(int level){
        this.name = "Dragon";
        this.health = 400 * level;
        this.maxHealth = 400 * level;
        this.attack = 200 * level;
        this.defense = 150 * level;
        this.experience = 120 * level;
        this.level = level;
    }
}
