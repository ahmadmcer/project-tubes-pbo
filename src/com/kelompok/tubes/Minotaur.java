package com.kelompok.tubes;

public class Minotaur extends Enemy{
    public Minotaur(int level) {
        this.name = "Minotaur";
        this.health = 30 * level;
        this.maxHealth = 30 * level;
        this.attack = 10 * level;
        this.defense = 5 * level;
        this.level = level;
    }

    public String  IntroAlley() {
        super.IntroAlley();
        System.out.println("Hahaha, Human? its sound easy! \nHuman are weak");
        return word;
    }
}
