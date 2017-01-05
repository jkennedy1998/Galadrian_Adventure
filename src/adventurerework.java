import javax.swing.*;

public class adventurerework {
    public static int health, maxHealth;
    public static double attackMultiplier, accuracyMultiplier, defensiveMultiplier;
    public static int score;
    public static int roundCount = 1;
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
    public static int speed;

    public static void main(String args[]) {
        health = 100;
        maxHealth = 100;
        score = 0;
        accuracyMultiplier = 1;
        attackMultiplier = 1;
        defensiveMultiplier = 1;  //make this do things
        speed = 1; // i want the attacks to be based on the speed of the character and the speed on the enemy
        System.out.println("You're decision to enter this retched dungeon is valiant, but foolish.\nDo you have what it takes to get your lost sister back from His unholiness?\nFight long enough and maybe you'll find Margret!");
        CharacterCreation character = new CharacterCreation();
        String race = character.race();
        String role = character.role();
        accuracyMultiplier += character.getAccuracyMultiplier(race, role);
        live(role,accuracyMultiplier);
    }

    public static void live(String rolec,double accuracyMultiplier) {
        String[] buttons = {"Yes", "I REFUSE"};
        String role =rolec;
        int answer = JOptionPane.showOptionDialog(null, "Would you like to strive on?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        if (answer==0) {
            striveOn(role,accuracyMultiplier);
        } else if (answer==1) {
            System.out.println("You have chosen to stop adventuring.\nI knew you were a Coward!");
            score = health + score;
            System.out.println("Your score is " + score);
            System.exit(0);
        } else  {
            live(role,accuracyMultiplier);
        }
        //System.exit(0);


    }

    public static void death() {
        System.out.println("You have died while adventuring!\nHuh, quite the savior you are.");
        score = health + score;
        System.out.println("Your score is " + score);
        if (score>=200)
        {

        }
        if(health<= 0) {
            System.exit(0);
        }
    }

    public static void striveOn(String rolec,double accuracyMultiplier) {
        String role = rolec;
        System.out.println("You strive on.");
        startEncounter(role,accuracyMultiplier);
        live(role,accuracyMultiplier);
    }
    public static String getItem(int itemValue) {
        Items refreshInventory = new Items();
        refreshInventory.initializeItems(itemSlot0, itemSlot1, itemSlot2, itemSlot3, itemSlot4);
        int tempValue = refreshInventory.receiveItem(itemValue);
        String[] itemTemp = refreshInventory.getItemValues(itemValue);
        if (tempValue != 5) {
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
            if(tempValue == 4) {
                itemSlot4 = itemValue;
                return (itemTemp[0] + " has been stored in slot 5!");
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


    public static void startEncounter(String role,double accuracyMultiplier) {

        int beastStats[];
        System.out.println("your health is at " + health + ".\nYou are on round " + roundCount + ".");

        beastStats = monsterSelection.main(roundCount);
        Monster monsterRefresh = new Monster(beastStats[0], beastStats[1], beastStats[2], beastStats[3], beastStats[4], beastStats[5]);
        Encounter playerRefresh = new Encounter();
        if (role.equalsIgnoreCase("Ranger"))
            playerRefresh.initialize(attack1 ="Shot", attack2="Surprise Shot", attack3="Stab", attack4);
        else if (role.equalsIgnoreCase("Warlock"))
            playerRefresh.initialize(attack1 ="Hex", attack2="Dark Ones Blessing", attack3="Thirsting Blade", attack4);
        else if (role.equalsIgnoreCase("Druid"))
            playerRefresh.initialize(attack1 ="Shapechange", attack2="MoonBeam", attack3="Thunderwave", attack4);
        else
            playerRefresh.initialize(attack1="Slash", attack2="Jab", attack3="Punch", attack4);
        while (monsterRefresh.questionlife()) {
            String tempDialog = "";
            System.out.println ("The beast attacks!");
               String tempMAttack = monsterRefresh.calculateHit();
            if (tempMAttack.equalsIgnoreCase("The beast has missed!")){
                System.out.println ("The beast has missed!");
            }
            else {
                int tempMAttack2 = Integer.parseInt(tempMAttack);
                health -= tempMAttack2;
                System.out.println ("The beast attacks for " + tempMAttack2 + " damage!\nYour current health is at " + (health)+"");
            }
            if (health <= 0) {
                health = 0;
                adventurerework.death();}
            System.out.println("It's your turn to attack!\n");
            String attackStorage = playerRefresh.PlayerAttack(tempDialog,accuracyMultiplier);
            if (!(attackStorage.equalsIgnoreCase("item"))) {
                if (attackStorage.equalsIgnoreCase("Miss")) {
                }//does nothing on purpose
                else {
                    int tempPAttack = Integer.parseInt(attackStorage);
                    monsterRefresh.receiveHit(tempPAttack);
                    System.out.println("Its current health is at " + (monsterRefresh.health));
                }
            }else{
                boolean questionHit = true;
                String[] tempData = playerRefresh.PlayerItem();
                System.out.println("You used the "+tempData[0]);
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
                } else {
                    questionHit = false;
                }
                String tempOutput = "";
                if (Integer.parseInt(tempData[1]) == 0) tempOutput += "You use the " + tempData[0] + " on yourself\n";
                else tempOutput += "You use the " + tempData[0] + " on " + monsterRefresh.name + ".\n";
                if (questionHit) {
                    if (Integer.parseInt(tempData[2]) == 0) tempOutput += "";
                    else tempOutput += "This causes " + tempData[1] + " points of damage.\n";
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
            }
        }
        String endEncounterDialog = "";
        endEncounterDialog += ("You have vanquished the beast!");
        roundCount += 1;
        score += 15;
        if(monsterRefresh.questionItem()!= 0){
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
        adventurerework.live(role,accuracyMultiplier);
    }
}
//random comment to see if this commit and push works

