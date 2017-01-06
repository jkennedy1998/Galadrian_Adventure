import javax.swing.*;

/**
 * Created by jnebl on 12/22/2016.
 */

public class CharacterCreation {
    public static double attackMultiplier,accuracyMultiplier, defensiveMultiplier, speedMultiplier;

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
        }
        if (choice == 1) {
            role = "Ranger";
            accuracyMultiplier += .3;
        }
        if (choice == 2) {
            role = "Warlock";
            defensiveMultiplier += .3;
        }
        if (choice == 3) {
            role = "Druid";
            defensiveMultiplier += .1;
            attackMultiplier += .1;
            accuracyMultiplier += .1;
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
    public static double getSpeedMultiplier(){return speedMultiplier;
    }

}