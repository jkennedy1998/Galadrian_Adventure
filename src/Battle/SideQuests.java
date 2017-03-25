package Battle;

import javax.swing.*;

/**
 * Created by citim on 1/19/2017.
 */
public class SideQuests {
    //attack = strength
    //accuracy = perception
    //defence = lore
    //speed = endurance
    // level = intelegence (might change to add an intelegence level. would correlate to magic dam)

    //how to name your methods!
    //receiveBLANK : getting an item
    //trialBLANK : test certain skills or the player through buttons in order to get the item requested
    //questBLANK : a dialog based quest to get an item or something in return.

    //Blank should be the item that will be gotten
    //if you are giving armor to the player and want to give a peice of a set, list it as BLANK armor and give one peice out of that set.

    public static void selectSidequest() {
        int questType = 0; //0 is common, 1 is uncommon, 2 is rare
        {
            double temp = Math.random() * 100;
            if (temp > 90) questType = 2;
            else if (temp > 70) questType = 1;
            else questType = 0;
        }

        if (questType == 0) {//common
            int commonCount = 2;
            int temp = (int) Math.ceil(Math.random() * commonCount);
            if (temp == 1) receiveHealthPotion();
            if (temp == 2) receivePoison();
        }

        if (questType == 1) {//uncommon
            int commonCount = 1;
            int temp = (int) Math.ceil(Math.random() * commonCount);
            if (temp == 1) trialForgottenArmor();

        }

        if (questType == 2) {//rare
            int commonCount = 0;
            int temp = (int) Math.ceil(Math.random() * commonCount);

        }
    }
    public static boolean itemCheck(int itemNumber){
        if (adventurerework.inventory.itemStorage[0]==itemNumber
                || adventurerework.inventory.itemStorage[1] ==itemNumber
                || adventurerework.inventory.itemStorage[2] == itemNumber
                || adventurerework.inventory.itemStorage[3] == itemNumber
                || adventurerework.inventory.itemStorage[4] ==itemNumber)
            return true;
        return false;
    }
    public static void itemVoid(int itemNumber){
        if (adventurerework.inventory.itemStorage[0]==itemNumber) adventurerework.inventory.itemStorage[0] = 0;
        else if (adventurerework.inventory.itemStorage[1] ==itemNumber) adventurerework.inventory.itemStorage[1] = 0;
        else if ( adventurerework.inventory.itemStorage[2] == itemNumber) adventurerework.inventory.itemStorage[2] = 0;
        else if ( adventurerework.inventory.itemStorage[3] == itemNumber) adventurerework.inventory.itemStorage[3] = 0;
        else if ( adventurerework.inventory.itemStorage[4] ==itemNumber) adventurerework.inventory.itemStorage[4] = 0;
    }

    //area for common quests.
    public static void receiveHealthPotion() {
        System.out.println("You find an unopened health potion in the cold hands of a late adventurer.");
        System.out.println(adventurerework.inventory.getItem(1));
    }

    public static void receivePoison() {
        System.out.println("You find an open bottle of poison in the cold hands of a late adventurer.");
        System.out.println(adventurerework.inventory.getItem(2));
    }

    //area for uncommon quests.
    public static void trialForgottenArmor() {
        if (itemCheck(10)) {
            String[] buttons = {"pay respects to the marker and move on.", "defile Mortum and dig up the dead."};
            int answer = JOptionPane.showOptionDialog(null, "You come across a makeshift grave.\nIt reads: May Mortum grant you the armor you word for Vivus", "",
                    JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
            if (answer == 0) {
                System.out.print("You feel a need to strive on.");
                adventurerework.speedMultiplierLocked += .08;
            } else {
                itemVoid(10);
                int piece = (int) Math.ceil(Math.random() * 4 + 10); //any forgotten armor peice
                System.out.println("You have broken your spade but have looted a " + ItemDirectory.findItemValues(piece)[0] + "off of the forgotten\nA rush of guilt falls over you.");
                adventurerework.inventory.getItem(piece);
            }
        } else {
            System.out.println("You come across a makeshift grave.\nIt reads: May Mortum grant you the armor you word for Vivus");
        }
    }

        public static void buyMortumusAumulet(){
        if(adventurerework.coins>100){

        }else{
            System.out.println("You come across a deranged traveler offering some shard of slate for 100 coins.\nYour pockets are too empty and you choose to strive on, saving what you have. ");
        }

    }



    //area for rare quests.

    //area for specific quests. (like bosses!)
    public static boolean merrshaulkRitual(){ //true summons merrshaulk correctly, false distrupts summoning and ruins the process leaving merrshaulk a mass of flesh.
        System.out.println("\nYou fight your way past the royal guards and see a dim magenta light down the hallway." +
                "\nWalking closer you hear the screech in between anguish and rage." +
                "\nAs you round the corner a summoning ritual is brought into sight." +
                "\nThe ritual is almost complete");
        if (itemCheck(15)){
            String[] buttons = {"Throw Mortum's aumulet at the mass of throbbing flesh!", "Stand aside and watch the ritual"};
            int answer = JOptionPane.showOptionDialog(null, "You feel something in your pocket thrust towards the ritual.\nAs you reach in your pocket to grab the item you have flashes of the horrors to come if the ritual succeeds.\nIt appears to be Mortum's amulet!", "",
                    JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
            if (answer == 0) {
                System.out.println("The amulet lands in the center of the throbbing flesh.\n You feel an immersive amount of heat and the next thing you know you are on the ground.\nAs you get up you notice the passed Yuan-ti around the abomination.\nYou feel paralyzed as it squelches slowly to you.");
                return false;

            }else{
                System.out.println("May Preiseir bless you");
                return true;
            }

        }else System.out.println("May Preiseir bless you");
        return true;
    }

}
