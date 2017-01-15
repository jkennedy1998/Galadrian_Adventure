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
    public static int itemSlot0 = 1;
    public static int itemSlot1 = 1;
    public static int itemSlot2 = 0;
    public static int itemSlot3 = 0;
    public static int itemSlot4 = 0;
    public static String tempBeastName = "";
    public static String tempUserString = "";
    public static double time;
    public static int day;

    public static void main(String args[]) {
        time = 12.0;
        day = 0;
        health = 100;
        maxHealth = 100;
        score = 0;
        accuracyMultiplier = 1;
        attackMultiplier = 1;
        defensiveMultiplier = 1;
        speedMultiplier = 1;
        CharacterCreation character = new CharacterCreation();
        CharacterCreation.race();
        CharacterCreation.role();
        accuracyMultiplierLocked += character.getAccuracyMultiplier();
        attackMultiplierLocked += character.getAttackMultiplier();
        defensiveMultiplierLocked += character.getDefensiveMultiplier();
        speedMultiplierLocked += character.getSpeedMultiplier();
        Story.initialize(attack1, attack2, attack3, attack4, itemSlot0, itemSlot1, itemSlot2, itemSlot3, itemSlot4);
        attack1 = character.getAttack1();
        attack2 = character.getAttack2();
        attack3 = character.getAttack3();
        attack4 = character.getAttack4();
        live();
    }

    public static void live() {
        while (time >=24){
            day ++;
            time = time-24;
        }
        if (exp >= expLim) {
            levelUp();
        }
        String[] buttons = {"Yes", "I REFUSE"};
        int answer = JOptionPane.showOptionDialog(null, "Would you like to strive on?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        if (answer == 0) {
            striveOn();
        } else if (answer == 1) {
            System.out.println("You have chosen to stop adventuring.\nI knew you were a Coward!");
            score = health + score;
            System.out.println("Your score is " + score);
            System.exit(0);
        } else {
            live();
        }

    }

    public static void death() {
        System.out.println("You have died while adventuring!\nHuh, quite the savior you are.");
        score = health + score;
        System.out.println("Your score is " + score);
        if (score >= 200) {
            // lets add an easter egg here!
        }
        if (health <= 0) {
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
                return ("\n" + itemTemp[0] + " has been stored in slot 1!");
            }
            if (tempValue == 1) {
                itemSlot1 = itemValue;
                return ("\n" + itemTemp[0] + " has been stored in slot 2!");
            }
            if (tempValue == 2) {
                itemSlot2 = itemValue;
                return ("\n" + itemTemp[0] + " has been stored in slot 3!");
            }
            if (tempValue == 3) {
                itemSlot3 = itemValue;
                return ("\n" + itemTemp[0] + " has been stored in slot 4!");
            }
            if (tempValue == 4) {
                itemSlot4 = itemValue;
                return ("\n" + itemTemp[0] + " has been stored in slot 5!");
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

                String[] moreButtons = {slot1, slot2, slot3, slot4, slot5};

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
                if (otherAnswer == 4) {
                    itemSlot4 = itemValue;
                    System.out.println(itemTemp[0] + " has been stored in slot 5!");
                }
            } else {
                return ("You have chosen to discard the item.");

            }
        }
        return "RETURN FOR THE SAKE OF HAVING TO RETURN A STRING.";
    }

    private static void startEncounter() {
        accuracyMultiplier = accuracyMultiplierLocked;
        attackMultiplier = attackMultiplierLocked;
        defensiveMultiplier = defensiveMultiplierLocked;
        speedMultiplier = speedMultiplierLocked;
        int beastStats[], beastStatsSolid[];
        beastStatsSolid = monsterSelection.main(roundCount);
        beastStats = beastStatsSolid;
        boolean lifeStatus = true;
        int turn = 0;
        boolean playerMultipliersChanged = false;
        boolean monsterMultipliersChanged = false;
        int turnOfPlayerEffect = 0;
        int turnOfMonsterEffect = 0;
        int monsterEffect = 0;
        int playerEffect = 0;
        do {
            if (speed * speedMultiplier >= beastStats[6]) {
                String[] tempData = playerTurn();
                if (tempData[0].equalsIgnoreCase("A")) {
                    beastStats[0] -= Integer.parseInt(tempData[1]);

                    if (Integer.parseInt(tempData[2]) != 0) { //for effect 1
                        if (Integer.parseInt(tempData[3]) == 1) { //self on
                            if (Integer.parseInt(tempData[2]) != playerEffect) {
                                turnOfPlayerEffect = turn;
                                playerEffect = Integer.parseInt(tempData[2]);
                            }
                        }
                        if (Integer.parseInt(tempData[3]) == 2) { //self off
                            if (Integer.parseInt(tempData[2]) == playerEffect) {
                                turnOfPlayerEffect = turn;
                                playerEffect = 0;
                            }
                        }
                        if (Integer.parseInt(tempData[3]) == 3) { //monster on
                            if (Integer.parseInt(tempData[2]) != monsterEffect) {
                                turnOfMonsterEffect = turn;
                                monsterEffect = Integer.parseInt(tempData[2]);
                            }
                        }
                        if (Integer.parseInt(tempData[3]) == 4) { //monster off
                            if (Integer.parseInt(tempData[2]) == monsterEffect) {
                                turnOfMonsterEffect = turn;
                                monsterEffect = 0;
                            }
                        }
                    }
                    if (Integer.parseInt(tempData[4]) != 0) { //for effect 2
                        if (Integer.parseInt(tempData[5]) == 1) { //self on
                            if (Integer.parseInt(tempData[4]) == playerEffect) {
                                turnOfPlayerEffect = turn;
                                playerEffect = Integer.parseInt(tempData[2]);
                            }
                        }
                        if (Integer.parseInt(tempData[5]) == 2) { //self off
                            if (Integer.parseInt(tempData[4]) == playerEffect) {
                                turnOfPlayerEffect = turn;
                                playerEffect = Integer.parseInt(tempData[2]);
                            }
                        }
                        if (Integer.parseInt(tempData[5]) == 3) { //monster on
                            if (Integer.parseInt(tempData[4]) != monsterEffect) {
                                turnOfMonsterEffect = turn;
                                monsterEffect = Integer.parseInt(tempData[2]);
                            }
                        }
                        if (Integer.parseInt(tempData[5]) == 4) { //monster off
                            if (Integer.parseInt(tempData[4]) == monsterEffect) {
                                turnOfMonsterEffect = turn;
                                monsterEffect = 0;
                            }
                        }
                    }
                } else if (tempData[0].equalsIgnoreCase("I")) {
                    beastStats[0] += Integer.parseInt(tempData[1]);
                    beastStats[7] += Double.parseDouble(tempData[2]);
                    beastStats[8] += Double.parseDouble(tempData[4]); //if you edit this data edit that one too! (see below)
                    beastStats[9] += Double.parseDouble(tempData[3]);
                    beastStats[10] += Double.parseDouble(tempData[5]);
                    if (monsterEffect != Integer.parseInt(tempData[6])) {
                        monsterEffect = Integer.parseInt(tempData[6]);
                        turnOfMonsterEffect = turn;
                    }
                }else{//if tempData[0] == IS
                    if (playerEffect != Integer.parseInt(tempData[1])) {
                        playerEffect = Integer.parseInt(tempData[1]);
                        turnOfPlayerEffect = turn;
                    }
                    if (playerEffect == Integer.parseInt(tempData[2])){
                        playerEffect = 0;
                        turnOfPlayerEffect = 0;
                    }

                }
                System.out.println("the current health of " + tempBeastName + " is at " + (beastStats[0]));
                if (beastStats[0] > 0) {
                    monsterTurn(beastStats, lifeStatus);
                }
            } else {
                monsterTurn(beastStats, lifeStatus);
                String[] tempData = playerTurn();
                if (tempData[0].equalsIgnoreCase("A")) {
                    beastStats[0] -= Integer.parseInt(tempData[1]);

                    if (Integer.parseInt(tempData[2]) != 0) { //for effect 1
                        if (Integer.parseInt(tempData[3]) == 1) { //self on
                            if (Integer.parseInt(tempData[2]) != playerEffect) {
                                turnOfPlayerEffect = turn;
                                playerEffect = Integer.parseInt(tempData[2]);
                            }
                        }
                        if (Integer.parseInt(tempData[3]) == 2) { //self off
                            if (Integer.parseInt(tempData[2]) == playerEffect) {
                                turnOfPlayerEffect = turn;
                                playerEffect = 0;
                            }
                        }
                        if (Integer.parseInt(tempData[3]) == 3) { //monster on
                            if (Integer.parseInt(tempData[2]) != monsterEffect) {
                                turnOfMonsterEffect = turn;
                                monsterEffect = Integer.parseInt(tempData[2]);
                            }
                        }
                        if (Integer.parseInt(tempData[3]) == 4) { //monster off
                            if (Integer.parseInt(tempData[2]) == monsterEffect) {
                                turnOfMonsterEffect = turn;
                                monsterEffect = 0;
                            }
                        }
                    }
                    if (Integer.parseInt(tempData[4]) != 0) { //for effect 2
                        if (Integer.parseInt(tempData[5]) == 1) { //self on
                            if (Integer.parseInt(tempData[4]) == playerEffect) {
                                turnOfPlayerEffect = turn;
                                playerEffect = Integer.parseInt(tempData[2]);
                            }
                        }
                        if (Integer.parseInt(tempData[5]) == 2) { //self off
                            if (Integer.parseInt(tempData[4]) == playerEffect) {
                                turnOfPlayerEffect = turn;
                                playerEffect = Integer.parseInt(tempData[2]);
                            }
                        }
                        if (Integer.parseInt(tempData[5]) == 3) { //monster on
                            if (Integer.parseInt(tempData[4]) != monsterEffect) {
                                turnOfMonsterEffect = turn;
                                monsterEffect = Integer.parseInt(tempData[2]);
                            }
                        }
                        if (Integer.parseInt(tempData[5]) == 4) { //monster off
                            if (Integer.parseInt(tempData[4]) == monsterEffect) {
                                turnOfMonsterEffect = turn;
                                monsterEffect = 0;
                            }
                        }
                    }

                } else { //if tempData[0] == "I" (for clarification)
                    beastStats[0] += Integer.parseInt(tempData[1]);
                    beastStats[7] += Double.parseDouble(tempData[2]);
                    beastStats[8] += Double.parseDouble(tempData[4]); //if you edit this data edit that one too! (see above)
                    beastStats[9] += Double.parseDouble(tempData[3]);
                    beastStats[10] += Double.parseDouble(tempData[5]);
                    if (monsterEffect != Integer.parseInt(tempData[6])) {
                        monsterEffect = Integer.parseInt(tempData[6]);
                        turnOfMonsterEffect = turn;
                    }
                }
                System.out.println("the current health of " + tempBeastName + " is at " + (beastStats[0]));
            }
            //make effects taking place start

            if (playerEffect != 0) {
                if (turn - turnOfPlayerEffect <= Integer.parseInt(effectDatabase.getEffectData(playerEffect)[2])) {
                    int tempDam = Integer.parseInt(effectDatabase.getEffectData(playerEffect)[1]);
                    health += tempDam;
                    if (tempDam < 0)
                        System.out.println("\nYour " + effectDatabase.getEffectData(playerEffect)[0] + " caused " + tempDam + " points of damage!");
                    if (tempDam > 0)
                        System.out.println("\nYour " + effectDatabase.getEffectData(playerEffect)[0] + " healed " + tempDam + " points of damage!");
                    if (!playerMultipliersChanged) {
                        playerMultipliersChanged = true;
                        double tempDaMod = Double.parseDouble(effectDatabase.getEffectData(playerEffect)[3]);
                        double tempSpMod = Double.parseDouble(effectDatabase.getEffectData(playerEffect)[4]);
                        double tempDeMod = Double.parseDouble(effectDatabase.getEffectData(playerEffect)[5]);
                        double tempAcMod = Double.parseDouble(effectDatabase.getEffectData(playerEffect)[6]);
                        System.out.println("\nYou are now " + (effectDatabase.getEffectData(playerEffect)[0]) + "!");
                        if (tempDaMod != 0) {
                            if (tempDaMod > 0)
                                System.out.println("You feel stronger!");
                            if (tempDaMod > 0)
                                System.out.println("Your attacks seem lessened!");
                            attackMultiplier += tempDaMod;
                        }
                        if (tempSpMod != 0) {
                            if (tempSpMod > 0)
                                System.out.println("Your feel a rush of adrenaline!");
                            if (tempSpMod < 0)
                                System.out.println("You feel sluggish!");
                            speedMultiplier += tempSpMod;
                        }
                        if (tempDeMod != 0) {
                            if (tempDeMod > 0)
                                System.out.println("You feel more accustomed to your armor!");
                            if (tempDeMod < 0)
                                System.out.println("your enemy has noticed a weak point in your armor");
                            defensiveMultiplier += tempDeMod;
                        }
                        if (tempAcMod != 0) {
                            if (tempAcMod > 0)
                                System.out.println("You feel focused!");
                            if (tempAcMod < 0)
                                System.out.println("You have become distracted in the chaos of battle");
                            accuracyMultiplier += tempAcMod;
                        }
                    }
                } else {
                    playerMultipliersChanged = false;
                    attackMultiplier -= Double.parseDouble(effectDatabase.getEffectData(playerEffect)[3]);
                    speedMultiplier -= Double.parseDouble(effectDatabase.getEffectData(playerEffect)[4]);
                    defensiveMultiplier -= Double.parseDouble(effectDatabase.getEffectData(playerEffect)[5]);
                    accuracyMultiplier -= Double.parseDouble(effectDatabase.getEffectData(playerEffect)[6]);
                }
            }
            if (monsterEffect != 0) {
                if (turn - turnOfMonsterEffect <= Integer.parseInt(effectDatabase.getEffectData(monsterEffect)[2])) {
                    int tempDam = Integer.parseInt(effectDatabase.getEffectData(monsterEffect)[1]);
                    beastStats[0] += tempDam;
                    if (tempDam < 0)
                        System.out.println("\nThe monsters " + effectDatabase.getEffectData(monsterEffect)[0] + " caused " + tempDam + " points of damage!");
                    if (tempDam > 0)
                        System.out.println("\nThe monsters " + effectDatabase.getEffectData(monsterEffect)[0] + " healed " + tempDam + " points of damage!");
                    if (!monsterMultipliersChanged) {
                        monsterMultipliersChanged = true;
                        double tempDaMod = Double.parseDouble(effectDatabase.getEffectData(monsterEffect)[3]);
                        double tempSpMod = Double.parseDouble(effectDatabase.getEffectData(monsterEffect)[4]);
                        double tempDeMod = Double.parseDouble(effectDatabase.getEffectData(monsterEffect)[5]);
                        double tempAcMod = Double.parseDouble(effectDatabase.getEffectData(monsterEffect)[6]);
                        System.out.println("\nThe monster is now " + (effectDatabase.getEffectData(monsterEffect)[0]) + "!");
                        if (tempDaMod != 0) {
                            if (tempDaMod > 0)
                                System.out.println("The monster seems stronger!");
                            if (tempDaMod > 0)
                                System.out.println("The monster's attacks seem lessened!");
                            beastStats[7] += tempDaMod;
                        }
                        if (tempSpMod != 0) {
                            if (tempSpMod > 0)
                                System.out.println("The monster's lunges seem quicker!");
                            if (tempSpMod < 0)
                                System.out.println("You find yourself running laps around the beast!");
                            beastStats[8] += tempSpMod;
                        }
                        if (tempDeMod != 0) {
                            if (tempDeMod > 0)
                                System.out.println("The beasts skin seems tougher!");
                            if (tempDeMod < 0)
                                System.out.println("You notice a small hole in the beasts armor!");
                            beastStats[10] += tempDeMod;
                        }
                        if (tempAcMod != 0) {
                            if (tempAcMod > 0)
                                System.out.println("The monster is hitting consistent blows!");
                            if (tempAcMod < 0)
                                System.out.println("The monster is overwhelmed by the chaos of battle!");
                            beastStats[9] += tempAcMod;
                        }
                    }
                } else {
                    playerMultipliersChanged = false;
                    beastStats[7] -= Double.parseDouble(effectDatabase.getEffectData(playerEffect)[3]);
                    beastStats[8] -= Double.parseDouble(effectDatabase.getEffectData(playerEffect)[4]);
                    beastStats[10] -= Double.parseDouble(effectDatabase.getEffectData(playerEffect)[5]);
                    beastStats[9] -= Double.parseDouble(effectDatabase.getEffectData(playerEffect)[6]);
                }
            }
            turn++;
            time+=0.1;
        } while (health > 0 && beastStats[0] > 0);
        if (health <= 0)
            adventurerework.death();

        roundCount += 1;
        time +=1;
        score += 15;
        exp += 5;
        System.out.println("your health is at " + health + ".\nYou are on round " + roundCount + ".");
        String endEncounterDialog = "";
        endEncounterDialog += ("You have vanquished " + tempBeastName + "!");
        lifeStatus = false;
        if (monsterTurn(beastStats, lifeStatus) == 1) {
            endEncounterDialog += getItem(beastStats[4]);
            System.out.println(endEncounterDialog);
        }
        if ((health < maxHealth) && (roundCount % 5 == 0)) {
            int tempHealth = (int) (Math.round(Math.random() * 20));
            health += tempHealth;
            if (health > maxHealth) {
                health = maxHealth;
            }
            System.out.println("You feel your past wounds begin to heal.\nYou regain " + tempHealth + " health.");
        }
        adventurerework.live();
    }


    private static int monsterTurn(int[] beastStats, boolean lifeStatus) {


        Monster monsterRefresh = new Monster(beastStats[0], beastStats[1], beastStats[2], beastStats[3], beastStats[4], beastStats[5], beastStats[6], beastStats[7], beastStats[8], beastStats[9], beastStats[10]);
        if (lifeStatus) {
            System.out.println(tempBeastName + " attacks!");
            String tempMAttack = monsterRefresh.calculateHit();
            if (tempMAttack.equalsIgnoreCase("The beast has missed!")) {
                System.out.println(tempBeastName + " has missed!");
            } else {
                int tempMAttack2 = Integer.parseInt(tempMAttack);
                health -= tempMAttack2;
                System.out.println(tempBeastName + " attacks for " + tempMAttack2 + " damage!\nYour current health is at " + (health) + "");
            }
            if (health <= 0) {
                health = 0;
                adventurerework.death();

            }
        } else return monsterRefresh.questionItem();
        return 5318008; //returns but does nothing. such savagery
    }

    private static String[] playerTurn() {
        String[] returningString = {"", "", "", "", "", "", "", ""};

        String tempDialog = "";
        Player playerRefresh = new Player();
        playerRefresh.initialize(attack1, attack2, attack3, attack4, attackMultiplier, accuracyMultiplier);
        System.out.println("It's your turn to attack!\n");
        String attackStorage[] = playerRefresh.PlayerAttack(tempDialog);
        if (!(attackStorage[0].equalsIgnoreCase("item"))) { //not using item
            if (attackStorage[0].equalsIgnoreCase("Miss")) {
            }//does nothing on purpose
            else {
                int[] tempPAttack = {0, 0, 0, 0, 0};
                tempPAttack[0] = Integer.parseInt(attackStorage[0]);
                System.out.println("You attack for " + tempPAttack[0] + " damage!");
                returningString[0] = "A";
                returningString[1] = "" + tempPAttack[0];
                returningString[2] = "" + (attackStorage[1]);
                returningString[3] = "" + (attackStorage[2]);
                returningString[4] = "" + (attackStorage[3]);
                returningString[5] = "" + (attackStorage[4]);


                return returningString;
            }
        } else {                                            //using item (start)
            boolean questionHit;
            String[] tempData = playerRefresh.PlayerItem();
            System.out.println("You used the " + tempData[0]);
            questionHit =  (Math.round(Integer.parseInt(tempData[7])) <= Math.round(Math.random() * 100 * accuracyMultiplier)); //true or false.
            //prints regardless (below)
            String tempOutput = "";
            if (Integer.parseInt(tempData[1]) == 0) tempOutput += "You use the " + tempData[0] + " on yourself\n";
            else tempOutput += "You use the " + tempData[0] + " on " + tempBeastName + ".\n";

            //prints if hits or misses (below)

            if (questionHit) {
                if (Integer.parseInt(tempData[2]) == 0) tempOutput += "";
                else if (Integer.parseInt(tempData[2]) < 0) {
                    tempOutput += "This causes " + tempData[2] + " points of damage.\n";
                } else {
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

            } else {
                tempOutput += "It fails.\n";
            }
            System.out.println(tempOutput);

            if (tempData[1].equalsIgnoreCase("0")) {
                health += Integer.parseInt(tempData[2]);
                attackMultiplier += Double.parseDouble(tempData[3]);
                accuracyMultiplier += Double.parseDouble(tempData[4]);
                defensiveMultiplier += Double.parseDouble(tempData[5]);
                speedMultiplier += Double.parseDouble(tempData[6]);
                returningString[0] = "IS";
                returningString[1] = "" + Integer.parseInt(tempData[8]); //eff on
                returningString[2] = "" + Integer.parseInt(tempData[9]); //eff off
                return returningString;

            } else {
                returningString[0] = "I";
                returningString[1] = "" + Integer.parseInt(tempData[2]); //damage or healing
                returningString[2] = "" + Double.parseDouble(tempData[3]); //damage mult
                returningString[3] = "" + Double.parseDouble(tempData[4]); //accuracy mult
                returningString[4] = "" + Double.parseDouble(tempData[6]); //speed mult
                returningString[5] = "" + Double.parseDouble(tempData[5]); //defence mult
                returningString[6] = "" + Integer.parseInt(tempData[8]); //eff on
                returningString[7] = "" + Integer.parseInt(tempData[9]); //eff off
                return returningString;
            }

            //using item (end)
        }
        return null;
    }


private static void levelUp() {
    exp = expLim - exp;
    expLim = (int) Math.round(expLim * 1.5);
    level++;
    String[] leveledStats;
    leveledStats = Leveler.levelUp(health, maxHealth);
    health = Integer.parseInt(leveledStats[0]);
    maxHealth = Integer.parseInt(leveledStats[1]);
    if (leveledStats[2].equalsIgnoreCase("damage")) attackMultiplierLocked += Double.parseDouble(leveledStats[3]);
    if (leveledStats[2].equalsIgnoreCase("accuracy")) accuracyMultiplierLocked += Double.parseDouble(leveledStats[3]);
    if (leveledStats[2].equalsIgnoreCase("speed")) speedMultiplierLocked += Double.parseDouble(leveledStats[3]);
    if (leveledStats[2].equalsIgnoreCase("defence")) defensiveMultiplierLocked += Double.parseDouble(leveledStats[3]);
}

}
