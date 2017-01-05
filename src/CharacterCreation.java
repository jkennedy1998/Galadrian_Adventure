import javax.swing.*;

/**
 * Created by jnebl on 12/22/2016.
 */

public class CharacterCreation {
    public static int attackMultiplier, accuracyMultiplier, defensiveMultiplier;
    public static String race() {
        String[] buttons = {"Human", "High Elf", "Dwarf","Wood Elf","Dark Elf"};

        int choice = JOptionPane.showOptionDialog(null, "Which race would you like to play as?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        String race = "";
        if (choice == 0){
            race = "Human";
        }
        if (choice == 1){
            race = "High Elf";
            attackMultiplier-=.2;
            accuracyMultiplier+=.2;

        }
        if (choice == 2) {
            race = "Dwarf";
            attackMultiplier+=.1;
            defensiveMultiplier+=.2;
            accuracyMultiplier-=.3;
        }
        if (choice == 3) {
            race = "Wood Elf";
            accuracyMultiplier+=.1;
            attackMultiplier-=.1;
        }
        if (choice == 4) {
                race = "Dark Elf";
            attackMultiplier+=.1;
            accuracyMultiplier+=.1;
            defensiveMultiplier-=.2;
        }

        return race;
    }
    public static String role()
    {
        String[] buttons = {"Warrior", "Ranger", "Warlock","Druid"};

        int choice = JOptionPane.showOptionDialog(null, "Which race would you like to play as?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        String role = "";
        if (choice == 0){
            role = "Warrior";
            attackMultiplier+=.3;
        }
        if (choice == 1){
            role = "Ranger";
            accuracyMultiplier+=.3;
        }
        if (choice == 2){
            role = "Warlock";
            defensiveMultiplier+=.3;
        }
        if (choice == 3){
            role = "Drud";
            defensiveMultiplier+=.1;
            accuracyMultiplier+=.1;
            attackMultiplier+=.1;
        }
        return role;
        }

    }

