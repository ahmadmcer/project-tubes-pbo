package com.kelompok.tubes;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String name;
        String newName;
        String race;

        //Initialization Arraylist
        ArrayList<Creature> Player = new ArrayList();

        //Interface Game
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Dragon Slayer");
        System.out.println("1. Start");
        System.out.println("2. Quit");
        System.out.print(">");
        int code = sc.nextInt();
        System.out.println();

        //Exit
        if (code == 2){
            System.exit(0);
        }

        //Main Game
        switch (code){
            case 1:
                //Adding Player
                System.out.println("<=== Add Player ===>");
                System.out.print("Enter Name's Player\t: ");
                name = sc.next();
                System.out.println("\n"+name + ", What race are you ?");
                System.out.println("" +
                        "H/h: Human" +
                        "\nG/g: Goblin" +
                        "\nS/s: Slime" +
                        "\nM/m: Minotaur" +
                        "\nE/e: Elf");
                System.out.print("Please enter your race, " +name+ "\t: ");
                race = sc.next();

                //Re-Typing Adding Player
                Creature player = new Creature(name, race);
                Player.add(player);
                System.out.println(" ");
                System.out.print("Enter Player's Name\t: " + "*Before that, type 'quit' when no more players.");
                newName = sc.next();

                //While typing Quit
                while (!"quit".equals(newName)){
                    System.out.println(newName + ", What race are you ?");
                    System.out.println("" +
                            "H/h: Human" +
                            "\nG/g: Goblin" +
                            "\nS/s: Slime" +
                            "\nM/m: Minotaur" +
                            "\nE/e: Elf");
                    System.out.print("Please Enter Your Race\t: ");
                    race = sc.nextLine();
                    player = new Creature(newName, race);
                    Player.add(player);

                    System.out.println(" ");
                    System.out.println("Enter Player's Name\t: " + "*Before that, type 'quit' when no more players.");
                    newName = sc.nextLine();
                }

                //Message Character Created.
                System.out.println("Congratulations! New Fighters are Created.");
                System.out.println("You will fight until the death, come to you.");
                System.out.println("The Last One Standing Wins. Good Luck Fighters.");
                System.out.println("  |Name|   |Species|     |Strength|      |Hit Points|");
                //Counting
                for (int count = 0; count <= Player.size() - 1; count++){
                    Creature p = Player.get(count);
                    System.out.println(p.toString());
                }
                //Battle Start
                System.out.println("The Players Are Ready!. Let The Battle Begin, for the Dragon");
                for (int i = 0; i <= Player.size() - 1; i++) {
                    Player.get(i);
                    System.out.println(name.toString()+", Select one of the following options");
                    System.out.println("a/A: Attack an Opponent");
                    System.out.println("e/E: Evade");
                    System.out.println("q/Q: Quit");
                    System.out.println("Your Choice\t: ");
                    String choice = sc.next();

                    //Choose A
                    if (choice.equals("a")||choice.equals("A")){
                        System.out.println("Which player are you attacking ?");
                        String target = sc.next();
                        int hitp = 0;
                        for (int j = 0; j < Player.size()-1; j++) {
                            Player.get(j);
                            String targetName = name;
                            if (target.equals(targetName)){
                                hitp = Creature.getHitPoints(name);
                            } else {
                                j++;
                            }
                        }
                        int HitDam = Creature.getDamage(race, hitp);
                        Creature.Damage(HitDam);

                    //Choose P
                    } else if (choice.equals("p")||choice.equals("P")){
                        return;

                    //Choose Q
                    } else if (choice.equals("q")||choice.equals("Q")){
                        Player.remove(i);
                    }

                    for (int m = 0; m < Player.size()-1; i++){
                        int stren = 0;
                        Player.get(m);
                        stren = Creature.getStrength();

                        if (Creature.isDead(stren)){
                            System.out.println("Sorry, " +name.toString()+", you're already dead. Thanks for Playing!");
                            Player.remove(m);
                        }
                    }

                    System.out.println("  |Name|   |Species|     |Strength|      |Hit Points|");
                    for (int count = 0; count <= Player.size()-1; count++){
                        Creature p = Player.get(count);
                        System.out.println(p.toString());
                    }
                }
        }
    }
}
