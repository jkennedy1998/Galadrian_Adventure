package Battle;

import javax.swing.*;

/**
 * Created by jnebl on 1/6/2017.
 */
public class Leveler {

    public static String[] levelUp(int health, int maxHealth) {
        health += 5;
        maxHealth += 5;
        adventurerework.window.print("You feel more experienced from past encounters!");
        adventurerework.window.print("You rest in your adventure to practice skills.");
        adventurerework.window.print("What skill would you like to practice?");
        String[] returningLevelStats = {"" + health, "" + maxHealth, "", ""};
        String[] buttons = {"Vitality", "Strength", "Aim", "Speed", "Armor efficiency", "Forgo practice and patch wounds"};
        adventurerework.window.makeButtons(buttons);
        adventurerework.window.drawButtons();
        int choice = -1;
        while(choice == -1){
            System.out.print("");
            choice = adventurerework.window.questionButtonClick();
        }
        adventurerework.window.voidButtons();

//        int choice = JOptionPane.showOptionDialog(null, "You feel more experienced from past encounters!\n" +
//                        "You rest in your adventure to practice skills. \n" +
//                        "What skill would you like to practice?", "",
//                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        if (choice == 0) {
            returningLevelStats[2] = "max health";
            returningLevelStats[1] = "" + (maxHealth + 5);
            adventurerework.window.print("\nYou feel considerably more healthy!");
        }
        if (choice == 1) {
            returningLevelStats[2] = "damage";
            returningLevelStats[3] = ".1";
            adventurerework.window.print("\nTarget dummies fear you!\nYou need to replace them more often due to your increased strength!");
        }
        if (choice == 2) {
            returningLevelStats[2] = "accuracy";
            returningLevelStats[3] = ".1";
            adventurerework.window.print("\nYou begin to hit more when in target practice!");
        }
        if (choice == 3) {
            returningLevelStats[2] = "speed";
            returningLevelStats[3] = ".1";
            adventurerework.window.print("\nYou find that you cover more distance when running!");
        }
        if (choice == 4) {
            returningLevelStats[2] = "defence";
            returningLevelStats[3] = ".1";
            adventurerework.window.print("\nYou find something to improve in your armor!");
        }
        if (choice == 5) {
            returningLevelStats[2] = "health";
            if (health + 10 > maxHealth) {
                returningLevelStats[0] = "" + (maxHealth - health);
                adventurerework.window.print("\nYou bind the last of your wounds.\nYou Have full health with " + maxHealth + " points.");
            } else {
                returningLevelStats[0] = "" + (health + 10);
                adventurerework.window.print("You bind your wounds.\nYou Have " + (health + 10) + " health points.");
            }
        }
        adventurerework.inventory.refreshCapacity();
        return returningLevelStats;
    }

    public static int calculateRestingHealth(double time){
        double awakeTime = Math.random()*4+6; //waking up somewhere between 6 and 10;
        adventurerework.time = awakeTime;
        if (time>12){//if a day has not passed in the time between your last sleep
            return (int)(24-time+awakeTime)*4;
        }else{
            return (int)(awakeTime-time)*4;
        }
    }
}