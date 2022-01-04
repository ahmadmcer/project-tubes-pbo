package com.kelompok.tubes;

public class Enemies {
    static int Strength;
    static int HitPoints;
    String Name = "";
    String Species = "";
    int damage;

    public Enemies(String name, String species) {
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
        }
    }
}
