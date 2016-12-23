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
    public static String tempBeastName = "";
    public static String tempUserString = "";

    public static void main(String args[]) {
        health = 100;
        maxHealth = 100;
        score = 0;
        accuracyMultiplier = 1;
        attackMultiplier = 1;
        defensiveMultiplier = 1;  //make this do things
        CharacterCreation character = new CharacterCreation();
        character.race();
        character.role();
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
    public static String getItem(int itemValue) {
        Items refreshInventory = new Items();
        refreshInventory.initializeItems(itemSlot0, itemSlot1, itemSlot2, itemSlot3);
        int tempValue = refreshInventory.receiveItem(itemValue);
        String[] itemTemp = refreshInventory.getItemValues(itemValue);
        if (tempValue != 4) {
            if (tempValue == 0) {
                itemSlot0 = itemValue;
                return (itemTemp[0] + " has been stored in slot 1!");
            }
            if (tempValue == 1) {
                itemSlot1 = itemValue;
                return (itemTemp[0] + " has been stored in slot 2!");
            }
            if (tempValue == 2) {
                itemSlot2 = itemValue;
                return (itemTemp[0] + " has been stored in slot 3!");
            }
            if (tempValue == 3) {
                itemSlot3 = itemValue;
                return (itemTemp[0] + " has been stored in slot 4!");
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
                return ("you have chosen to discard the item.");

            }
        }
        return "OH SHIT THIS SHOULDN'T RETURN";
    }


    public static void startEncounter() {

        int beastStats[];
        JOptionPane.showMessageDialog(null,"your health is at " + health + ".\nYou are on round " + roundCount + ".");

        beastStats = monsterSelection.main(roundCount);
        Monster monsterRefresh = new Monster(beastStats[0], beastStats[1], beastStats[2], beastStats[3], beastStats[4], beastStats[5]);
        Encounter playerRefresh = new Encounter();
        playerRefresh.initialize(attack1, attack2, attack3, attack4);
        while (monsterRefresh.questionlife()) {
            String tempDialog = "";
            tempDialog += ("The beast attacks!\n");
               String tempMAttack = monsterRefresh.calculateHit();
            if (tempMAttack.equalsIgnoreCase("The beast has missed!")){
                tempDialog += ("The beast has missed!\n");
            }
            else {
                int tempMAttack2 = Integer.parseInt(tempMAttack);
                health -= tempMAttack2;
                tempDialog += ("the beast attacks for " + tempMAttack2 + " damage!\nYour current health is at " + (health)+"\n");
            }
            if (health <= 0) {
                health = 0;
                adventurerework.death();}
            tempDialog += ("It's your turn to attack!\n");
            String attackStorage = playerRefresh.PlayerAttack(tempDialog);
            if (!(attackStorage.equalsIgnoreCase("item"))) {
                if (attackStorage.equalsIgnoreCase("Miss")) {
                }//does nothing on purpose
                else {
                    int tempPAttack = Integer.parseInt(attackStorage);
                    monsterRefresh.receiveHit(tempPAttack);
                    tempUserString += ("Its current health is at " + (monsterRefresh.health)+"\n");
                    JOptionPane.showMessageDialog(null,tempUserString);
                    tempUserString = "";
                }
            }else{
                boolean questionHit = true;
                String[] tempData = playerRefresh.PlayerItem();
                JOptionPane.showMessageDialog(null,"You used the "+tempData[0]);
                if (Math.round(Integer.parseInt(tempData[5])) >= Math.round(Math.random() * 10)){
                    questionHit = true;
                    if (tempData[1].equalsIgnoreCase("0")){
                        health += Integer.parseInt(tempData[2]);
                        playerRefresh.damageMult = Double.parseDouble(tempData[3]);
                        playerRefresh.accuracyMult = Double.parseDouble(tempData[4]);
                        //make effects toggle on (make effects in the first place. ie: burning, frozen, wet)
                        //make effects toggle off

                    } else {
                        monsterRefresh.health =+ Integer.parseInt(tempData[2]);
                        monsterRefresh.damageMult = Double.parseDouble(tempData[3]);
                        monsterRefresh.accuracyMult = Double.parseDouble(tempData[4]);
                        //make effects toggle on for monster
                        //make effects toggle off for monster
                    }
                }else{ questionHit = false;}
                String tempOutput = "";
                if (Integer.parseInt(tempData[1]) == 0) tempOutput += "You use the "+tempData[0]+" on yourself\n";
                else tempOutput += "You use the "+tempData[0]+" on "+ monsterRefresh.name+".\n";
                if (questionHit) {
                if (Integer.parseInt(tempData[2]) == 0) tempOutput += "";
                else tempOutput += "This causes "+tempData[1]+" points of damage.\n";
                if (Integer.parseInt(tempData[3]) == 0) tempOutput += "";
                else if (Integer.parseInt(tempData[3]) > 0) tempOutput += "The "+tempData[0]+" seems to make the receiving end stronger!\n";
                else tempOutput += "The "+tempData[0]+" weakens the receiving end!\n";
                if (Integer.parseInt(tempData[4]) == 0) tempOutput += "";
                else if (Integer.parseInt(tempData[4]) < 0) tempOutput += "The "+tempData[0]+" discombobulates the receiving end!\n";
                else tempOutput += "The " + tempData[0] + " focuses the receiving end!\n";

            }else {
            tempOutput += "It fails.\n";}
                JOptionPane.showMessageDialog(null,tempOutput);
            }
        }
        String endEncounterDialog = "";
        endEncounterDialog += ("you have defeated the beast!");
        roundCount += 1;
        score += 15;
        if(monsterRefresh.questionItem()!= 0){
            endEncounterDialog += getItem(beastStats[4]);
            JOptionPane.showMessageDialog(null,endEncounterDialog);
        }
        if ((health<maxHealth)&&(roundCount%5==0)){
            int tempHealth = (int)(Math.round(Math.random()*20));
            health += tempHealth;
            if (health > maxHealth){
                health = maxHealth;
            }
            JOptionPane.showMessageDialog(null,"You feel your past wounds begin to heal.\nYou regain "+tempHealth+" health.");
        }
        adventurerework.live();
    }
}
//random comment to see if this commit and push works

