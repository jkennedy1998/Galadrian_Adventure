import javax.swing.*;

/**
 * Created by jnebl on 1/6/2017.
 */
public class Leveler {

    public static String[] levelUp(int health, int maxHealth){
        health += 5;
        maxHealth += 5;
        String[] returningLevelStats = {""+health,""+maxHealth,"",""};
        String[] buttons = {"Vitality", "Strength", "Aim", "Speed","Armor efficiency","Forgo practice and patch wounds"};

        int choice = JOptionPane.showOptionDialog(null, "You feel more experienced from past encounters!\n" +
                        "You rest in your adventure to practice skills. \n" +
                        "What skill would you like to practice?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        if (choice ==0){
            returningLevelStats[2] = "max health";
            returningLevelStats[1] = ""+(maxHealth+7);
            System.out.println("\nYou feel considerably more healthy!");
        }
        if (choice ==1){
            returningLevelStats[2] = "damage";
            returningLevelStats[3] = ".3";
            System.out.println("\nTarget dummies fear you!\nYou need to replace them more often due to your increased strength!");
        }
        if (choice ==2){
            returningLevelStats[2] = "accuracy";
            returningLevelStats[3] = ".3";
            System.out.println("\nYou begin to hit more when in target practice!");
        }
        if (choice ==3){
            returningLevelStats[2] = "speed";
            returningLevelStats[3] = ".3";
            System.out.println("\nYou find that you cover more distance when running!");
        }
        if (choice ==4){
            returningLevelStats[2] = "defence";
            returningLevelStats[3] = ".3";
            System.out.println("\nYou find something to improve in your armor!");
        }
        if (choice ==5){
            returningLevelStats[2] = "health";
            if (health+10>maxHealth){
                returningLevelStats[0] = ""+(maxHealth-health);
                System.out.println("\nYou bind the last of your wounds.\nYou Have full health with "+maxHealth+" points.");
            }else {
            returningLevelStats[0] = ""+(health+10);
                System.out.println("You bind your wounds.\nYou Have "+(health+10)+"health points.");
            }
        }

        return returningLevelStats;
    }
}
