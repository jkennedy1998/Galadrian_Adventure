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
        String[] buttons = {"Warrior", "Ranger", "Warlock", "Druid"};

        int choice = JOptionPane.showOptionDialog(null, "Which race would you like to play as?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        String role = "";
        if (choice == 0) {
            role = "Warrior";
            attackMultiplier += .3;
            attack1 = "Slash";
            attack2 = "Punch";
            attack3 = "Jab";
            attack4 = "";
        }
        if (choice == 1) {
            role = "Ranger";
            accuracyMultiplier += .3;
            attack1 = "Shoot";
            attack2 = "Surprise Shot";
            attack3 = "Stab";
            attack4 = "";
        }
        if (choice == 2) {
            role = "Warlock";
            defensiveMultiplier += .3;
            attack1 = "Hex";
            attack2 = "Dark Ones Blessing";
            attack3 = "Thirsting Blade";
            attack4 = "";
        }
        if (choice == 3) {
            role = "Druid";
            defensiveMultiplier += .1;
            attackMultiplier += .1;
            accuracyMultiplier += .1;
            attack1 = "Shapechange";
            attack2 = "MoonBeam";
            attack3 = "Thunderwave";
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
        return  attack1;
    }
    public static String getAttack2(){
        return attack2;
    }
    public static String getAttack3(){
        return attack3;
    }
    public static String getAttack4(){
        return attack4;
    }
}