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

    @Override
    public String IntroAlley() {
        super.IntroAlley();
        System.out.println("Our people will allways defeat human");
        return word;
    }
}
