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
        if (adventurerework.itemSlot0==itemNumber||adventurerework.itemSlot1 ==itemNumber || adventurerework.itemSlot2 == itemNumber|| adventurerework.itemSlot3 == itemNumber|| adventurerework.itemSlot4 ==itemNumber)
            return true;
        return false;
    }
    public static void itemVoid(int itemNumber){
        if (adventurerework.itemSlot0==itemNumber) adventurerework.itemSlot0 = 0;
        else if (adventurerework.itemSlot1 ==itemNumber) adventurerework.itemSlot1 = 0;
        else if ( adventurerework.itemSlot2 == itemNumber) adventurerework.itemSlot2 = 0;
        else if ( adventurerework.itemSlot3 == itemNumber) adventurerework.itemSlot3 = 0;
        else if ( adventurerework.itemSlot4 ==itemNumber) adventurerework.itemSlot4 = 0;
    }

    //area for common quests.
    public static void receiveHealthPotion() {
        System.out.print("You find an unopened health potion in the cold hands of a late adventurer.");
        System.out.println(adventurerework.getItem(1));
    }

    public static void receivePoison() {
        System.out.print("You find an open bottle of poison in the cold hands of a late adventurer.");
        System.out.println(adventurerework.getItem(2));
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
                int piece = (int)Math.ceil(Math.random()*4+10); //any forgotten armor peice
                System.out.println("You have broken your spade but have looted a " + ItemDirectory.findItemValues(piece) + "off of the forgotten\nA rush of guilt falls over you.");
            }
        }else{
            System.out.println("You come across a makeshift grave.\nIt reads: May Mortum grant you the armor you word for Vivus\nYou strive on.");
        }

        //area for rare quests.

    }

}
