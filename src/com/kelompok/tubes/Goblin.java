package com.kelompok.tubes;

public class Goblin extends Enemy{
    public Goblin(int level) {
        this.name = "Goblin";
        this.health = 10 * level;
        this.maxHealth = 10 * level;
        this.attack = 3 * level;
        this.defense = 1 * level;
        this.level = level;
    }
}
