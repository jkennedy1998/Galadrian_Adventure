import javax.swing.*;

public class adventurerework {
    public static int health, maxHealth;
    public static int speed = 60;
    public static int level = 0;
    public static double attackMultiplier, accuracyMultiplier, defensiveMultiplier, speedMultiplier;
    public static double attackMultiplierLocked, accuracyMultiplierLocked, defensiveMultiplierLocked, speedMultiplierLocked;
    public static int score;
    public static int roundCount = 1;
    public static int exp = 0;
    public static int expLim = 5;
    public static String attack1 = "";
    public static String attack2 = "";
    public static String attack3 = "";
    public static String attack4 = "";
    public static int itemSlot0 = 0;
    public static int itemSlot1 = 0;
    public static int itemSlot2 = 0;
    public static int itemSlot3 = 0;
    public static int itemSlot4 = 0;
    public static String tempBeastName = "";
    public static String tempUserString = "";

    public static void main(String args[]) {
        health = 100;
        maxHealth = 100;
        score = 0;
        accuracyMultiplier = 1;
        attackMultiplier = 1;
        defensiveMultiplier = 1;
        speedMultiplier = 1;
        System.out.println("You're decision to enter this retched dungeon is valiant, but foolish.\n");
        CharacterCreation character = new CharacterCreation();
        CharacterCreation.race();
        CharacterCreation.role();
        accuracyMultiplierLocked += character.getAccuracyMultiplier();
        attackMultiplierLocked += character.getAttackMultiplier();
        defensiveMultiplierLocked += character.getDefensiveMultiplier();
        speedMultiplierLocked += character.getSpeedMultiplier();
        speed =  (int)Math.round(speed*speedMultiplierLocked);
        attack1 = character.getAttack1();
        attack2 = character.getAttack2();
        attack3 = character.getAttack3();
        attack4 = character.getAttack4();
        live();
    }

    public static void live() {
        if (exp >= expLim){
            levelUp();
        }
        String[] buttons = {"Yes", "I REFUSE"};
        int answer = JOptionPane.showOptionDialog(null, "Would you like to strive on?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        if (answer==0) {
            striveOn();
        } else if (answer==1) {
            System.out.println("You have chosen to stop adventuring.\nI knew you were a Coward!");
            score = health + score;
            System.out.println("Your score is " + score);
            System.exit(0);
        } else  {
            live();
        }

    }

    public static void death() {
        System.out.println("You have died while adventuring!\nHuh, quite the savior you are.");
        score = health + score;
        System.out.println("Your score is " + score);
        if (score>=200)
        {
            // lets add an easter egg here!
        }
        if(health<= 0) {
            System.exit(0);
        }
    }

    public static void striveOn() {
        System.out.println("You strive on.");
        startEncounter();
        live();
    }
    public static String getItem(int itemValue) {
        Items refreshInventory = new Items();
        refreshInventory.initializeItems(itemSlot0, itemSlot1, itemSlot2, itemSlot3, itemSlot4);
        int tempValue = refreshInventory.receiveItem(itemValue);
        String[] itemTemp = refreshInventory.getItemValues(itemValue);
        if (tempValue != 5) {
            if (tempValue == 0) {
                itemSlot0 = itemValue;
                return ("\n"+itemTemp[0] + " has been stored in slot 1!");
            }
            if (tempValue == 1) {
                itemSlot1 = itemValue;
                return ("\n"+itemTemp[0] + " has been stored in slot 2!");
            }
            if (tempValue == 2) {
                itemSlot2 = itemValue;
                return ("\n"+itemTemp[0] + " has been stored in slot 3!");
            }
            if (tempValue == 3) {
                itemSlot3 = itemValue;
                return ("\n"+itemTemp[0] + " has been stored in slot 4!");
            }
            if(tempValue == 4) {
                itemSlot4 = itemValue;
                return ("\n"+itemTemp[0] + " has been stored in slot 5!");
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
                String slot5 = ("Slot 5 holding " + refreshInventory.getItemValues(refreshInventory.itemStorage[4])[0]);

                String[] moreButtons = {slot1,slot2,slot3,slot4,slot5};

                int otherAnswer = JOptionPane.showOptionDialog(null, "Which item would you like to be replaced?", "",
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
                if(otherAnswer == 4) {
                    itemSlot4 = itemValue;
                    System.out.println(itemTemp[0]+ " has been stored in slot 5!");
                }
            } else  {
                return ("You have chosen to discard the item.");

            }
        }
        return "RETURN FOR THE SAKE OF HAVING TO RETURN A STRING.";
    }

    public static void startEncounter(){
        accuracyMultiplier = accuracyMultiplierLocked;
        attackMultiplier = attackMultiplierLocked;
        defensiveMultiplier = defensiveMultiplierLocked;
        speedMultiplier = speedMultiplierLocked;
        int beastStats[], beastStatsSolid[];
        beastStatsSolid = monsterSelection.main(roundCount);
        beastStats = beastStatsSolid;
        boolean lifeStatus = true;
        do {
            if (speed*speedMultiplier >= beastStats[6]) {
                String[] tempData = playerTurn();
                if (tempData==null){}
                else if (tempData[0].equalsIgnoreCase("A")){
                    beastStats[0]-=Integer.parseInt(tempData[1]);
                }else{ //if tempData[0] == "I" (for clarification)
                    beastStats[0]+=Integer.parseInt(tempData[0]);
                    beastStats[1]+=Integer.parseInt(tempData[1]);
                    beastStats[1]+=Integer.parseInt(tempData[2]); //if you edit this data edit that one too! (see below)
                    beastStats[2]+=Integer.parseInt(tempData[3]);
                }
                System.out.println("Its current health is at " + (beastStats[0]));
                if (beastStats[0]>0){ monsterTurn(beastStats,lifeStatus);}
            } else {
                monsterTurn(beastStats,lifeStatus);
                String[] tempData = playerTurn();
                if (tempData==null){}
                else if (tempData[0].equalsIgnoreCase("A")){
                    beastStats[0]-=Integer.parseInt(tempData[1]);
                }else{ //if tempData[0] == "I" (for clarification)
                    beastStats[0]+=Integer.parseInt(tempData[0]);
                    beastStats[1]+=Integer.parseInt(tempData[1]);
                    beastStats[1]+=Integer.parseInt(tempData[2]); //if you edit this data edit that one too! (see above)
                    beastStats[2]+=Integer.parseInt(tempData[3]);
                }
                System.out.println("Its current health is at " + (beastStats[0]));
            }
        }while (health>0&&beastStats[0]>0);

        roundCount += 1;
        score += 15;
        exp += 5;
        System.out.println("your health is at " + health + ".\nYou are on round " + roundCount + ".");
        String endEncounterDialog = "";
        endEncounterDialog += ("You have vanquished the beast!");
        lifeStatus = false;
        if(monsterTurn(beastStats,lifeStatus)==1){
            endEncounterDialog += getItem(beastStats[4]);
            System.out.println(endEncounterDialog);
        }
        if ((health<maxHealth)&&(roundCount%5==0)){
            int tempHealth = (int)(Math.round(Math.random()*20));
            health += tempHealth;
            if (health > maxHealth){
                health = maxHealth;
            }
            System.out.println("You feel your past wounds begin to heal.\nYou regain "+tempHealth+" health.");
        }
        adventurerework.live();
    }


    public static int monsterTurn(int[] beastStats, boolean lifeStatus){


        Monster monsterRefresh = new Monster(beastStats[0], beastStats[1], beastStats[2], beastStats[3], beastStats[4], beastStats[5], beastStats[6]);
        if ( lifeStatus== true) {
            System.out.println("The beast attacks!");
            String tempMAttack = monsterRefresh.calculateHit();
            if (tempMAttack.equalsIgnoreCase("The beast has missed!")) {
                System.out.println("The beast has missed!");
            } else {
                int tempMAttack2 = Integer.parseInt(tempMAttack);
                health -= tempMAttack2;
                System.out.println("The beast attacks for " + tempMAttack2 + " damage!\nYour current health is at " + (health) + "");
            }
            if (health <= 0) {
                health = 0;
                adventurerework.death();

            }
        }else return monsterRefresh.questionItem();
        return 5318008; //returns but does nothing. such savagery
    }

    public static String[] playerTurn(){
        String[] returningString = {"","","",""};

        String tempDialog = "";
        Encounter playerRefresh = new Encounter();
        playerRefresh.initialize(attack1, attack2, attack3, attack4, attackMultiplier, accuracyMultiplier);
        System.out.println("It's your turn to attack!\n");
            String attackStorage = playerRefresh.PlayerAttack(tempDialog,accuracyMultiplier);
            if (!(attackStorage.equalsIgnoreCase("item"))) { //not using item
                if (attackStorage.equalsIgnoreCase("Miss")) {
                }//does nothing on purpose
                else {
                    int tempPAttack = Integer.parseInt(attackStorage);
                    System.out.println("You attack for " + tempPAttack + " damage!");
                    returningString[0] = "A";
                    returningString[1] = ""+tempPAttack;
                    return returningString;
                }
            }else{                                            //using item (start)
                boolean questionHit = true;
                String[] tempData = playerRefresh.PlayerItem();
                System.out.println("You used the "+tempData[0]);
                if (Math.round(Integer.parseInt(tempData[5])) >= Math.round(Math.random() * 10)){
                    questionHit = true;

                } else {
                    questionHit = false;
                }

                //prints regardless (below)
                String tempOutput = "";
                if (Integer.parseInt(tempData[1]) == 0) tempOutput += "You use the " + tempData[0] + " on yourself\n";
                else tempOutput += "You use the " + tempData[0] + " on " + "the Beast " + ".\n";//monsterRefresh.name isnt working so im changing it to "the beast"

                //prints if hits or misses (below)

                if (questionHit) {
                    if (Integer.parseInt(tempData[2]) == 0) tempOutput += "";
                    else if (Integer.parseInt(tempData[2]) < 0){
                        tempOutput += "This causes " + tempData[2] + " points of damage.\n";
                    }else{
                        tempOutput += "This heals " + tempData[2] + " points of damage.\n";
                    }
                    if (Double.parseDouble(tempData[3]) == 0) tempOutput += "";
                    else if (Double.parseDouble(tempData[3]) > 0)
                        tempOutput += "The " + tempData[0] + " seems to make the receiving end stronger!\n";
                    else tempOutput += "The " + tempData[0] + " weakens the receiving end!\n";
                    if (Double.parseDouble(tempData[4]) == 0) tempOutput += "";
                    else if (Double.parseDouble(tempData[4]) < 0)
                        tempOutput += "The " + tempData[0] + " discombobulates the receiving end!\n";
                    else tempOutput += "The " + tempData[0] + " focuses the receiving end!\n";
                    if (Double.parseDouble(tempData[5]) == 0) tempOutput += "";
                    else if (Double.parseDouble(tempData[5]) < 0)
                        tempOutput += "The " + tempData[0] + " enrages the soul!\n";
                    else tempOutput += "The " + tempData[0] + " weakens the soul.\n";

                }else {
            tempOutput += "It fails.\n";}
                System.out.println(tempOutput);

                if (tempData[1].equalsIgnoreCase("0")){
                    health += Integer.parseInt(tempData[2]);
                    playerRefresh.damageMult = Double.parseDouble(tempData[3]);
                    playerRefresh.accuracyMult = Double.parseDouble(tempData[4]);
                    //make effects toggle on (make effects in the first place. ie: burning, frozen, wet)
                    //make effects toggle off

                } else {
                    returningString[0] = "I";
                    returningString[1] = ""+Integer.parseInt(tempData[2]); //damage or healing
                    returningString[2] = ""+Double.parseDouble(tempData[3]); //damage mult
                    returningString[3] = ""+Double.parseDouble(tempData[4]); //accuracy mult
                    //make effects toggle on for monster
                    //make effects toggle off for monster
                }

                //using item (end)
            } return null;
    }

    public static void levelUp(){
        exp = expLim-exp;
        expLim = (int)Math.round(expLim*1.5);
        level++;
        String[] leveledStats;
        leveledStats = Leveler.levelUp(health,maxHealth);
        health = Integer.parseInt(leveledStats[0]);
        maxHealth = Integer.parseInt(leveledStats[1]);
        if (leveledStats[2].equalsIgnoreCase("damage")) attackMultiplierLocked+=Double.parseDouble(leveledStats[3]);
        if (leveledStats[2].equalsIgnoreCase("accuracy")) accuracyMultiplierLocked+=Double.parseDouble(leveledStats[3]);
        if (leveledStats[2].equalsIgnoreCase("speed")) speedMultiplierLocked+=Double.parseDouble(leveledStats[3]);
        if (leveledStats[2].equalsIgnoreCase("defence")) defensiveMultiplierLocked+=Double.parseDouble(leveledStats[3]);
    }
}