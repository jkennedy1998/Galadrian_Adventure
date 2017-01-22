
public class monsterSelection {
    private static String beast;
    private static int beastStats[]= {0,0,0,0,0,0,0,1,1,1,1};
    private static boolean capital = false;
    private static int monsterCount = 0;


    public static int[] main (int round){
        if (round%10 == 0 ) {
            Story.refresh(adventurerework.attack1, adventurerework.attack2, adventurerework.attack3, adventurerework.attack4, adventurerework.itemSlot0, adventurerework.itemSlot1, adventurerework.itemSlot2, adventurerework.itemSlot3, adventurerework.itemSlot4);
            //that's the shortest line of code ever!
            Story.setDestination();
        }
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
//   standard variables:
//        beast = "rabid dog";
//        capital = false;
//        beastStats[0] = (health value);
//        beastStats[1] = (maxAttack value);
//        beastStats[2] = (minAttack value);
//        beastStats[3] = (accuracy value out of 100); (number needed by the equation accMod*(a number1-100) (lower numbers hit more)
//        beastStats[4] = (item value);
//        beastStats[5] = (item drop rate %);
//        beastStats[6] = (speed value); (positive numbers. unmodded character speed is 60)


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
                selectYaunTiMalison();
            else if (monsterNumber == 8)
                selectYaunTiPureBlood();
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
                selectDragon();
            else if (monsterNumber == 2)
                selectDemon();
            else if (monsterNumber == 3)
                selectCAngel();
            else
                selectLich();
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

    }
    public static void selectCultist(){
        beast = "Cultist";
        capital = false;
        beastStats[0] = 20;
        beastStats[1] = 20;
        beastStats[2] = 9;
        beastStats[3] = 35;
        beastStats[4] = (3);
        beastStats[5] = (90);
        beastStats[6] = (60);

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
    }
    public static void selectYaunTiMalison(){
        beast = "Yaun-Ti Malison";
        capital = false;
        beastStats[0] = 10;
        beastStats[1] = 15;
        beastStats[2] = 5;
        beastStats[3] = 25;
        beastStats[4] = (0);
        beastStats[5] = (100);
        beastStats[6] = (35);
    }
    public static void selectYaunTiAbonimation(){
        beast = "Yaun-Ti Abonimation";
        capital = false;
        beastStats[0] = 25;
        beastStats[1] = 25;
        beastStats[2] = 15;
        beastStats[3] = 35;
        beastStats[4] = (0);
        beastStats[5] = (100);
        beastStats[6] = (45);
    }
    public static void selectYaunTiPureBlood(){
        beast = "Yaun-Ti PureBlood";
        capital = false;
        beastStats[0] = 5;
        beastStats[1] = 15;
        beastStats[2] = 5;
        beastStats[3] = 50;
        beastStats[4] = (0);
        beastStats[5] = (100);
        beastStats[6] = (35);
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
    }
}
//        beastStats[0] = (health value);
//        beastStats[1] = (maxAttack value);
//        beastStats[2] = (minAttack value);
//        beastStats[3] = (accuracy value);
//        beastStats[4] = (item value);
//        beastStats[5] = (item drop rate %);
//        beastStats[6] = (speed value); (positive numbers. unmodded character speed is 60)
