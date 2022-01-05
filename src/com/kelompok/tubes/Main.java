package com.kelompok.tubes;

import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Initialization Objects
        Random random = new Random();
        Scanner scan = new Scanner(System.in); // Scanner

        // Initialization Variables
        boolean gameover = false; // For checking if is game over
        boolean fight = false; // For checking if is fight or not
        int gacha; // Gacha event (random)
        int code; // Code for input action

        System.out.println("Welcome to Dragon Slayer!");
        System.out.println("1. Start");
        System.out.println("2. Exit");
        System.out.print("> ");
        code = scan.nextInt();
        System.out.println();

        // For exit
        if (code == 2) {
            System.exit(0);
        }

        // Initialization Player
        Player player = new Player(30, 100, 10  , 15, 0, 10, 1, 5 );

        // Main game
        while (!gameover) {
            System.out.println("[Your Action]");
            System.out.println("1. Walk");
            System.out.println("2. Rest");
            System.out.println("3. Show Stats");
            System.out.print("> ");
            code = scan.nextInt();
            System.out.println();

            switch (code) {
                case 1:
                    // Walk
                    gacha = random.nextInt(2);

                    if (gacha == 1) {
                        // Initialization Enemy
                        Enemy enemy;
                        gacha = random.nextInt(3);
                        switch (gacha) {
                            case 0:
                                enemy = new Slime(5, 5, 1, 0, 1, 2 );
                                break;
                            case 1:
                                enemy = new Goblin(15, 15, 3, 2, 1, 4);
                                break;
                            case 2:
                                enemy = new Minotaur(80, 150, 10, 15, 10, 3);
                                break;
                            case 3:
                                enemy = new Harpy(30, 45, 18, 10, 11, 8);
                                break;
                            case 4:
                                enemy = new Bandit(60, 75, 8, 12, 19, 6);
                                break;

                            default:
                                throw new IllegalStateException("Unexpected value: " + gacha);
                        }
                        
                        System.out.println("You meet " + enemy.getName() + " (enemy).");
                        System.out.println("[Your Action]");
                        System.out.println("1. Fight");
                        System.out.println("2. Run");
                        System.out.print("> ");
                        code = scan.nextInt();
                        System.out.println();

                        switch (code) {
                            case 1:
                                fight = true;
                                break;
                            case 2:
                                gacha = random.nextInt(2);
                                if (gacha == 1) {
                                    fight = true;
                                    System.out.println("You got caught by the enemy!");
                                } else {
                                    System.out.println("You got away.");
                                }
                                break;
                        }

                        while (fight) {
                            System.out.println("[Player Lv. " + player.getLevel() + "]");
                            System.out.println("HP: " + player.getHealth() + "/" + player.getMaxHealth());
                            System.out.println("[Enemy Lv. " + enemy.getLevel() + "]");
                            System.out.println("HP: " + enemy.getHealth() + "/" + enemy.getMaxHealth());

                            System.out.println("\n[Your Action]");
                            System.out.println("1. Attack");
                            System.out.println("2. Defend");
                            System.out.println("3. Show Enemy Stats");
                            System.out.println("4. Show Your Stats");
                            System.out.print("> ");
                            code = scan.nextInt();
                            System.out.println();

                            switch (code) {
                                case 1:
                                    System.out.print("You are attacking, ");
                                    gacha = random.nextInt(2);
                                    if (gacha == 1) { // Enemy attacking
                                        // Player turn
                                        enemy.onHit(player.getAttack());
                                        System.out.println("enemy get hit by " + player.getAttack() + ".");

                                        // Enemy turn
                                        player.onHit(enemy.getAttack());
                                        System.out.println("Now enemy is attacking, you get hit by " + enemy.getAttack());
                                    } else { // Enemy defending
                                        int hit = player.getAttack() - enemy.getDefense();

                                        if (hit > 0) {
                                            enemy.onHit(hit);
                                            System.out.println("but enemy is defending, enemy get hit by " + hit + ".");
                                        } else {
                                            System.out.println("but enemy is defending, enemy not get hit.");
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.print("You are defending, ");
                                    gacha = random.nextInt(2);
                                    if (gacha == 1) { // Enemy attacking
                                        int hit = enemy.getAttack() - player.getDefense();

                                        if (hit > 0) {
                                            player.onHit(hit);
                                            System.out.println("and enemy is attacking, you get hit by " + hit + ".");
                                        } else {
                                            System.out.println("and enemy is attacking, you not get hit.");
                                        }
                                    } else { // Enemy defending
                                        System.out.println("but enemy is defending, no one get hit.");
                                    }
                                    break;
                                case 3:
                                    System.out.println("[Enemy Stats]");
                                    System.out.println("Health\t: " + enemy.getHealth() + "/" + enemy.getMaxHealth());
                                    System.out.println("Attack\t: " + enemy.getAttack());
                                    System.out.println("Defense\t: " + enemy.getDefense());
                                    System.out.println("Level\t: " + enemy.getLevel());
                                    System.out.println("Speed\t: " + enemy.getspeed());
                                    break;
                                case 4:
                                    System.out.println("[Player Stats]");
                                    System.out.println("Health\t\t: " + player.getHealth() + "/" + player.getMaxHealth());
                                    System.out.println("Attack\t\t: " + player.getAttack());
                                    System.out.println("Defense\t\t: " + player.getDefense());
                                    System.out.println("Experience\t: " + player.getExperience());
                                    System.out.println("Level\t\t: " + player.getLevel());
                                    System.out.println("Speed\t\t: " + player.getspeed());
                                    break;
                            }

                            // Player dead
                            if (player.getHealth() <= 0) {
                                System.out.println("You Dead!");
                                fight = false;
                                gameover = true;
                            }

                            // Player win fight
                            if (enemy.getHealth() <= 0) {
                                System.out.println("You win fight!");

                                int experience = 8 * enemy.getLevel();
                                if (experience >= player.getMaxExperience()) { // Checking if is level up
                                    System.out.println("You Level Up!");
                                    player.addHealth(player.getMaxHealth());
                                    player.addMaxHealth(player.getMaxHealth());

                                    // Get +1 stats
                                    System.out.println("You get +1 stats, please choice:");
                                    System.out.println("1. Attack +3");
                                    System.out.println("2. Defend +5");
                                    System.out.print(">");
                                    code = scan.nextInt();
                                    System.out.println();

                                    // Choice stats to increase +1
                                    switch (code) {
                                        case 1:
                                            player.addAttack(3);
                                            break;
                                        case 2:
                                            player.addDefense(5);
                                            break;
                                    }
                                }

                                player.addExperience(experience);
                                fight = false;
                            }

                            System.out.println();
                        }

                    } else {
                        System.out.println("You reach the end of the day.");
                    }
                    break;
                case 2:
                    // Rest
                    System.out.println("You are now resting.");
                    player.setHealth(player.getMaxHealth());
                    break;
                case 3:
                    // Show stats
                    System.out.println("[Player Stats]");
                    System.out.println("Health\t\t: " + player.getHealth() + "/" + player.getMaxHealth());
                    System.out.println("Attack\t\t: " + player.getAttack());
                    System.out.println("Defense\t\t: " + player.getDefense());
                    System.out.println("Experience\t: " + player.getExperience());
                    System.out.println("Level\t\t: " + player.getLevel());
                    break;
            }

            System.out.println();
        }
    }
}
