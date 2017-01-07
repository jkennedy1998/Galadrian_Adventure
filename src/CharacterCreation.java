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


    public static String race() {
        String[] buttons = {"Human", "Orc", "Dwarf", "Wood Elf", "Giant"};

        int choice = JOptionPane.showOptionDialog(null, "Which race would you like to play as?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        String race = "";
        if (choice == 0) {
            race = "Human";
        }
        if (choice == 1) {
            race = "Orc";
            attackMultiplier -= .2;
            accuracyMultiplier+= .2;
            speedMultiplier += .2;
            defensiveMultiplier += .05;

        }
        if (choice == 2) {
            race = "Dwarf";
            attackMultiplier += .1;
            defensiveMultiplier += .2;
            accuracyMultiplier-= .3;
            speedMultiplier-=.05;
        }
        if (choice == 3) {
            race = "Wood Elf";
            attackMultiplier -= .1;
            accuracyMultiplier +=.1;
            speedMultiplier +=.25;
            defensiveMultiplier += .05;

        }
        if (choice == 4) {
            race = "Giant";
            attackMultiplier += .3;
            defensiveMultiplier += .05;
            accuracyMultiplier -=.2;
            speedMultiplier -=.1;
        }

        return race;
    }

    public static String role() {
        String[] buttons = {"Warrior", "Ranger", "Warlock", "Druid", "Witcher"};

        int choice = JOptionPane.showOptionDialog(null, "Which type of Savior would you like to play as?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        String role = "";
        if (choice == 0) {
            role = "Warrior";
            attackMultiplier += .2;
            defensiveMultiplier += .2;
            accuracyMultiplier += .2;
            attack1 = "Slash";
            attack2 = "One-Ton Punch";
            attack3 = "Shield Batter";
            attack4 = "";
        }
        if (choice == 1) {
            role = "Ranger";
            accuracyMultiplier += .4;
            attackMultiplier += .05;
            defensiveMultiplier += .05;
            attack1 = "Perfect Shot";
            attack2 = "QuadShot";
            attack3 = "Hidden Shank";
            attack4 = "";
        }
        if (choice == 2) {
            role = "Warlock";
            defensiveMultiplier += .1;
            attackMultiplier += .3;
            accuracyMultiplier += .1;
            attack1 = "Hex";
            attack2 = "Dark Ones Blessing";
            attack3 = "Pyro Assault";
            attack4 = "";
        }
        if (choice == 3) {
            role = "Druid";
            defensiveMultiplier += .2;
            attackMultiplier += .1;
            accuracyMultiplier += .3;
            attack1 = "SunSpot";
            attack2 = "MoonBeam";
            attack3 = "ThunderWave";
            attack4 = "";
        }
        if (choice == 4) {
            role = "Witcher";
            defensiveMultiplier += .3;
            attackMultiplier += .2;
            accuracyMultiplier += .1;
            attack1 = "Pure Rend";
            attack2 = "Toxic Pierce";
            attack3 = "Explosive Pellets";
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