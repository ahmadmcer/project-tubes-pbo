package com.kelompok.tubes;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Initialization Objects
        Random random = new Random();
        Scanner scan = new Scanner(System.in); // Scanner

        // Initialization Variables
        boolean input = true;
        boolean gameover = false; // For checking if is game over
        boolean canWalk = true; // For checking if is can walk or not
        boolean canRest = false; // For checking if is can rest or not
        boolean fight = false; // For checking if is fight or not
        int code; // Code for input action
        int gacha; // Gacha (random) events

        // Welcome message
        do {
            System.out.println("Welcome to Dragon Slayer!");
            System.out.println("1. Start");
            System.out.println("2. Exit");
            System.out.print("> ");

            try {
                code = scan.nextInt();
                if (code == 1) {
                    break;
                } else if (code == 2) {
                    System.exit(0);
                } else {
                    System.out.println("\n[ERROR] Input action not recognized, please try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR] Input action not recognized, please try again!");
                scan.nextLine();
            }
        } while (true);

        // Initialization Player
        Player player = new Player(20, 20, 5, 5, 0, 8, 1);

        // Game start
        while (!gameover) {
            // Walking
            while (canWalk) {
                do {
                    System.out.println("\nYou woke up.");
                    System.out.println("[Your Action]");
                    System.out.println("1. Walk");
                    System.out.println("2. Show Stats");

                    try {
                        System.out.print("> ");
                        code = scan.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("\n[ERROR] Input action not recognized, please try again!");
                        scan.nextLine();
                    }
                } while (true);


                switch (code) {
                    case 1: // Walk
                        gacha = random.nextInt(10); // Gacha for chance to meet enemy
                        if (gacha > 2) {
                            // Initialization Enemy
                            Enemy enemy;
                            gacha = random.nextInt(3); // Gacha for the chance of enemy types that appear
                            switch (gacha) {
                                case 0: // Slime
                                    gacha = random.nextInt(player.getLevel());
                                    enemy = new Slime(gacha + 1);
                                    break;
                                case 1: // Goblin
                                    gacha = random.nextInt(player.getLevel());
                                    enemy = new Goblin(gacha + 1);
                                    break;
                                case 2: // Minotaur
                                    gacha = random.nextInt(player.getLevel());
                                    enemy = new Minotaur(gacha + 1);
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + gacha);
                            }

                            // Message meets enemy
                            do {
                                System.out.println("\nYou cross paths with " + enemy.getName() + " Lv " + enemy.getLevel() + ".");
                                System.out.println("[Your Action]");
                                System.out.println("1. Fight");
                                System.out.println("2. Run");

                                try {
                                    System.out.print("> ");
                                    code = scan.nextInt();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("\n[ERROR] Input action not recognized, please try again!");
                                    scan.nextLine();
                                }
                            } while (true);

                            switch (code) {
                                case 1: // Fight with enemy
                                    fight = true;
                                    break;
                                case 2: // Try run to escape
                                    gacha = random.nextInt(2);
                                    if (gacha == 1) {
                                        fight = true;
                                        System.out.println("\nYou got caught by the enemy!");
                                    } else {
                                        System.out.println("\nYou escaped.");
                                        canWalk = false;
                                        canRest = true;
                                    }
                                    break;
                            }

                            while (fight) {
                                // Player turn
                                do {
                                    System.out.print("\n[Player Lv. " + player.getLevel() + "]");
                                    System.out.println("\t\t\t[" + enemy.getName() + " Lv. " + enemy.getLevel() + "]");

                                    System.out.print(" HP : " + player.getHealth() + "/" + player.getMaxHealth());
                                    System.out.println("\t\t\t\t HP : " + enemy.getHealth() + "/" + enemy.getMaxHealth());

                                    System.out.print(" ATK: " + player.getAttack());
                                    System.out.println("\t\t\t\t\t ATK: " + enemy.getAttack());

                                    System.out.print(" DEF: " + player.getDefense());
                                    System.out.println("\t\t\t\t\t DEF: " + enemy.getDefense());

                                    System.out.println("\n[Your Action]");
                                    System.out.println("1. Attack");
                                    System.out.println("2. Defend");

                                    try {
                                        System.out.print("> ");
                                        code = scan.nextInt();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("\n[ERROR] Input action not recognized, please try again!");
                                        scan.nextLine();
                                    }
                                } while (true);

                                switch (code) {
                                    case 1: // Player attack
                                        System.out.print("\nYou attack the enemy, ");
                                        player.setDefend(false);
                                        if (enemy.getDefend()) { // Enemy is defending
                                            int hit = player.getAttack() - enemy.getDefense();
                                            if (hit > 0) {
                                                enemy.onHit(hit);
                                                System.out.println("they lost " + hit + " HP.");
                                            } else {
                                                System.out.println("they didn't get hurt.");
                                            }
                                        } else { // Enemy isn't defending
                                            enemy.onHit(player.getAttack());
                                            System.out.println("they lost " + player.getAttack() + " HP.");
                                        }
                                        break;
                                    case 2: // Player defend
                                        System.out.println("\nYou're defending.");
                                        player.setDefend(true);
                                        break;
                                }

                                // Enemy turn
                                gacha = random.nextInt(2);
                                if (gacha == 1) { // Enemy attack
                                    enemy.setDefend(false);
                                    if (player.getDefend()) { // Player is defending
                                        int hit = enemy.getAttack() - player.getDefense();
                                        if (hit > 0) {
                                            player.onHit(hit);
                                            System.out.println("Enemy is attacking, you lost " + hit + " HP.");
                                        } else {
                                            System.out.println("Enemy is attacking, you didn't get hurt.");
                                        }
                                    } else { // Player isn't defending
                                        player.onHit(enemy.getAttack());
                                        System.out.println("Enemy is attacking, you lost " + enemy.getAttack() + " HP.");
                                    }
                                } else { // Enemy defend
                                    System.out.println("Enemy is defending.");
                                    enemy.setDefend(true);
                                }

                                // Player died
                                if (player.getHealth() <= 0) {
                                    System.out.println("\nYou died!");
                                    System.out.println("EXP: " + player.getExperience() + "/" + player.getMaxExperience());
                                    System.out.println("LVL: " + player.getLevel());
                                    fight = false;
                                    canWalk = false;
                                    gameover = true;
                                }

                                // Enemy died
                                if (enemy.getHealth() <= 0) {
                                    System.out.println("\nYou win fight!");

                                    // Player get experience
                                    int experience = 8 * enemy.getLevel();
                                    player.addExperience(experience);
                                    System.out.println("You get " + experience + " EXP.");

                                    while (player.getExperience() >= player.getMaxExperience()) { // Player leveling up
                                        System.out.println("\nYou leveled up!");
                                        player.addExperience(player.getMaxExperience() * -1);
                                        player.addMaxExperience(8);
                                        player.addLevel(1);
                                        player.addHealth(20);
                                        player.addMaxHealth(20);

                                        // Get +1 stats
                                        do {
                                            System.out.println("\nYou get +5 stats, please choose:");
                                            System.out.println("1. Attack +5");
                                            System.out.println("2. Defend +5");

                                            try {
                                                System.out.print("> ");
                                                code = scan.nextInt();
                                                break;
                                            } catch (Exception e) {
                                                System.out.println("\n[ERROR] Input action not recognized, please try again!");
                                                scan.nextLine();
                                            }
                                        } while (true);

                                        // Choose stats to increase +1
                                        switch (code) {
                                            case 1:
                                                player.addAttack(5);
                                                break;
                                            case 2:
                                                player.addDefense(5);
                                                break;
                                        }
                                    }

                                    fight = false;
                                    canWalk = false;
                                    canRest = true;
                                }
                            }
                        } else {
                            canWalk = false;
                            canRest = true;
                            break;
                        }
                        break;
                    case 2: // Show stats
                        System.out.println("\n[Player Stats]");
                        System.out.println(" HP : " + player.getHealth() + "/" + player.getMaxHealth());
                        System.out.println(" ATK: " + player.getAttack());
                        System.out.println(" DEF: " + player.getDefense());
                        System.out.println(" EXP: " + player.getExperience() + "/" + player.getMaxExperience());
                        System.out.println(" LVL: " + player.getLevel());
                        break;
                }
            }

            // Resting
            while (canRest) {
                do {
                    System.out.println("\nYou're very tired and you can't keep going for tonight.");
                    System.out.println("[Your Action]");
                    System.out.println("1. Rest");
                    System.out.println("2. Show Stats");

                    try {
                        System.out.print("> ");
                        code = scan.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("\n[ERROR] Input action not recognized, please try again!");
                        scan.nextLine();
                    }
                } while (true);

                switch (code) {
                    case 1: // Rest
                        System.out.println("\nYou're now resting.");
                        player.setHealth(player.getMaxHealth());
                        canRest = false;
                        canWalk = true;
                        break;
                    case 2: // Show stats
                        System.out.println("\n[Player Stats]");
                        System.out.println(" HP : " + player.getHealth() + "/" + player.getMaxHealth());
                        System.out.println(" ATK: " + player.getAttack());
                        System.out.println(" DEF: " + player.getDefense());
                        System.out.println(" EXP: " + player.getExperience() + "/" + player.getMaxExperience());
                        System.out.println(" LVL: " + player.getLevel());
                        break;
                }
            }
        }
    }
}
