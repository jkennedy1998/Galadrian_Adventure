
public class monsterSelection {
    private static String beast;
    private static int beastStats[]= {0,0,0,0,0,0,0,1,1,1,1,0,0};
    private static boolean capital = false;
    private static int monsterCount = 0;
    private static int roundsHere = 0; //only used in locations with a set enemy


    public static int[] main (int round){
        if (round%10 == 0 ) {
            roundsHere = 0;
            Story.refresh(adventurerework.character1.getAttack1(), adventurerework.character1.getAttack2(),
                    adventurerework.character1.getAttack3(), adventurerework.character1.getAttack4(), adventurerework.itemSlot0,
                    adventurerework.itemSlot1, adventurerework.itemSlot2,
                    adventurerework.itemSlot3, adventurerework.itemSlot4);
            //that's the shortest line of code ever!
            Story.setDestination();
        }
        roundsHere++;
        selection();
        if (capital) {
            System.out.println("\n\nYou have encountered an " + beast + "!");
        } else{
            System.out.println("\n\nYou have encountered a " + beast + "!");
        }

        for (int pointsToGive = round; pointsToGive>0; pointsToGive--){ //this scales monsters per how many
            int rand = (int)Math.ceil(Math.random()*4);
            if (rand == 1)  beastStats[7]+=.05;
            if (rand == 2)  beastStats[8]+=.05;
            if (rand == 3)  beastStats[9]+=.05;
            if (rand == 4)  beastStats[10]+=.05;
        }
        beastNameGen.main(beast);
        return beastStats;
    }

    private static int outOfTwo(int first, int second){
        if (Math.ceil(Math.random())*2==1){
            return first;
        }else
            return second;
    }
    private static void selection() {
        if (Story.location.equalsIgnoreCase("Forest")) {
            monsterCount = 9;
            int monsterNumber = subSelect();

            if (monsterNumber == 1)
                selectDog();
            else if (monsterNumber == 2)
                selectCultist();
            else if (monsterNumber == 3)
                selectGoblin();
            else if (monsterNumber == 4)
                selectWarlock();
            else if (monsterNumber == 5)
                selectVampire();
            else if (monsterNumber == 6)
                selectSpiderling();
            else if (monsterNumber == 7)
                selectYaunTiMalison();
            else if (monsterNumber == 8)
                selectYaunTiPureBlood();
            else
                selectBat();
        }
        if (Story.location.equalsIgnoreCase("DeepForest")) {
            monsterCount = 9;
            int monsterNumber = subSelect();

            if (monsterNumber == 1)
                selectDog();
            else if (monsterNumber == 2)
                selectCultist();
            else if (monsterNumber == 3)
                selectGoblin();
            else if (monsterNumber == 4)
                selectWarlock();
            else if (monsterNumber == 5)
                selectVampire();
            else if (monsterNumber == 6)
                selectSpiderling();
            else if (monsterNumber == 7)
                selectYaunTiAbonimation();
            else if (monsterNumber == 8)
                selectDragon();
            else
                selectBat();
        }
        if (Story.location.equalsIgnoreCase("Plains")) {
            monsterCount = 9;
            int monsterNumber = subSelect();

            if (monsterNumber == 1)
                selectDog();
            else if (monsterNumber == 2)
                selectCultist();
            else if (monsterNumber == 3)
                selectGoblin();
            else if (monsterNumber == 4)
                selectWarlock();
            else if (monsterNumber == 5)
                selectVampire();
            else if (monsterNumber == 6)
                selectSpiderling();
            else if (monsterNumber == 7)
                selectYaunTiMalison();
            else if (monsterNumber == 8)
                selectYaunTiPureBlood();
            else
                selectBat();
        }
        if (Story.location.equalsIgnoreCase("Mountains")) {

            monsterCount = 7;
            int monsterNumber = subSelect();
            if (monsterNumber == 1)
                selectDrunkDwarf();
            else if (monsterNumber == 2)
                selectSkeleton();
            else if (monsterNumber == 3)
                selectVampire();
            else if (monsterNumber == 4)
                selectBat();
            else if (monsterNumber == 5)
                selectWarlock();
            else if (monsterNumber == 6)
                selectYaunTiAbonimation();
            else
                selectGoblin();

        }
        if (Story.location.equalsIgnoreCase("Cave")) {

            monsterCount = 4;
            int monsterNumber = subSelect();
            if (monsterNumber == 1)
                selectBat();
            else if (monsterNumber == 2)
                selectGoblin();
            else if (monsterNumber == 3)
                selectDrunkDwarf();
            else
                selectSkeleton();
        }
        if (Story.location.equalsIgnoreCase("Jungle")) {

            monsterCount = 7;
            int monsterNumber = subSelect();
            if (monsterNumber == 1)
                selectBat();
            else if (monsterNumber == 2)
                selectSpiderling();
            else if (monsterNumber == 3)
                selectYaunTiAbonimation();
            else if (monsterNumber == 4)
                selectBigBat();
            else if (monsterNumber == 5)
                selectNaga();
            else if (monsterNumber == 6)
                selectLargeCat();
            else
                selectSmallSnake();

        }
        if (Story.location.equalsIgnoreCase("Yuan-ti Fortress")) {

            monsterCount = 5;
            int monsterNumber = subSelect();
            if (monsterNumber == 1)
                selectYaunTiMalison();
            else if (monsterNumber == 2)
                selectYaunTiPureBlood();
            else if (monsterNumber == 3)
                selectYaunTiAbonimation();
            else if (monsterNumber == 4)
                selectNaga();
            else
                selectYaunTiMalison();

        }
        if (Story.location.equalsIgnoreCase("Yuan-ti Dungeon")) { //set listing

            if (roundsHere ==0) selectYaunTiPureBlood();
            else if (roundsHere ==1) selectYaunTiMalison();
            else if (roundsHere ==2) selectNaga();
            else if (roundsHere ==3) selectYaunTiMalison();
            else if (roundsHere ==4) selectYaunTiPureBlood();
            else if (roundsHere ==5) selectYaunTiAbonimation();
            else if (roundsHere ==6) selectWarlock();
            else if (roundsHere ==7) selectYaunTiHolyGuard();
            else if (roundsHere ==8) selectYaunTiHolyGuard();
            else if (roundsHere ==9){
                if (SideQuests.merrshaulkRitual()) selectMerrshaulk();
                else selectMerrshaulkAbomination();
            }

        }
        if (Story.location.equalsIgnoreCase("JaggedCoastline")) {

            monsterCount = 1;
            int monsterNumber = subSelect();
            if (monsterNumber == 1)
                selectCthulu();

        }
    }
    public static int subSelect(){
        //here are the amount of monsters

        return (int)(Math.round(Math.random()*monsterCount));
    }

    // Past this point should only contain beast selections.

//    public static void selectNAMEHERE(){
//        beast = "NAME HERE";
//        capital = false; //if the first letter is a vowel
//        beastStats[0] = (health value);
//        beastStats[1] = (maxAttack value);
//        beastStats[2] = (minAttack value);
//        beastStats[3] = (accuracy value out of 100); (number needed by the equation accMod*(a number1-100) (lower numbers hit more)
//        beastStats[4] = (item value);
//        beastStats[5] = (item drop rate %);
//        beastStats[6] = (speed value); (positive numbers. not modded character speed is 60)
//    }
    public static void selectDog(){
        beast = "Rabid Dog";
        capital = false;
        beastStats[0] = 25;
        beastStats[1] = 15;
        beastStats[2] = 10;
        beastStats[3] = 60;
        beastStats[4] = (0);
        beastStats[5] = (0);
        beastStats[6] = (60);
        beastStats[11] = (7);
        beastStats[12] = (0);

    }
    public static void selectSmallSnake(){
        beast = "Lesser Snake";
        capital = false;
        beastStats[0] = 25;
        beastStats[1] = 10;
        beastStats[2] = 9;
        beastStats[3] = 16;
        beastStats[4] = (0);
        beastStats[5] = (0);
        beastStats[6] = (70);
        beastStats[11] = (7);
        beastStats[12] = (0);

    }
    public static void selectLargeCat(){
        beast = "Large Cat";
        capital = false;
        beastStats[0] = 36;
        beastStats[1] = 30;
        beastStats[2] = 10;
        beastStats[3] = 38;
        beastStats[4] = (0);
        beastStats[5] = (0);
        beastStats[6] = (79);
        beastStats[11] = (27);
        beastStats[12] = (0);

    }
    public static void selectBat(){
        beast = "Small Bat";
        capital = false;
        beastStats[0] = 15;
        beastStats[1] = 10;
        beastStats[2] = 5;
        beastStats[3] = 20;
        beastStats[4] = (2);
        beastStats[5] = (30);
        beastStats[6] = (70);
        beastStats[11] = (5);
        beastStats[12] = (0);

    }
    public static void selectNaga(){
        beast = "Naga";
        capital = false;
        beastStats[0] = 40;
        beastStats[1] = 36;
        beastStats[2] = 27;
        beastStats[3] = 37;
        beastStats[4] = (0);
        beastStats[5] = (0);
        beastStats[6] = (48);
        beastStats[11] = (22);
        beastStats[12] = (0);

    }
    public static void selectBigBat(){
        beast = "Large Bat";
        capital = false;
        beastStats[0] = 38;
        beastStats[1] = 28;
        beastStats[2] = 25;
        beastStats[3] = 20;
        beastStats[4] = (2);
        beastStats[5] = (40);
        beastStats[6] = (58);
        beastStats[11] = (13);
        beastStats[12] = (0);

    }

    public static void selectGoblin(){
        beast = "Goblin";
        capital = false;
        beastStats[0] = 20;
        beastStats[1] = 20;
        beastStats[2] = 17;
        beastStats[3] = 50;
        beastStats[4] = (7);
        beastStats[5] = (50);
        beastStats[6] = (55);
        beastStats[11] = (15);
        beastStats[12] = (7);

    }
    public static void selectWarlock(){
        beast = "Warlock";
        capital = false;
        beastStats[0] = 20;
        beastStats[1] = 40;
        beastStats[2] = 20;
        beastStats[3] = 25;
        beastStats[4] = (outOfTwo(1,3));
        beastStats[5] = (40);
        beastStats[6] = (56);
        beastStats[11] = (17);
        beastStats[12] = (30);

    }
    public static void selectSkeleton(){
        beast = "Skeleton";
        capital = false;
        beastStats[0] = 15;
        beastStats[1] = 12;
        beastStats[2] = 3;
        beastStats[3] = 35;
        beastStats[4] = (10);
        beastStats[5] = (20);
        beastStats[6] = (45);
        beastStats[11] = (17);
        beastStats[12] = (10);

    }
    public static void selectVampire(){
        beast = "Vampire";
        capital = false;
        beastStats[0] = 40;
        beastStats[1] = 35;
        beastStats[2] = 20;
        beastStats[3] = 35;
        beastStats[4] = (5);
        beastStats[5] = (40);
        beastStats[6] = (60);
        beastStats[11] = (19);
        beastStats[12] = (26);

    }
    public static void selectCultist(){
        beast = "Cultist";
        capital = false;
        beastStats[0] = 20;
        beastStats[1] = 20;
        beastStats[2] = 9;
        beastStats[3] = 35;
        beastStats[4] = (3);
        beastStats[5] = (50);
        beastStats[6] = (60);
        beastStats[11] = (16);
        beastStats[12] = (24);

    }
    public static void selectDrunkDwarf(){
        beast = "Drunk Dwarf";
        capital = false;
        beastStats[0] = 35;
        beastStats[1] = 40;
        beastStats[2] = 30;
        beastStats[3] = 70;
        beastStats[4] = (outOfTwo(4,10));
        beastStats[5] = (95);
        beastStats[6] = (30);
        beastStats[11] = (19);
        beastStats[12] = (40);

    }
    public static void selectSpiderling() {
        beast = "Spiderling";
        capital = false;
        beastStats[0] = 10;
        beastStats[1] = 18;
        beastStats[2] = 10;
        beastStats[3] = 28;
        beastStats[4] = (2);
        beastStats[5] = (70);
        beastStats[6] = (67);
        beastStats[11] = (7);
        beastStats[12] = (0);

    }
    public static void selectDragon(){
        beast = "Dragon";
        capital = false;
        beastStats[0] = 40;
        beastStats[1] = 45;
        beastStats[2] = 20;
        beastStats[3] = 34;
        beastStats[4] = (0);
        beastStats[5] = (0);
        beastStats[6] = (40);
        beastStats[11] = (32);
        beastStats[12] = (0);
    }
    public static void selectDemon(){
        beast = "Demon";
        capital = false;
        beastStats[0] = 35;
        beastStats[1] = 45;
        beastStats[2] = 35;
        beastStats[3] = 20;
        beastStats[4] = (0);
        beastStats[5] = (0);
        beastStats[6] = (30);
        beastStats[11] = (19);
        beastStats[12] = (0);
    }
    public static void selectCAngel(){
        beast = "Corrupted Angel";
        capital = true;
        beastStats[0] = 50;
        beastStats[1] = 50;
        beastStats[2] = 25;
        beastStats[3] = 25;
        beastStats[4] = (0);
        beastStats[5] = (0);
        beastStats[6] = (60);
        beastStats[11] = (19);
        beastStats[12] = (0);
    }
    public static void selectLich(){
        beast = "Lich";
        capital = false;
        beastStats[0] = 35;
        beastStats[1] = 30;
        beastStats[2] = 25;
        beastStats[3] = 25;
        beastStats[4] = (0);
        beastStats[5] = (100);
        beastStats[6] = (35);
        beastStats[11] = (16);
        beastStats[12] = (0);
    }
    public static void selectYaunTiMalison(){
        beast = "Yaun-Ti Malison";
        capital = false;
        beastStats[0] = 37;
        beastStats[1] = 25;
        beastStats[2] = 17;
        beastStats[3] = 40;
        beastStats[4] = (0);
        beastStats[5] = (100);
        beastStats[6] = (70);
        beastStats[11] = (19);
        beastStats[12] = (0);
    }
    public static void selectYaunTiAbonimation(){
        beast = "Yaun-Ti Abonimation";
        capital = false;
        beastStats[0] = 40;
        beastStats[1] = 19;
        beastStats[2] = 15;
        beastStats[3] = 30;
        beastStats[4] = (0);
        beastStats[5] = (100);
        beastStats[6] = (80);
        beastStats[11] = (23);
        beastStats[12] = (0);
    }
    public static void selectYaunTiHolyGuard(){
        beast = "Yaun-Ti Holy Guard";
        capital = false;
        beastStats[0] = 47;
        beastStats[1] = 24;
        beastStats[2] = 15;
        beastStats[3] = 30;
        beastStats[4] = (0);
        beastStats[5] = (100);
        beastStats[6] = (69);
        beastStats[11] = (28);
        beastStats[12] = (0);
    }
    public static void selectMerrshaulk(){
        beast = "Merrshaulk";
        capital = false;
        beastStats[0] = 60;
        beastStats[1] = 24;
        beastStats[2] = 15;
        beastStats[3] = 18;
        beastStats[4] = (0); //should make boss drop a cool item!
        beastStats[5] = (100);
        beastStats[6] = (40);
        beastStats[11] = (40);
        beastStats[12] = (0);
    }
    public static void selectMerrshaulkAbomination(){
        beast = "Merrshaulk Abomination";
        capital = false;
        beastStats[0] = 4;
        beastStats[1] = 9;
        beastStats[2] = 5;
        beastStats[3] = 70;
        beastStats[4] = (5);
        beastStats[5] = (100);
        beastStats[6] = (10);
        beastStats[11] = (5);
        beastStats[12] = (0);
    }
    public static void selectYaunTiPureBlood(){
        beast = "Yaun-Ti PureBlood";
        capital = false;
        beastStats[0] = 35;
        beastStats[1] = 25;
        beastStats[2] = 16;
        beastStats[3] = 30;
        beastStats[4] = (1);
        beastStats[5] = (15);
        beastStats[6] = (60);
        beastStats[11] = (16);
        beastStats[12] = (14);
    }
    public static void selectCthulu(){
        beast = "Cthulu";
        capital = false;
        beastStats[0] = 100;
        beastStats[1] = 100;
        beastStats[2] = 95;
        beastStats[3] = 10;
        beastStats[4] = (0);
        beastStats[5] = (100);
        beastStats[6] = (1);
        beastStats[11] = (30);
        beastStats[12] = (0);
    }
}
//        beastStats[0] = (health value);
//        beastStats[1] = (maxAttack value);
//        beastStats[2] = (minAttack value);
//        beastStats[3] = (accuracy value);
//        beastStats[4] = (item value);
//        beastStats[5] = (item drop rate %);
//        beastStats[6] = (speed value); (positive numbers. unmodded character speed is 60)
