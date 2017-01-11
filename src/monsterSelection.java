
public class monsterSelection {
    public static String beast;
    public static int beastStats[]= {0,0,0,0,0,0,0,1,1,1,1};
    public static int grouping = 1;
    public static boolean capital = false;
    public static int monsterCount = 0;


    public static int[] main (int round){
        setGrouping(round);
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
    public static void setGrouping(int round){
        if (round<30){
            grouping=3;
            //Mountain
        }
        if (round<20){
            grouping=2;
            //caves
        }
        if (round<10){
            grouping=1;
            //forest
        }

    }
    public static int outOfTwo(int first, int second){
        if (Math.ceil(Math.random())*2==1){
            return first;
        }else
            return second;
    }
    public static void selection(){
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


        if (grouping == 1) {
            monsterCount = 7;
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
            else
                selectBat();
        }
        if (grouping == 2) {

            monsterCount = 6;
            int monsterNumber = subSelect();
            monsterCount = 6;
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
            else
                selectGoblin();

        }
        if (grouping == 3) {

            monsterCount = 4;
            int monsterNumber = subSelect();
            monsterCount = 4;
            if (monsterNumber == 1)
                selectDragon();
            else if(monsterNumber == 2)
                selectDemon();
            else if(monsterNumber == 3)
                selectCAngel();
            else
                selectLich();

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
        beastStats[5] = (20);
        beastStats[6] = (70);

    }

    public static void selectGoblin(){
        beast = "Goblin";
        capital = false;
        beastStats[0] = 20;
        beastStats[1] = 20;
        beastStats[2] = 17;
        beastStats[3] = 50;
        beastStats[4] = (1);
        beastStats[5] = (30);
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
        beastStats[5] = (20);
        beastStats[6] = (56);

    }
    public static void selectSkeleton(){
        beast = "Skeleton";
        capital = false;
        beastStats[0] = 15;
        beastStats[1] = 12;
        beastStats[2] = 3;
        beastStats[3] = 35;
        beastStats[4] = (0);
        beastStats[5] = (0);
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
        beastStats[5] = (30);
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
        beastStats[4] = (4);
        beastStats[5] = (90);
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
        beastStats[5] = (100);
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
        beastStats[5] = (99);
        beastStats[6] = (30);
    }
    public static void selectCAngel(){
        beast = "Corrupted Angel";
        capital = true;
        beastStats[0] = 50;
        beastStats[1] = 50;
        beastStats[2] = 25;
        beastStats[3] = 78;
        beastStats[4] = (0);
        beastStats[5] = (100);
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
}
//        beastStats[0] = (health value);
//        beastStats[1] = (maxAttack value);
//        beastStats[2] = (minAttack value);
//        beastStats[3] = (accuracy value);
//        beastStats[4] = (item value);
//        beastStats[5] = (item drop rate %);
//        beastStats[6] = (speed value); (positive numbers. unmodded character speed is 60)
