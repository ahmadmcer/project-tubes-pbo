package com.kelompok.tubes;

public class Minotaur extends Enemy{
    public Minotaur(int level) {
        this.name = "Minotaur";
        this.health = 30 * level;
        this.maxHealth = 30 * level;
        this.attack = 10 * level;
        this.defense = 5 * level;
        this.experience = 15 * level;
        this.level = level;
    }
}
