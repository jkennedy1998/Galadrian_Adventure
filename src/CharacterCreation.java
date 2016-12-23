import javax.swing.*;

/**
 * Created by jnebl on 12/22/2016.
 */
public class CharacterCreation {

    public static int attackMultiplier, accuracyMultiplier, defensiveMultiplier;
    public static String race() {
        String[] buttons = {"Human", "Elf", "Dwarf"};

        int choice = JOptionPane.showOptionDialog(null, "Which race would you like to play as?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        String race = "";
        if (choice == 0){
            race = "Human";
        }
        if (choice == 1){
            race = "Elf";
        }
        if (choice == 2) {
            race = "Dwarf";
        }

        return race;
    }
    public static String role()
    {
        String[] buttons = {"Warrior", "Ranger", "Warlock"};

        int choice = JOptionPane.showOptionDialog(null, "Which race would you like to play as?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        String role = "";
        if (choice == 0){
            role = "Warrior";
        }
        if (choice == 1){
            role = "Ranger";
        }
        if (choice == 2){
            role = "Warlock";
        }
        return role;
        }

    }

