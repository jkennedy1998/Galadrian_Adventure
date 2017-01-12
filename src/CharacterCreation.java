import javax.swing.*;

/**
 * Created by jnebl on 12/22/2016.
 */

public class CharacterCreation {
    public static double accuracyMultiplier = 1;
    public static double attackMultiplier = 1;
    public static double defensiveMultiplier = 1;
    public static double speedMultiplier = 1;
    public static String attack1 = "";
    public static String attack2 = "";
    public static String attack3 = "";
    public static String attack4 = "";
//    private int health, maxHealth, speed, level, score, exp, expLim;
//    private double attackMultiplier, accuracyMultiplier, defensiveMultiplier, speedMultiplier;
//    private double attackMultiplierLocked, accuracyMultiplierLocked, defensiveMultiplierLocked, speedMultiplierLocked;
//    public CharacterCreation(){
//        health = 100;
//        maxHealth = 100;
//        speed = 60;
//        level = 0;
//        score = 100;
//        exp = 0;
//        expLim = 5;
//        attackMultiplier = 1;
//        accuracyMultiplier = 1;
//        defensiveMultiplier = 1;
//        speedMultiplier = 1;
//    }

    public static String race() {
        String[] buttons = {"Human", "Orc", "Dwarf", "Elf", "Halfling"};

        int choice = JOptionPane.showOptionDialog(null, "Which race would you like to play as?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        String race = "";
        if (choice == 0) {//generic human. stats based on human
            race = "Human";
        }
        if (choice == 1) {//strong but brute-like
            race = "Orc";
            attackMultiplier += .2;
            accuracyMultiplier -= .1;
            speedMultiplier += 0;
            defensiveMultiplier += .05;

        }
        if (choice == 2) {//hardy and good with armor, clumsy.
            race = "Dwarf";
            attackMultiplier += .1;
            defensiveMultiplier += .3;
            accuracyMultiplier-= .2;
            speedMultiplier-=.1;
        }
        if (choice == 3) {//your friendly neighborhood stealth archer
            race = "Elf";
            attackMultiplier -= .2;
            accuracyMultiplier +=.3;
            speedMultiplier +=.25;
            defensiveMultiplier -= 0;

        }
        if (choice == 4) {//a breed between an elf an a human
            race = "Halfling";
            attackMultiplier -= .1;
            defensiveMultiplier -= .1;
            accuracyMultiplier +=.15;
            speedMultiplier +=.1;
        }

        return race;
    }

    public static String role() {//should change stats by plus two to three to keep balance
        String[] buttons = {"Swordsman", "Ranger", "Mage", "Barbarian", "Monk"};

        int choice = JOptionPane.showOptionDialog(null, "Which type of Savior would you like to play as?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        String role = "";
        if (choice == 0) {
            role = "Warrior"; //blade and physical attacks
            attackMultiplier += .2;
            defensiveMultiplier += .1;
            accuracyMultiplier += 0;
            attack1 = "Slash";
            attack2 = "Stab";
            attack3 = "Shield Bash";
            attack4 = "";
        }
        if (choice == 1) {
            role = "Ranger"; //ranged attacks and weaker physical attacks
            accuracyMultiplier += .3;
            attackMultiplier += .1;
            defensiveMultiplier -= .1;
            attack1 = "Bow Shot";
            attack2 = "Marksman's Shot";
            attack3 = "Stab";
            attack4 = "";
        }
        if (choice == 2) {
            role = "Mage"; //magic and some weaker physical attacks
            defensiveMultiplier += .1;
            attackMultiplier += .3;
            accuracyMultiplier += .1;
            attack1 = "Hex";
            attack2 = "Shadow Bolt";
            attack3 = "Sparks";
            attack4 = "";
        }
        if (choice == 3) {
            role = "Barbarian"; //brute force!
            defensiveMultiplier -= .1;
            attackMultiplier += .4;
            accuracyMultiplier -= .1;
            attack1 = "Punch";
            attack2 = "Body Slam";
            attack3 = "Club";
            attack4 = "";
        }
        if (choice == 4) {
            role = "Monk"; //self healing and attacking people with physical attacks
            defensiveMultiplier -= .2;
            attackMultiplier += .2;
            accuracyMultiplier += .3;
            attack1 = "Meditation";
            attack2 = "Punch";
            attack3 = "Uppercut";
            attack4 = "";
        }
        return role;
    }

    public static double getAccuracyMultiplier() {
        return accuracyMultiplier;
    }
    public static double getAttackMultiplier(){
        return attackMultiplier;
    }
    public static double getDefensiveMultiplier(){
        return defensiveMultiplier;
    }
    public static double getSpeedMultiplier(){
        return speedMultiplier;
    }
    public static String getAttack1(){
        return attack1;
    }
    public static String getAttack2(){
        return attack2;
    }
    public static String getAttack3(){
        return attack3;
    }
    public static String getAttack4() { return attack4; }
}