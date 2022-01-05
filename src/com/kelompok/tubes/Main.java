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
        boolean canRest = false; // For checking if is can rest or not
        boolean fight = false; // For checking if is fight or not
        int gacha; // Gacha event (random)
        int code; // Code for input action

        System.out.println("Welcome to Dragon Slayer!");
        System.out.println("1. Start");
        System.out.println("2. Exit");
        System.out.print("> ");
        code = scan.nextInt();

        // For exit
        if (code == 2) {
            System.exit(0);
        }

        // Initialization Player
        Player player = new Player(20, 20, 5, 5, 0, 8, 1);

        // Main game
        while (!gameover) {
            while (!canRest) {
                if (gameover) break;

                System.out.println("\nYou woke up.");
                System.out.println("[Your Action]");
                System.out.println("1. Walk");
                System.out.println("2. Show Stats");
                System.out.print("> ");
                code = scan.nextInt();

                switch (code) {
                    case 1:
                        // Walk
                        gacha = random.nextInt(10);

                        if (gacha > 2) {
                            // Initialization Enemy
                            Enemy enemy;
                            gacha = random.nextInt(3);
                            switch (gacha) {
                                case 0:
                                    gacha = random.nextInt(player.getLevel());
                                    enemy = new Slime(gacha + 1);
                                    break;
                                case 1:
                                    gacha = random.nextInt(player.getLevel());
                                    enemy = new Goblin(gacha + 1);
                                    break;
                                case 2:
                                    gacha = random.nextInt(player.getLevel());
                                    enemy = new Minotaur(gacha + 1);
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + gacha);
                            }

                            System.out.println("\nYou cross paths with " + enemy.getName() + " (enemy).");
                            System.out.println("[Your Action]");
                            System.out.println("1. Fight");
                            System.out.println("2. Run");
                            System.out.print("> ");
                            code = scan.nextInt();

                            switch (code) {
                                case 1:
                                    fight = true;
                                    break;
                                case 2:
                                    gacha = random.nextInt(2);
                                    if (gacha == 1) {
                                        fight = true;
                                        System.out.println("\nYou got caught by the enemy!");
                                    } else {
                                        System.out.println("\nYou escaped.");
                                    }
                                    break;
                            }

                            while (fight) {
                                System.out.println("\n[Player Lv. " + player.getLevel() + "]");
                                System.out.println("HP: " + player.getHealth() + "/" + player.getMaxHealth());
                                System.out.println("[" + enemy.getName() + " Lv. " + enemy.getLevel() + "]");
                                System.out.println("HP: " + enemy.getHealth() + "/" + enemy.getMaxHealth());

                                System.out.println("\n[Your Action]");
                                System.out.println("1. Attack");
                                System.out.println("2. Defend");
                                System.out.println("3. Show Enemy Stats");
                                System.out.println("4. Show Your Stats");
                                System.out.print("> ");
                                code = scan.nextInt();

                                switch (code) {
                                    case 1:
                                        System.out.print("\nYou attack the enemy, ");
                                        gacha = random.nextInt(2);
                                        if (gacha == 1) { // Enemy attacking
                                            // Player turn
                                            enemy.onHit(player.getAttack());
                                            System.out.println("and they lost " + player.getAttack() + " HP.");

                                            // Enemy turn
                                            player.onHit(enemy.getAttack());
                                            System.out.println("Now enemy is attacking, you lost " + enemy.getAttack() + " HP.");
                                        } else { // Enemy defending
                                            int hit = player.getAttack() - enemy.getDefense();

                                            if (hit > 0) {
                                                enemy.onHit(hit);
                                                System.out.println("but enemy is defending, they lost " + hit + " HP.");
                                            } else {
                                                System.out.println("but enemy is defending, they didn't get hurt.");
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.print("\nYou're defending, ");
                                        gacha = random.nextInt(2);
                                        if (gacha == 1) { // Enemy attacking
                                            int hit = enemy.getAttack() - player.getDefense();

                                            if (hit > 0) {
                                                player.onHit(hit);
                                                System.out.println("the enemy is attacking, you lost " + hit + " HP.");
                                            } else {
                                                System.out.println("the enemy is attacking, you didn't get hurt.");
                                            }
                                        } else { // Enemy defending
                                            System.out.println("the enemy is also defending, so no one get hurt.");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("\n[Enemy Stats]");
                                        System.out.println("Health\t: " + enemy.getHealth() + "/" + enemy.getMaxHealth());
                                        System.out.println("Attack\t: " + enemy.getAttack());
                                        System.out.println("Defense\t: " + enemy.getDefense());
                                        System.out.println("Level\t: " + enemy.getLevel());
                                        break;
                                    case 4:
                                        System.out.println("\n[Player Stats]");
                                        System.out.println("Health\t\t: " + player.getHealth() + "/" + player.getMaxHealth());
                                        System.out.println("Attack\t\t: " + player.getAttack());
                                        System.out.println("Defense\t\t: " + player.getDefense());
                                        System.out.println("Experience\t: " + player.getExperience() + "/" + player.getMaxExperience());
                                        System.out.println("Level\t\t: " + player.getLevel());
                                        break;
                                }

                                // Player dead
                                if (player.getHealth() <= 0) {
                                    System.out.println("\nYou died!");
                                    fight = false;
                                    gameover = true;
                                }

                                // Player win fight
                                if (enemy.getHealth() <= 0) {
                                    System.out.println("\nYou win fight!");

                                    int experience = 8 * enemy.getLevel();
                                    player.addExperience(experience);
                                    System.out.println("You get " + experience + " XP.");

                                    while (player.getExperience() >= player.getMaxExperience()) {
                                        System.out.println("\nYou leveled up!");
                                        player.addExperience(player.getMaxExperience() * -1);
                                        player.addMaxExperience(8);
                                        player.addLevel(1);
                                        player.addHealth(20);
                                        player.addMaxHealth(20);

                                        // Get +1 stats
                                        System.out.println("\nYou get +1 stats, please choose:");
                                        System.out.println("1. Attack +1");
                                        System.out.println("2. Defend +1");
                                        System.out.print("> ");
                                        code = scan.nextInt();

                                        // Choose stats to increase +1
                                        switch (code) {
                                            case 1:
                                                player.addAttack(1);
                                                break;
                                            case 2:
                                                player.addDefense(1);
                                                break;
                                        }
                                    }

                                    fight = false;
                                    canRest = true;
                                }
                            }
                        } else {
                            canRest = true;
                            break;
                        }
                        break;
                    case 2:
                        // Show stats
                        System.out.println("\n[Player Stats]");
                        System.out.println("Health\t\t: " + player.getHealth() + "/" + player.getMaxHealth());
                        System.out.println("Attack\t\t: " + player.getAttack());
                        System.out.println("Defense\t\t: " + player.getDefense());
                        System.out.println("Experience\t: " + player.getExperience() + "/" + player.getMaxExperience());
                        System.out.println("Level\t\t: " + player.getLevel());
                        break;
                }
            }

            while (canRest) {
                if (gameover) break;

                System.out.println("\nYou're very tired and you can't keep going for tonight.");
                System.out.println("[Your Action]");
                System.out.println("1. Rest");
                System.out.println("2. Show Stats");
                System.out.print("> ");
                code = scan.nextInt();

                switch (code) {
                    case 1:
                        // Rest
                        System.out.println("\nYou're now resting.");
                        player.setHealth(player.getMaxHealth());
                        canRest = false;
                        break;
                    case 2:
                        // Show stats
                        System.out.println("\n[Player Stats]");
                        System.out.println("Health\t\t: " + player.getHealth() + "/" + player.getMaxHealth());
                        System.out.println("Attack\t\t: " + player.getAttack());
                        System.out.println("Defense\t\t: " + player.getDefense());
                        System.out.println("Experience\t: " + player.getExperience() + "/" + player.getMaxExperience());
                        System.out.println("Level\t\t: " + player.getLevel());
                        break;
                }
            }
        }
    }
}
