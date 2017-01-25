import javax.swing.*;

public class adventurerework {
    public static int maxHealth;
    public static int speed = 60;
    public static int level = 0;
    public static double attackMultiplierLocked, accuracyMultiplierLocked, defensiveMultiplierLocked, speedMultiplierLocked;
    public static int coins;
    public static int roundCount = 1;
    public static int lastRoundInShop = 0;
    public static int exp = 0;
    public static int expLim = 15;
    public static int itemSlot0 = 1;
    public static int itemSlot1 = 1;
    public static int itemSlot2 = 0;
    public static int itemSlot3 = 0;
    public static int itemSlot4 = 0;
    public static int[] armor = {0,8,0,0,9,0};
    public static String tempBeastName = "";
    public static String tempUserString = "";
    public static double time;
    public static int day;
    public static CharacterCreation character1 = new CharacterCreation();

    public static void main(String args[]) {
        time =20.0;
        day = 0;
        maxHealth = 100;
        coins = 0;
        character1.race();
        character1.role();
        Story.initialize(character1.attack1, character1.attack2, character1.attack3, character1.attack4, itemSlot0, itemSlot1, itemSlot2, itemSlot3, itemSlot4);
        live();

    }

    public static void live() {
        while (time >=24){
            day ++;
            time = time-24;
        }
        if (time > 22 || time < 5) { //between 10 pm and 5 am
            String temp = Leveler.rest();
            if (temp.equalsIgnoreCase("e")) {
                System.out.println("\nYou have been ambushed in your sleep!");
                startEncounter();
            }else {
                character1.setHealth(Integer.parseInt(temp));
                System.out.println("\nYou wake up at around "+Math.round(time)+".\nYou have regained "+temp+" health points by resting.");
            }
        }
        String[] buttons = {"Yes", "I REFUSE"};
        int answer = JOptionPane.showOptionDialog(null, "Would you like to strive on?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        if (answer == 0) {
            striveOn();
        } else if (answer == 1) {
            System.out.println("You have chosen to stop adventuring.\nI knew you were a Coward!");
            System.exit(0);
        } else {
            live();
        }


    }

    public static void death() {
        System.out.println("You have died while adventuring!\nHuh, quite the savior you are.");
    }

    public static void striveOn() {
        System.out.println("You strive on.");
        startEncounter();
        live();
    }

    public static String getItem(int itemValue) {
        if(ItemDirectory.findItemValues(itemValue)[1].equalsIgnoreCase("2")) {

            if (armor[Integer.parseInt(ItemDirectory.findItemValues(itemValue)[7])] == 0) {
                armor[Integer.parseInt(ItemDirectory.findItemValues(itemValue)[7])] = itemValue;
            } else {
                String[] buttons = {"replace armor", "keep old armor"};
                String prompt = ("You cannot equip the"+ItemDirectory.findItemValues(itemValue)[0]+ " while already wearing the "+ItemDirectory.findItemValues(armor[Integer.parseInt(ItemDirectory.findItemValues(itemValue)[7])])[0]);
                int answer = JOptionPane.showOptionDialog(null, prompt, "",
                        JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
                if (answer ==0){
                    armor[Integer.parseInt(ItemDirectory.findItemValues(itemValue)[7])] = itemValue;
                    System.out.println("You have replaced your old armor.");
                    return "";
                }else {
                    System.out.println("You have abandoned the newly found armor.");
                    return "";
                }
            }
        } else {
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
        }return null;
    }

    private static void startEncounter() {
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
            if (speed * character1.getSpeedMultiplier() >= beastStats[6]) {
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
                } else if (tempData[0].equalsIgnoreCase("IS")) {
                    if (playerEffect != Integer.parseInt(tempData[1])) {
                        playerEffect = Integer.parseInt(tempData[1]);
                        turnOfPlayerEffect = turn;
                    }
                    if (playerEffect == Integer.parseInt(tempData[2])) {
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
                } else if (tempData[0].equalsIgnoreCase("IS")) {
                    if (playerEffect != Integer.parseInt(tempData[1])) {
                        playerEffect = Integer.parseInt(tempData[1]);
                        turnOfPlayerEffect = turn;
                    }
                    if (playerEffect == Integer.parseInt(tempData[2])) {
                        playerEffect = 0;
                        turnOfPlayerEffect = 0;
                    }

                }
                System.out.println("the current health of " + tempBeastName + " is at " + (beastStats[0]));
                //make effects taking place start

                if (playerEffect != 0) {
                    if (turn - turnOfPlayerEffect <= Integer.parseInt(effectDatabase.getEffectData(playerEffect)[2])) {
                        int tempDam = Integer.parseInt(effectDatabase.getEffectData(playerEffect)[1]);
                        character1.setHealth(tempDam);
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
                                character1.setAttackMultiplier(tempDaMod);
                            }
                            if (tempSpMod != 0) {
                                if (tempSpMod > 0)
                                    System.out.println("Your feel a rush of adrenaline!");
                                if (tempSpMod < 0)
                                    System.out.println("You feel sluggish!");
                                character1.setSpeedMultiplier(tempSpMod);
                            }
                            if (tempDeMod != 0) {
                                if (tempDeMod > 0)
                                    System.out.println("You feel more accustomed to your armor!");
                                if (tempDeMod < 0)
                                    System.out.println("your enemy has noticed a weak point in your armor");
                                character1.setDefensiveMultiplier(tempDeMod);
                            }
                            if (tempAcMod != 0) {
                                if (tempAcMod > 0)
                                    System.out.println("You feel focused!");
                                if (tempAcMod < 0)
                                    System.out.println("You have become distracted in the chaos of battle");
                                character1.setAccuracyMultiplier(tempAcMod);
                            }
                        }
                    } else {
                        playerMultipliersChanged = false;
                        character1.setAttackMultiplier
                                (-Double.parseDouble(effectDatabase.getEffectData(playerEffect)[3]));
                        character1.setSpeedMultiplier
                                (-Double.parseDouble(effectDatabase.getEffectData(playerEffect)[4]));
                        character1.setDefensiveMultiplier
                                (-Double.parseDouble(effectDatabase.getEffectData(playerEffect)[5]));
                        character1.setAccuracyMultiplier
                                (-Double.parseDouble(effectDatabase.getEffectData(playerEffect)[6]));
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
                time += (Math.random()/6);
            }
        }while (character1.getHealth() > 0 && beastStats[0] > 0) ;
            if (character1.getHealth() <= 0)
                adventurerework.death();

        String endEncounterDialog = "";
        endEncounterDialog += ("You have vanquished " + tempBeastName + "!");
        lifeStatus = false;
        if (monsterTurn(beastStats, lifeStatus) != 0) {
            endEncounterDialog += getItem(beastStats[4]);
        }
        if ((character1.getHealth() < maxHealth) && (roundCount % 5 == 0)) {
            int tempHealth = (int) (Math.round(Math.random() * 20));
            character1.setHealth(tempHealth);
            if (character1.getHealth() > maxHealth) {
                character1.permHealth(maxHealth);
            }
            System.out.println("You feel your past wounds begin to heal.\nYou regain " + tempHealth + " health.");
        }
            System.out.println(endEncounterDialog);
            roundCount += 1;
            double temp = Math.random()*5.5;
            time += temp;
        if ((int)temp == 1)
            System.out.println("1 hour has passed.");
        else
            System.out.println((int)temp+" hours have passed.");
        System.out.println("it appears to be around "+(int)(time+1)+".");
        exp += beastStats[11];
        int tempCoins= (int)Math.round(Math.random()*beastStats[12]);
        if (tempCoins>0)
            System.out.println("You have looted "+ tempBeastName + " for "+tempCoins+" coins!");
        coins+=tempCoins;
        System.out.println("your health is at " + character1.getHealth() + ".");
        if (time <= 22 && time >= 5) { //not between 10 pm and 5 am
            if (Math.random()*100>75)
                System.out.println("");
                SideQuests.selectSidequest();
        }
        if(roundCount-lastRoundInShop>10&&Math.random()>.4){//60 percent chance for shop encounter if you havent seen a shop in 5 rounds
        Shop.start();
            lastRoundInShop = roundCount;
        }
            adventurerework.live();
        }


    private static int monsterTurn(int[] beastStats, boolean lifeStatus) {


        Monster monsterRefresh = new Monster(beastStats[0], beastStats[1], beastStats[2], beastStats[3], beastStats[4], beastStats[5], beastStats[6], beastStats[7], beastStats[8], beastStats[9], beastStats[10]);
        if (lifeStatus) {
            System.out.println(tempBeastName + " attacks!");
            String tempMAttack = monsterRefresh.calculateHit(getArmorStats());
            if (tempMAttack.equalsIgnoreCase("The beast has missed!")) {
                System.out.println(tempBeastName + " has missed!");
            } else {
                int tempMAttack2 = Integer.parseInt(tempMAttack);
                questionArmorBreak(tempMAttack2);
                character1.setHealth(-tempMAttack2);
                System.out.println(tempBeastName + " attacks for " + tempMAttack2 + " damage!\nYour current health is at " + (character1.getHealth()) + "");
            }
            if (character1.getHealth() <= 0) {
                character1.permHealth(0);
                adventurerework.death();
            }
        } else return monsterRefresh.questionItem(beastStats[4],beastStats[5]);
        return 5318008; //returns but does nothing. such savagery
    }

    private static String[] playerTurn() {
        String[] returningString = {"", "", "", "", "", "", "", ""};

        String tempDialog = "";
        Player playerRefresh = new Player();
        playerRefresh.initialize(character1.attack1, character1.attack2, character1.attack3, character1.attack4,
                character1.getAttackMultiplier(), character1.getAccuracyMultiplier());
        System.out.println("It's your turn to attack!\n");
        String attackStorage[] = playerRefresh.PlayerAttack(tempDialog);
        if (!(attackStorage[0].equalsIgnoreCase("item"))) { //not using item
            if (attackStorage[0].equalsIgnoreCase("Miss")) {
                returningString[0] = "miss";
                return returningString;
            }
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
            questionHit =  (Math.round(Integer.parseInt(tempData[7])) <= Math.round(Math.random() * 100 * character1.getAccuracyMultiplier())); //true or false.
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
                character1.setHealth(Integer.parseInt(tempData[2]));
                character1.setAttackMultiplier(Double.parseDouble(tempData[3]));
                character1.setAccuracyMultiplier(Double.parseDouble(tempData[4]));
                character1.setDefensiveMultiplier(Double.parseDouble(tempData[5]));
                character1.setSpeedMultiplier(Double.parseDouble(tempData[6]));
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
    }

public static void levelUp() {
    exp = exp - expLim;
    expLim = (int) Math.round(expLim * 1.5);
    level++;
    String[] leveledStats;
    leveledStats = Leveler.levelUp(character1.getHealth(), maxHealth);
    character1.permHealth(Integer.parseInt(leveledStats[0]));
    maxHealth = Integer.parseInt(leveledStats[1]);
    if (leveledStats[2].equalsIgnoreCase("damage")) attackMultiplierLocked += Double.parseDouble(leveledStats[3]);
    if (leveledStats[2].equalsIgnoreCase("accuracy")) accuracyMultiplierLocked += Double.parseDouble(leveledStats[3]);
    if (leveledStats[2].equalsIgnoreCase("speed")) speedMultiplierLocked += Double.parseDouble(leveledStats[3]);
    if (leveledStats[2].equalsIgnoreCase("defence")) defensiveMultiplierLocked += Double.parseDouble(leveledStats[3]);
}
private  static int getArmorStats(){
    int stat = 0;
    stat += Integer.parseInt(ItemDirectory.findItemValues(armor[0])[2]);
    stat += Integer.parseInt(ItemDirectory.findItemValues(armor[1])[2]);
    stat += Integer.parseInt(ItemDirectory.findItemValues(armor[2])[2]);
    stat += Integer.parseInt(ItemDirectory.findItemValues(armor[3])[2]);
    stat += Integer.parseInt(ItemDirectory.findItemValues(armor[4])[2]);
    stat += Integer.parseInt(ItemDirectory.findItemValues(armor[5])[2]);
    return (int)Math.round(stat*character1.getDefensiveMultiplier());
}
private static void questionArmorBreak(int attack){
    boolean questionChange = false;
    if (Integer.parseInt(ItemDirectory.findItemValues(armor[0])[8])<= attack && armor[0]!=0) {
        System.out.println("Your "+ItemDirectory.findItemValues(armor[0])[0]+" has broken from incoming damage!");
        armor[0] = 0;
        questionChange = true;}
    if (Integer.parseInt(ItemDirectory.findItemValues(armor[0])[8])<= attack && armor[1]!=0) {
        System.out.println("Your "+ItemDirectory.findItemValues(armor[1])[0]+" has broken from incoming damage!");
        armor[1] = 0;
        questionChange = true;}
    if (Integer.parseInt(ItemDirectory.findItemValues(armor[0])[8])<= attack && armor[2]!=0) {
        System.out.println("Your "+ItemDirectory.findItemValues(armor[2])[0]+" has broken from incoming damage!");
        armor[2] = 0;
        questionChange = true;}
    if (Integer.parseInt(ItemDirectory.findItemValues(armor[0])[8])<= attack && armor[3]!=0) {
        System.out.println("Your "+ItemDirectory.findItemValues(armor[3])[0]+" has broken from incoming damage!");
        armor[3] = 0;
        questionChange = true;}
    if (Integer.parseInt(ItemDirectory.findItemValues(armor[0])[8])<= attack && armor[4]!=0) {
        System.out.println("Your "+ItemDirectory.findItemValues(armor[4])[0]+" has broken from incoming damage!");
        armor[4] = 0;
        questionChange = true;}
    if (Integer.parseInt(ItemDirectory.findItemValues(armor[0])[8])<= attack && armor[5]!=0) {
        System.out.println("Your "+ItemDirectory.findItemValues(armor[5])[0]+" has broken from incoming damage!");
        armor[5] = 0;
        questionChange = true;}
    if (armor[0]==0&&armor[1]==0&&armor[4]==0&&armor[5]==0&&questionChange)
        System.out.println("You notice a cool breeze...");

}

}
