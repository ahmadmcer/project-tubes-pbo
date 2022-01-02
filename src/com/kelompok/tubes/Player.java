package com.kelompok.tubes;

public class Player {
    private int health;
    private int maxHealth;
    private int attack;
    private int defense;
    private int experience;
    private int maxExperience;
    private int level;

    public Player(int health, int maxHealth, int attack, int defense, int experience, int maxExperience, int level) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.maxExperience = maxExperience;
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }

    public int getMaxExperience() {
        return maxExperience;
    }

    public int getLevel() {
        return level;
    }

    public void addHealth(int health) {
        this.health += health;
    }

    public void addAttack(int attack) {
        this.attack += attack;
    }

    public void addDefense(int defense) {
        this.defense += defense;
    }

    public void addExperience(int experience) {
        this.experience += experience;

        if (experience >= maxExperience) {
            this.level += 1;
            this.experience -= maxExperience;
            this.maxExperience *= 2;
        }
    }

    public void onHit(int hit) {
        this.health -= hit;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
