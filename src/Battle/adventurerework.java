package Battle;

import cartography.*;

public class adventurerework {
    public static Moving adam;
    public static Screen window = new Screen();
    public static String keyPressed = "";
    public static double attackMultiplierLocked, accuracyMultiplierLocked, defensiveMultiplierLocked, speedMultiplierLocked;
    public static int coins;
    public static int roundCount = 1;
    public static int[] armor = {0,8,0,0,9,0};
    public static String tempBeastName = "";
    public static String tempUserString = "";
    public static double time;
    public static int day;
    public static CharacterCreation character1 = new CharacterCreation();
    public static Items inventory = new Items(1,1,0,0,0);

    public static void main(String args[]) {
        time =20.0;
        day = 0;
        coins = 0;
        character1.race();
        character1.role();
        Story.initialize(character1.getAttack1(), character1.getAttack2(), character1.getAttack3(), character1.getAttack4());
        KeyboardListener keyboardListener = new KeyboardListener();
        window.addKeyListener(keyboardListener);
        MouseListener mouseListener = new MouseListener();
        window.addMouseListener(mouseListener);
        Map.initializeMaps();
        adam = new Moving(3, 3, Map.currentBoard, "player", true);
        Map.currentBoard.movings.add(adam); //essential code to start maps and add a movable player!
        run(); //should replace strive

    }
    public static void run() {
        while (true) {
            for (int scan = 0; scan < adam.board.movings.size(); scan++) {
                strive(adam.board.movings.get(scan));
            }

        }
    }
    public static void strive(Moving piece) {
        if (piece.behavior.equals("player")) {

            adam.board.printBoard();
            boolean boundKey = false;
            while(!boundKey){
                System.out.print(""); //idk why this fixed an infinite loop bug, but it does.
                if (keyPressed.equals("W") || keyPressed.equals("A") || keyPressed.equals("S")|| keyPressed.equals("D") || keyPressed.equals("Space")){
                    boundKey = true;
                }
            }
            if (keyPressed.equals("W")) piece.moveUp();
            else if (keyPressed.equals("S")) piece.moveDown();
            else if (keyPressed.equals("A")) piece.moveLeft();
            else if (keyPressed.equals("D")) piece.moveRight();
            else if (keyPressed.equals(" ")) {
            }
            keyPressed = "";
        } else {
            int temp = (int) Math.round(Math.random());
            int[] answer = BehaviorDatabase.respond(piece);
            if (answer[0] == 1 && (temp == 1 || answer[1] == 0)) piece.moveRight();
            if (answer[0] == -1 && (temp == 1 || answer[1] == 0)) piece.moveLeft();
            if (answer[1] == -1 && (temp == 0 || answer[0] == 0)) piece.moveUp();
            if (answer[1] == 1 && (temp == 0 || answer[0] == 0)) piece.moveDown();
        }
    }

    public static void live() {
        while (time >=24){
            day ++;
            time = time-24;
        }
        if (time > 22 || time < 5) { //between 10 pm and 5 am
            String temp = Leveler.rest();
            if (temp.equalsIgnoreCase("e")) {
                window.print("You have been ambushed in your sleep!");
                Board board = new Board(0,0);
                Moving moving = new Moving(0,0,board,"goblin",false);
                startEncounter(moving);
            }else {
                character1.setHealth(Integer.parseInt(temp));
                {
                    String[] strings = {"You wake up at around " + (int) Math.round(time) + ".", "You have regained " + temp + " health points by resting."};
                    window.print(strings);
                }
            }
        }
    }

    public static void death() {
        window.print("You have died while adventuring!\nHuh, quite the savior you are.");
        System.out.println("you ended the game by dying.");
        System.exit(0);
    }

    public static void startEncounter(Moving beast) {
        String beastStats[], beastStatsSolid[];
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
        Timer battleTimer = new Timer(character1.getSpeed()*character1.getSpeedMultiplier(),Integer.parseInt(beastStats[6]));
        do {
            int hitting = battleTimer.determineNextHit();
            if (hitting == 0) { //is players turn
                String[] tempData = playerTurn();
                if (tempData[0].equalsIgnoreCase("A")) {
                    beastStats[0] = "" + (Integer.parseInt(beastStats[0]) - Integer.parseInt(tempData[1]));

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
                window.print("the current health of " + tempBeastName + " is at " + (beastStats[0]));
                if (playerEffect != 0) {
                    if (turn - turnOfPlayerEffect <= Integer.parseInt(effectDatabase.getEffectData(playerEffect)[2])) {
                        int tempDam = Integer.parseInt(effectDatabase.getEffectData(playerEffect)[1]);
                        character1.setHealth(tempDam);
                        if (tempDam < 0)
                            window.print("\nYour " + effectDatabase.getEffectData(playerEffect)[0] + " caused " + tempDam + " points of damage!");
                        if (tempDam > 0)
                            window.print("\nYour " + effectDatabase.getEffectData(playerEffect)[0] + " healed " + tempDam + " points of damage!");
                        if (!playerMultipliersChanged) {
                            playerMultipliersChanged = true;
                            double tempDaMod = Double.parseDouble(effectDatabase.getEffectData(playerEffect)[3]);
                            double tempSpMod = Double.parseDouble(effectDatabase.getEffectData(playerEffect)[4]);
                            double tempDeMod = Double.parseDouble(effectDatabase.getEffectData(playerEffect)[5]);
                            double tempAcMod = Double.parseDouble(effectDatabase.getEffectData(playerEffect)[6]);
                            window.print("You are now " + (effectDatabase.getEffectData(playerEffect)[0]) + "!");
                            if (tempDaMod != 0) {
                                if (tempDaMod > 0)
                                    window.print("You feel stronger!");
                                if (tempDaMod > 0)
                                    window.print("Your attacks seem lessened!");
                                character1.setAttackMultiplier(tempDaMod);
                            }
                            if (tempSpMod != 0) {
                                if (tempSpMod > 0)
                                    window.print("Your feel a rush of adrenaline!");
                                if (tempSpMod < 0)
                                    window.print("You feel sluggish!");
                                character1.setSpeedMultiplier(tempSpMod);
                            }
                            if (tempDeMod != 0) {
                                if (tempDeMod > 0)
                                    window.print("You feel more accustomed to your armor!");
                                if (tempDeMod < 0)
                                    window.print("your enemy has noticed a weak point in your armor");
                                character1.setDefensiveMultiplier(tempDeMod);
                            }
                            if (tempAcMod != 0) {
                                if (tempAcMod > 0)
                                    window.print("You feel focused!");
                                if (tempAcMod < 0)
                                    window.print("You have become distracted in the chaos of battle");
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
            } else { //is monsters turn
                monsterTurn(beastStats, lifeStatus);
                if (monsterEffect != 0) {
                    if (turn - turnOfMonsterEffect <= Integer.parseInt(effectDatabase.getEffectData(monsterEffect)[2])) {
                        int tempDam = Integer.parseInt(effectDatabase.getEffectData(monsterEffect)[1]);
                        beastStats[0] += tempDam;
                        if (tempDam < 0)
                            window.print("The monsters " + effectDatabase.getEffectData(monsterEffect)[0] + " caused " + tempDam + " points of damage!");
                        if (tempDam > 0)
                            window.print("\nThe monsters " + effectDatabase.getEffectData(monsterEffect)[0] + " healed " + tempDam + " points of damage!");
                        if (!monsterMultipliersChanged) {
                            monsterMultipliersChanged = true;
                            double tempDaMod = Double.parseDouble(effectDatabase.getEffectData(monsterEffect)[3]);
                            double tempSpMod = Double.parseDouble(effectDatabase.getEffectData(monsterEffect)[4]);
                            double tempDeMod = Double.parseDouble(effectDatabase.getEffectData(monsterEffect)[5]);
                            double tempAcMod = Double.parseDouble(effectDatabase.getEffectData(monsterEffect)[6]);
                            window.print("The monster is now " + (effectDatabase.getEffectData(monsterEffect)[0]) + "!");
                            if (tempDaMod != 0) {
                                if (tempDaMod > 0)
                                    window.print("The monster seems stronger!");
                                if (tempDaMod > 0)
                                    window.print("The monster's attacks seem lessened!");
                                beastStats[7] += tempDaMod;
                            }
                            if (tempSpMod != 0) {
                                if (tempSpMod > 0)
                                    window.print("The monster's lunges seem quicker!");
                                if (tempSpMod < 0)
                                    window.print("You find yourself running laps around the beast!");
                                beastStats[8] += tempSpMod;
                            }
                            if (tempDeMod != 0) {
                                if (tempDeMod > 0)
                                    window.print("The beasts skin seems tougher!");
                                if (tempDeMod < 0)
                                    window.print("You notice a small hole in the beasts armor!");
                                beastStats[10] += tempDeMod;
                            }
                            if (tempAcMod != 0) {
                                if (tempAcMod > 0)
                                    window.print("The monster is hitting consistent blows!");
                                if (tempAcMod < 0)
                                    window.print("The monster is overwhelmed by the chaos of battle!");
                                beastStats[9] += tempAcMod;
                            }
                        }
                    } else {
                        monsterMultipliersChanged = false;
                        beastStats[7] = ""+(Double.parseDouble(beastStats[7]) -Double.parseDouble(effectDatabase.getEffectData(playerEffect)[3]));
                        beastStats[8] = ""+(Double.parseDouble(beastStats[8]) -Double.parseDouble(effectDatabase.getEffectData(playerEffect)[4]));
                        beastStats[10] = ""+(Double.parseDouble(beastStats[10]) -Double.parseDouble(effectDatabase.getEffectData(playerEffect)[5]));
                        beastStats[9] = ""+(Double.parseDouble(beastStats[9]) -Double.parseDouble(effectDatabase.getEffectData(playerEffect)[6]));
                    }
                }
            }
                //make effects taking place start



            turn++;
            time += (Math.random()/6);
        }while (character1.getHealth() > 0 && Integer.parseInt(beastStats[0]) > 0) ;
            if (character1.getHealth() <= 0)
                adventurerework.death();

        String endEncounterDialog = "";
        endEncounterDialog += ("You have vanquished " + tempBeastName + "!");
        lifeStatus = false;
        if (monsterTurn(beastStats, lifeStatus) != 0) {
            endEncounterDialog += inventory.getItem (Integer.parseInt(beastStats[4]));
        }
        if ((character1.getHealth() < character1.getMaxHealth()) && (roundCount % 5 == 0)) {
            int tempHealth = (int) (Math.round(Math.random() * 20));
            character1.setHealth(tempHealth);
            if (character1.getHealth() > character1.getMaxHealth()) {
                character1.permHealth(character1.getMaxHealth());
            }
            window.print("You feel your past wounds begin to heal.\nYou regain " + tempHealth + " health.");
        }
        window.print(endEncounterDialog);
            roundCount += 1;
            double temp = Math.random()*5.5;
            time += temp;
        if ((int)temp == 1)
            window.print("1 hour has passed.");
        else
            window.print((int)temp+" hours have passed.");
        window.print("it appears to be around "+(int)(time+1)+".");
        character1.setExp(Integer.parseInt(beastStats[11]));
        int tempCoins= (int)Math.round(Math.random()*Integer.parseInt(beastStats[12]));
        if (tempCoins>0)
            window.print("You have looted "+ tempBeastName + " for "+tempCoins+" coins!");
        coins+=tempCoins;
        window.print("your health is at " + character1.getHealth() + ".");
        if(!beast.behavior.equals("player"))
        beast.board.removeMoving(beast);
            adventurerework.live();
        }

    private static int monsterTurn(String[] beastStats, boolean lifeStatus) {


        Monster monsterRefresh = new Monster(Integer.parseInt(beastStats[0]), beastStats[1], beastStats[2], beastStats[3], Integer.parseInt(beastStats[4]), Integer.parseInt(beastStats[5]), Integer.parseInt(beastStats[6]), Double.parseDouble(beastStats[7]), Double.parseDouble(beastStats[8]), Double.parseDouble(beastStats[9]), Double.parseDouble(beastStats[10]));
        if (lifeStatus) {
            window.print(tempBeastName + " attacks!");
            String tempMAttack = monsterRefresh.calculateHit(getArmorStats());
            if (tempMAttack.equalsIgnoreCase("The beast has missed!")) {
                window.print(tempBeastName + " has missed!");
            } else {
                int tempMAttack2 = Integer.parseInt(tempMAttack);
                character1.setHealth(-tempMAttack2);
                window.print(tempBeastName +" uses "+ monsterRefresh.attack + " \nIt does "+ tempMAttack2 + " damage!\nYour current health is at " + (character1.getHealth()) + "");
                questionArmorBreak(tempMAttack2);

            }
            if (character1.getHealth() <= 0) {
                character1.permHealth(0);
                adventurerework.death();
            }
        } else return monsterRefresh.questionItem(Integer.parseInt(beastStats[4]),Integer.parseInt(beastStats[5]));
        return 5318008; //returns but does nothing. such savagery
    }

    private static String[] playerTurn() {
        String[] returningString = {"", "", "", "", "", "", "", ""};

        String tempDialog = "";
        Player playerRefresh = new Player();
        playerRefresh.initialize(character1.getAttack1(), character1.getAttack2(), character1.getAttack3(), character1.getAttack4(),
                character1.getAttackMultiplier(), character1.getAccuracyMultiplier());
        window.print("It's your turn to attack!\n");
        String attackStorage[] = playerRefresh.PlayerAttack(tempDialog);
        if (!(attackStorage[0].equalsIgnoreCase("item"))) { //not using item
            if (attackStorage[0].equalsIgnoreCase("Miss")) {
                returningString[0] = "miss";
                return returningString;
            }
            else {
                int[] tempPAttack = {0, 0, 0, 0, 0};
                tempPAttack[0] = Integer.parseInt(attackStorage[0]);
                window.print("You attack for " + tempPAttack[0] + " damage!");
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
            window.print("You used the " + tempData[0]);
            questionHit =  (Math.round(Integer.parseInt(tempData[7])) <= Math.round(Math.random() * 100 * character1.getAccuracyMultiplier())); //true or false.
            //prints regardless (below)
            String tempOutput = "";
            if (Integer.parseInt(tempData[1]) == 0) tempOutput += "You use the " + tempData[0] + " on yourself\n";
            else tempOutput += "You use the " + tempData[0] + " on " + tempBeastName + ".\n";

            //prints if hits or misses (below)

            if (questionHit) { //needs to make this into a String []
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
            window.print(tempOutput);

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

    static void levelUp() {
    character1.permExp(character1.getExp() - character1.getExpLim());
    character1.permExpLim((int) Math.round(character1.getExpLim() * 1.5));
    character1.LevelUp();
    String[] leveledStats;
    leveledStats = Leveler.levelUp(character1.getHealth(), character1.getMaxHealth());
    character1.permHealth(Integer.parseInt(leveledStats[0]));
    character1.permMaxHealth(Integer.parseInt(leveledStats[1]));
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
    if (Integer.parseInt(ItemDirectory.findItemValues(armor[0])[8])<= attack && armor[0]!=0&&Math.random()>.8) {
        window.print("Your "+ItemDirectory.findItemValues(armor[0])[0]+" has broken from incoming damage!");
        armor[0] = 0;
        questionChange = true;}
    if (Integer.parseInt(ItemDirectory.findItemValues(armor[0])[8])<= attack && armor[1]!=0&&Math.random()>.8) {
        window.print("Your "+ItemDirectory.findItemValues(armor[1])[0]+" has broken from incoming damage!");
        armor[1] = 0;
        questionChange = true;}
    if (Integer.parseInt(ItemDirectory.findItemValues(armor[0])[8])<= attack && armor[2]!=0&&Math.random()>.8) {
        window.print("Your "+ItemDirectory.findItemValues(armor[2])[0]+" has broken from incoming damage!");
        armor[2] = 0;
        questionChange = true;}
    if (Integer.parseInt(ItemDirectory.findItemValues(armor[0])[8])<= attack && armor[3]!=0&&Math.random()>.8) {
        window.print("Your "+ItemDirectory.findItemValues(armor[3])[0]+" has broken from incoming damage!");
        armor[3] = 0;
        questionChange = true;}
    if (Integer.parseInt(ItemDirectory.findItemValues(armor[0])[8])<= attack && armor[4]!=0&&Math.random()>.8) {
        window.print("Your "+ItemDirectory.findItemValues(armor[4])[0]+" has broken from incoming damage!");
        armor[4] = 0;
        questionChange = true;}
    if (Integer.parseInt(ItemDirectory.findItemValues(armor[0])[8])<= attack && armor[5]!=0&&Math.random()>.8) {
        window.print("Your "+ItemDirectory.findItemValues(armor[5])[0]+" has broken from incoming damage!");
        armor[5] = 0;
        questionChange = true;}
    if (armor[0]==0&&armor[1]==0&&armor[4]==0&&armor[5]==0&&questionChange)
        window.print("You notice a cool breeze...");
}

}
