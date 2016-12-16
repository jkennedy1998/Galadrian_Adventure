/**
 * Created by student5 on 9/23/16.
 */

import javax.swing.*;

public class adventurerework {
    public static int health, maxHealth;
    public static int attackMultiplier, accuracyMultiplier, defensiveMultiplier;
    public static int score;
    public static int roundCount = 1;
    public static String attack1 = "Slash";
    public static String attack2 = "Jab";
    public static String attack3 = "Punch";
    public static String attack4 = "";
    public static int itemSlot0 = 0;
    public static int itemSlot1 = 0;
    public static int itemSlot2 = 0;
    public static int itemSlot3 = 0;

    public static void main(String args[]) {
        health = 100;
        maxHealth = 100;
        score = 0;
        accuracyMultiplier = 1;
        attackMultiplier = 1;
        defensiveMultiplier = 1;  //make these do things
        live();
    }

    public static void live() {
        String[] buttons = {"yes", "no"};

        int answer = JOptionPane.showOptionDialog(null, "Would you like to strive on?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        if (answer==0) {
            striveOn();
        } else if (answer==1) {
            System.out.println("you have chosen to stop adventuring.");
            score = health + score;
            System.out.println("your score is " + score);
            System.exit(0);
        } else {
            live();
        }
    }

    public static void death() {
        System.out.println("you have died while adventuring.");
        score = health + score;
        System.out.println("your score is " + score);
        System.exit(0);
    }

    public static void striveOn() {
        System.out.println("you strive on.");
        startEncounter();
        live();
    }
    public static void getItem(int itemValue) {
        Items refreshInventory = new Items();
        refreshInventory.initializeItems(itemSlot0, itemSlot1, itemSlot2, itemSlot3);
        int tempValue = refreshInventory.receiveItem(itemValue);
        String[] itemTemp = refreshInventory.getItemValues(itemValue);
        if (tempValue != 4) {
            if (tempValue == 0) {
                itemSlot0 = itemValue;
                System.out.println(itemTemp[0] + " has been stored in slot 1!");
            }
            if (tempValue == 1) {
                itemSlot1 = itemValue;
                System.out.println(itemTemp[0] + " has been stored in slot 2!");
            }
            if (tempValue == 2) {
                itemSlot2 = itemValue;
                System.out.println(itemTemp[0] + " has been stored in slot 3!");
            }
            if (tempValue == 3) {
                itemSlot3 = itemValue;
                System.out.println(itemTemp[0] + " has been stored in slot 4!");
            }
        } else {
            String[] buttons = {"yes", "no"};
            String prompt = (itemTemp[0] + " has no available storage slot. Would you like to empty another slot for it?");
            int answer = JOptionPane.showOptionDialog(null, prompt, "",
                    JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
            if (answer == 0) {
                String slot1 = ("Slot 1 holding " + refreshInventory.getItemValues(refreshInventory.itemStorage[0])[0]);
                String slot2 = ("Slot 2 holding " + refreshInventory.getItemValues(refreshInventory.itemStorage[1])[0]);
                String slot3 = ("Slot 3 holding " + refreshInventory.getItemValues(refreshInventory.itemStorage[2])[0]);
                String slot4 = ("Slot 4 holding " + refreshInventory.getItemValues(refreshInventory.itemStorage[3])[0]);
                String[] moreButtons = {slot1,slot2,slot3,slot4};

                int otherAnswer = JOptionPane.showOptionDialog(null, "which item would you like to be replaced?", "",
                        JOptionPane.PLAIN_MESSAGE, 1, null, moreButtons, null);
                if (otherAnswer == 0) {
                    itemSlot0 = itemValue;
                    System.out.println(itemTemp[0] + " has been stored in slot 1!");
                }
                if (otherAnswer == 1) {
                    itemSlot1 = itemValue;
                    System.out.println(itemTemp[0] + " has been stored in slot 2!");
                }
                if (otherAnswer == 2) {
                    itemSlot2 = itemValue;
                    System.out.println(itemTemp[0] + " has been stored in slot 3!");
                }
                if (otherAnswer == 3) {
                    itemSlot3 = itemValue;
                    System.out.println(itemTemp[0] + " has been stored in slot 4!");
                }
            } else  {
                System.out.println("you have chosen to discard the item.");

            }
        }
    }


    public static void startEncounter() {
        int beastStats[];
        System.out.println("\n\nyour health is at " + health + ".\nYou are on round " + roundCount + ".");
        beastStats = monsterSelection.main(roundCount);
        Monster monsterRefresh = new Monster(beastStats[0], beastStats[1], beastStats[2], beastStats[3], beastStats[4], beastStats[5]);
        Encounter playerRefresh = new Encounter();
        playerRefresh.initialize(attack1, attack2, attack3, attack4);
        while (monsterRefresh.questionlife()) {
            System.out.println("The beast attacks!");
               String tempMAttack = monsterRefresh.calculateHit();
            if (tempMAttack.equalsIgnoreCase("Miss")){}//does nothing on purpose
            else {
                int tempMAttack2 = Integer.parseInt(tempMAttack);
                health -= tempMAttack2;
                System.out.println("the beast attacks for " + tempMAttack2 + " damage!\nyour current health is at " + (health));
            }
            if (health <= 0) {
                health = 0;
                adventurerework.death();}
            System.out.println("It's your turn to attack!");
            String attackStorage = playerRefresh.PlayerAttack();
            if (!(attackStorage.equalsIgnoreCase("item"))) {
                if (attackStorage.equalsIgnoreCase("Miss")) {
                }//does nothing on purpose
                else {
                    int tempPAttack = Integer.parseInt(attackStorage);
                    monsterRefresh.receiveHit(tempPAttack);
                    System.out.println("Its current health is at " + (monsterRefresh.health));
                }
            }else{
                String[] tempData = playerRefresh.PlayerItem();
                System.out.println("You used the "+tempData[0]);
                if (tempData[1].equalsIgnoreCase("0")){
                    health += Integer.parseInt(tempData[2]);
                    //make attack modifier
                    //make accuracy modifier
                    //make effects toggle on
                    //make effects toggle off
                } else {
                    monsterRefresh.health =+ Integer.parseInt(tempData[2]);
                    //make attack modifier for monster
                    //make accuracy modifier for monster
                    //make effects toggle on for monster
                    //make effects toggle off for monster
                }





            }
        }
        System.out.println("you have defeated the beast!");
        roundCount += 1;
        score += 15;
        if(monsterRefresh.questionItem()!= 0){
            getItem(beastStats[4]);
        }
        if ((health<maxHealth)&&(roundCount%10==0)){
            int tempHealth = (int)(Math.round(Math.random()*20));
            health += tempHealth;
            if (health > maxHealth){
                health = maxHealth;
            }
            System.out.println("\nYou feel your past wounds begin to heal.");
        }
        adventurerework.live();
    }
}


