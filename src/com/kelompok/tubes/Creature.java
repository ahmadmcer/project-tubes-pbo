package com.kelompok.tubes;

public class Creature {
    static int Strength;
    static int HitPoints;
    String Name = "";
    String Species = "";
    int damage;

    public Creature(String name, String species) {
        Name = name;

        if (species.equals("g")||species.equals("G")){
            Species = "Goblin";
            Strength = 100;
            HitPoints = 5;
        } else if (species.equals("s")||species.equals("S")){
            Species = "Slime";
            Strength = 50;
            HitPoints = 3;
        } else if (species.equals("m")||species.equals("M")){
            Species = "Minotaur";
            Strength = 155;
            HitPoints = 10;
        } else if (species.equals("e")||species.equals("E")){
            Species = "Elf";
            Strength = 185;
            HitPoints = 18;
        } else if (species.equals("h")||species.equals("H")){
            Species = "Human";
            Strength = 115;
            HitPoints = 15;
        }
    }
    public static int getHitPoints(String player){
        return HitPoints;
    }
    public String getSpecies(){
        return Species;
    }
    public static int getStrength(){
        return Strength;
    }
    public void setStrength(int newStrength){
        Strength = newStrength;
    }
    public void setHitPoints(int newHit){
        HitPoints = newHit;
    }

    public static int getDamage(String Species, int Hit){
        int hit = (int) (Math.random() * (Hit));
        if (Species == "Slime"){
            int r = (int) (Math.random());
            if (r < .05){
                hit = hit + 50;
            }
        } else if (Species == "Minotaur"){
            int r = (int) (Math.random());
            if (r < .1){
                hit = hit + 50;
            }
        } else if (Species == "Elf"){
            int ElfDouble = 0 + (int) (Math.random() * Hit - 0);
            hit = hit + ElfDouble;
        }

        int damage = hit;
        return damage;
    }

    public static void Damage(int damage){
        Strength = Strength - damage;
    }

    public static boolean isDead(int str){
        if (str <= 0){
            return true;
        } else {
            return false;
        }
    }

    public String getName(){
        return Name;
    }

    public boolean isNamed(String aName){
        return aName.equals(Name);
    }

    public String toString(){
        return " " +Name+ "    "+ Species + "    " + Strength + "      " + HitPoints;
    }
}
