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
        Player player = new Player(20, 20, 5, 5, 0, 8, 1);

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
                    gacha = random.nextInt(2);

                    if (gacha == 1) {
                        Enemy enemy = new Goblin("Goblin", 15, 15, 3, 3, 1);
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
                            System.out.println("[Goblin Lv. " + enemy.getLevel() + "]");
                            System.out.println("HP: " + enemy.getHealth() + "/" + enemy.getMaxHealth());
                            System.out.println("\n[Your Action]");
                            System.out.println("1. Attack");
                            System.out.println("2. Defend");
                            System.out.println("3. Show Enemy Stats");
                            System.out.println("3. Show Your Stats");
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

                                    break;
                                case 4:
                                    System.out.println("[Player Stats]");
                                    System.out.println("Health\t\t: " + player.getHealth() + "/" + player.getMaxHealth());
                                    System.out.println("Attack\t\t: " + player.getAttack());
                                    System.out.println("Defense\t\t: " + player.getDefense());
                                    System.out.println("Experience\t: " + player.getExperience());
                                    System.out.println("Level\t\t: " + player.getLevel());

                                    break;
                            }

                            if (player.getHealth() <= 0) {
                                System.out.println("You Dead!");
                                fight = false;
                                gameover = true;
                            }

                            if (enemy.getHealth() <= 0) {
                                System.out.println("You win fight!");

                                int experience = 8 * enemy.getLevel();
                                if (experience >= player.getMaxExperience()) {
                                    System.out.println("You Level Up!");
                                    System.out.println("You get +1 stats, please choice:");
                                    System.out.println("1. Attack +1");
                                    System.out.println("2. Defend +1");
                                    System.out.print(">");
                                    code = scan.nextInt();
                                    System.out.println();

                                    switch (code) {
                                        case 1:
                                            player.addAttack(1);
                                            break;
                                        case 2:
                                            player.addDefense(1);
                                            break;
                                    }
                                }

                                player.addExperience(experience);
                                fight = false;
                            }

                            System.out.println();
                        }

                    } else {
                        System.out.println("You reach the end of the journey.");
                    }

                    break;
                case 2:
                    if ((player.getHealth() + 5) < player.getMaxHealth()) { // Check if healing does not exceed maxHealth
                        player.addHealth(5);
                    } else {
                        player.setHealth(player.getMaxHealth());
                    }

                    System.out.println("You are now resting.");

                    break;
                case 3:
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
