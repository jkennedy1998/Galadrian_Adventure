
public class monsterSelection {
    private static String beast;
    private static String beastStats[]= {"","","","","","","","1","1","1","1","","",""};
    private static boolean needsAnAn = false;
    private static int monsterCount = 0;
    private static int roundsHere = 0; //only used in locations with a set enemy



    public static String[] main (int round){
        if (round%10 == 0 ) {
            roundsHere = 0;
            Story.refresh(adventurerework.character1.getAttack1(), adventurerework.character1.getAttack2(),
                    adventurerework.character1.getAttack3(), adventurerework.character1.getAttack4());
            //that's the shortest line of code ever!
            Story.setDestination();
        }
        roundsHere++;
        selection();
        if (needsAnAn) {
            System.out.println("\n\nYou have encountered an " + beast + "!");
        } else{
            System.out.println("\n\nYou have encountered a " + beast + "!");
        }

        for (int pointsToGive = round; pointsToGive>0; pointsToGive--){ //this scales monsters per how many
            int rand = (int)Math.ceil(Math.random()*4);
            if (rand == 1)  beastStats[7] ="" + (Double.parseDouble(beastStats[7])+.05);
            if (rand == 2)  beastStats[8] ="" + (Double.parseDouble(beastStats[8])+.05);
            if (rand == 3)  beastStats[9] ="" + (Double.parseDouble(beastStats[9])+.05);
            if (rand == 4)  beastStats[10] ="" + (Double.parseDouble(beastStats[10])+.05);
        }
        beastNameGen.assighnName(beast);
        return beastStats;
    }

    private static Object outOfTwo(Object first, Object second){
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
//        needsAnAn = false; //if the first letter is a vowel
//        beastStats[0] = (health value);
//        beastStats[1] = (attack 1 name);
//        beastStats[2] = (attack 1 name);
//        beastStats[3] = (attack 1 name);
//        beastStats[4] = (item value);
//        beastStats[5] = (item drop rate %);
//        beastStats[6] = (speed value); (positive numbers. not modded character speed is 60)
//        attack = (name of the enemies attack);
//    }
    public static void selectDog(){
        beast = "Rabid Dog";
        needsAnAn = false;
        beastStats[0] = ""+25;
        beastStats[1] = "bite";
        beastStats[2] = "maul";
        beastStats[3] = "bite";
        beastStats[4] = ""+(0);
        beastStats[5] = ""+(0);
        beastStats[6] = ""+(60);
        beastStats[11] = ""+(7);
        beastStats[12] = ""+(0);
        beastStats[13] = (String) outOfTwo("follow","flee");



    }
    public static void selectSmallSnake(){
        beast = "Lesser Snake";
        needsAnAn = false;
        beastStats[0] = ""+25;
        beastStats[1] = "bite";
        beastStats[2] = "bite";
        beastStats[3] = "fang peirce";
        beastStats[4] = ""+(0);
        beastStats[5] = ""+(0);
        beastStats[6] = ""+(70);
        beastStats[11] = ""+(7);
        beastStats[12] = ""+(0);
        beastStats[13] = "flee";


    }
    public static void selectLargeCat(){
        beast = "Large Cat";
        needsAnAn = false;
        beastStats[0] = ""+36;
        beastStats[1] = "fang peirce";
        beastStats[2] = "maul";
        beastStats[3] = "claw swipe";
        beastStats[4] = ""+(0);
        beastStats[5] = ""+(0);
        beastStats[6] = ""+(79);
        beastStats[11] = ""+(27);
        beastStats[12] = ""+(0);
        beastStats[13] = "follow";


    }
    public static void selectBat(){
        beast = "Small Bat";
        needsAnAn = false;
        beastStats[0] = ""+15;
        beastStats[1] = "bite";
        beastStats[2] = "bombard";
        beastStats[3] = "bite";
        beastStats[4] = ""+(2);
        beastStats[5] = ""+(30);
        beastStats[6] = ""+(70);
        beastStats[11] = ""+(5);
        beastStats[12] = ""+(0);
        beastStats[13] = (String) outOfTwo("follow","flee");


    }
    public static void selectNaga(){
        beast = "Naga";
        needsAnAn = false;
        beastStats[0] = ""+40;
        beastStats[1] = "claw swipe";
        beastStats[2] = "tail sweep";
        beastStats[3] = "bite";
        beastStats[4] = ""+(0);
        beastStats[5] = ""+(0);
        beastStats[6] = ""+(48);
        beastStats[11] = ""+(22);
        beastStats[12] = ""+(0);
        beastStats[13] = "follow";


    }
    public static void selectBigBat(){
        beast = "Large Bat";
        needsAnAn = false;
        beastStats[0] = ""+38;
        beastStats[1] = "bite";
        beastStats[2] = "bombard";
        beastStats[3] = "fang peirce";
        beastStats[4] = ""+(2);
        beastStats[5] = ""+(40);
        beastStats[6] = ""+(58);
        beastStats[11] = ""+(13);
        beastStats[12] = ""+(0);
        beastStats[13] = (String) outOfTwo("follow","wander");



    }

    public static void selectGoblin(){
        beast = "Goblin";
        needsAnAn = false;
        beastStats[0] = ""+20;
        beastStats[1] = "fang peirce";
        beastStats[2] = "club";
        beastStats[3] = "slash";
        beastStats[4] = ""+(7);
        beastStats[5] = ""+(50);
        beastStats[6] = ""+(55);
        beastStats[11] = ""+(15);
        beastStats[12] = ""+(7);
        beastStats[13] = "follow";


    }
    public static void selectWarlock(){
        beast = "Warlock";
        needsAnAn = false;
        beastStats[0] = ""+20;
        beastStats[1] = "hex";
        beastStats[2] = "sparks";
        beastStats[3] = "slash";
        beastStats[4] = ""+(outOfTwo(1,3));
        beastStats[5] = ""+(40);
        beastStats[6] = ""+(56);
        beastStats[11] = ""+(17);
        beastStats[12] = ""+(30);
        beastStats[13] = "follow";


    }
    public static void selectSkeleton(){
        beast = "Skeleton";
        needsAnAn = false;
        beastStats[0] = ""+15;
        beastStats[1] = "slash";
        beastStats[2] = "skull toss";
        beastStats[3] = "hex";
        beastStats[4] = ""+(10);
        beastStats[5] = ""+(20);
        beastStats[6] = ""+(45);
        beastStats[11] = ""+(17);
        beastStats[12] = ""+(10);
        beastStats[13] = "follow";


    }
    public static void selectVampire(){
        beast = "Vampire";
        needsAnAn = false;
        beastStats[0] = ""+40;
        beastStats[1] = "fang peirce";
        beastStats[2] = "slash";
        beastStats[3] = "blood lust";
        beastStats[4] = ""+(5);
        beastStats[5] = ""+(40);
        beastStats[6] = ""+(60);
        beastStats[11] = ""+(19);
        beastStats[12] = ""+(26);
        beastStats[13] = "follow";


    }
    public static void selectCultist(){
        beast = "Cultist";
        needsAnAn = false;
        beastStats[0] = ""+20;
        beastStats[1] = "hex";
        beastStats[2] = "slash";
        beastStats[3] = "bite";
        beastStats[4] = ""+(3);
        beastStats[5] = ""+(50);
        beastStats[6] = ""+(60);
        beastStats[11] = ""+(16);
        beastStats[12] = ""+(24);
        beastStats[13] = "follow";


    }
    public static void selectDrunkDwarf(){
        beast = "Drunk Dwarf";
        needsAnAn = false;
        beastStats[0] = ""+35;
        beastStats[1] = "bombard";
        beastStats[2] = "punch";
        beastStats[3] = "stone toss";
        beastStats[4] = ""+(outOfTwo(4,10));
        beastStats[5] = ""+(95);
        beastStats[6] = ""+(30);
        beastStats[11] = ""+(19);
        beastStats[12] = ""+(40);
        beastStats[13] = "wander";


    }
    public static void selectSpiderling() {
        beast = "Spiderling";
        needsAnAn = false;
        beastStats[0] = ""+10;
        beastStats[1] = "bite";
        beastStats[2] = "sting";
        beastStats[3] = "sting";
        beastStats[4] = ""+(2);
        beastStats[5] = ""+(70);
        beastStats[6] = ""+(67);
        beastStats[11] = ""+(7);
        beastStats[12] = ""+(0);
        beastStats[13] = (String) outOfTwo("follow","flee");


    }
    public static void selectDragon(){
        beast = "Dragon";
        needsAnAn = false;
        beastStats[0] = ""+40;
        beastStats[1] = "fang peirce";
        beastStats[2] = "tail sweep";
        beastStats[3] = "claw swipe";
        beastStats[4] = ""+(0);
        beastStats[5] = ""+(0);
        beastStats[6] = ""+(40);
        beastStats[11] = ""+(32);
        beastStats[12] = ""+(0);
        beastStats[13] = (String) outOfTwo("follow","wander");

    }
    public static void selectLich(){
        beast = "Lich";
        needsAnAn = false;
        beastStats[0] = ""+35;
        beastStats[1] = "bite";
        beastStats[2] = "bite";
        beastStats[3] = "bite";
        beastStats[4] = ""+(0);
        beastStats[5] = ""+(100);
        beastStats[6] = ""+(35);
        beastStats[11] = ""+(16);
        beastStats[12] = ""+(0);
        beastStats[13] = "follow";

    }
    public static void selectYaunTiMalison(){
        beast = "Yaun-Ti Malison";
        needsAnAn = false;
        beastStats[0] = ""+37;
        beastStats[1] = "bite";
        beastStats[2] = "fang peirce";
        beastStats[3] = "slash";
        beastStats[4] = ""+(0);
        beastStats[5] = ""+(100);
        beastStats[6] = ""+(70);
        beastStats[11] = ""+(19);
        beastStats[12] = ""+(0);
        beastStats[13] = "follow";

    }
    public static void selectYaunTiAbonimation(){
        beast = "Yaun-Ti Abonimation";
        needsAnAn = false;
        beastStats[0] = ""+40;
        beastStats[1] = "tail sweep";
        beastStats[2] = "fang peirce";
        beastStats[3] = "slash";
        beastStats[4] = ""+(0);
        beastStats[5] = ""+(100);
        beastStats[6] = ""+(80);
        beastStats[11] = ""+(23);
        beastStats[12] = ""+(0);
        beastStats[13] = "follow";

    }
    public static void selectYaunTiHolyGuard(){
        beast = "Yaun-Ti Holy Guard";
        needsAnAn = false;
        beastStats[0] = ""+47;
        beastStats[1] = "fang peirce";
        beastStats[2] = "tail sweep";
        beastStats[3] = "shield bash";
        beastStats[4] = ""+(0);
        beastStats[5] = ""+(100);
        beastStats[6] = ""+(69);
        beastStats[11] = ""+(28);
        beastStats[12] = ""+(0);
        beastStats[13] = "follow";

    }
    public static void selectMerrshaulk(){
        beast = "Merrshaulk";
        needsAnAn = false;
        beastStats[0] = ""+60;
        beastStats[1] = "tail sweep";
        beastStats[2] = "fang peirce";
        beastStats[3] = "hex";
        beastStats[4] = ""+(0); //should make boss drop a cool item!
        beastStats[5] = ""+(100);
        beastStats[6] = ""+(40);
        beastStats[11] = ""+(40);
        beastStats[12] = ""+(0);
        beastStats[13] = "stand";

    }
    public static void selectMerrshaulkAbomination(){
        beast = "Merrshaulk Abomination";
        needsAnAn = false;
        beastStats[0] = ""+4;
        beastStats[1] = "suffer";
        beastStats[2] = "suffer";
        beastStats[3] = "suffer";
        beastStats[4] = ""+(5);
        beastStats[5] = ""+(100);
        beastStats[6] = ""+(10);
        beastStats[11] = ""+(5);
        beastStats[12] = ""+(0);
        beastStats[13] = "stand";


    }
    public static void selectYaunTiPureBlood(){
        beast = "Yaun-Ti PureBlood";
        needsAnAn = false;
        beastStats[0] = ""+35;
        beastStats[1] = "bite";
        beastStats[2] = "slash";
        beastStats[3] = "punch";
        beastStats[4] = ""+(1);
        beastStats[5] = ""+(15);
        beastStats[6] = ""+(60);
        beastStats[11] = ""+(16);
        beastStats[12] = ""+(14);
        beastStats[13] = "follow";

    }
    public static void selectCthulu(){
        beast = "Cthulu";
        needsAnAn = false;
        beastStats[0] = ""+100;
        beastStats[1] = "hex";
        beastStats[2] = "shadow bolt";
        beastStats[3] = "bite";
        beastStats[4] = ""+(0);
        beastStats[5] = ""+(100);
        beastStats[6] = ""+(1);
        beastStats[11] = ""+(30);
        beastStats[12] = ""+(0);
        beastStats[13] = "stand";


    }


}
//        beastStats[0] = (health value);
//        beastStats[1] = (maxAttack value);
//        beastStats[2] = (minAttack value);
//        beastStats[3] = (accuracy value);
//        beastStats[4] = (item value);
//        beastStats[5] = (item drop rate %);
//        beastStats[6] = (speed value); (positive numbers. unmodded character speed is 60)
