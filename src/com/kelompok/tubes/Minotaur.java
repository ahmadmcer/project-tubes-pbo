package com.kelompok.tubes;

public class Minotaur extends Enemy{
    public Minotaur(int level) {
        this.name = "Minotaur";
        this.health = 20 * level;
        this.maxHealth = 20 * level;
        this.attack = 5 * level;
        this.defense = 10 * level;
        this.level = level;
    }
}
