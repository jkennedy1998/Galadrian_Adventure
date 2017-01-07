
public class monsterSelection {
    public static String beast;
    public static int beastStats[]= {0,0,0,0,0,0,0};
    public static int grouping = 1;
    public static boolean capital = false;
    public static int monsterCount = 0;


    public static int[] main (int round){
        setGrouping(round);
        selection();
        // this makes it easier to correctly use "a" and "an"
        if(beast.equals("Rabid Dog"))
            System.out.println("\n\nYou have encountered a Rabid Dog!");
        if(beast.equals("Small Bat"))
            System.out.println("\n\nYou have encountered a Small Bat!");
        if(beast.equals("Goblin"))
            System.out.println("\n\nYou have encountered a Goblin!");
        if(beast.equals("Warlock"))
            System.out.println("\n\nYou have encountered a Warlock!");
        if(beast.equals("Skeleton"))
            System.out.println("\n\nYou have encountered a Skeleton!");
        if(beast.equals("Vampire"))
            System.out.println("\n\nYou have encountered a Vampire!");
        if(beast.equals("Cultist"))
            System.out.println("\n\nYou have encountered a Cultist!");
        if(beast.equals("Drunk Dwarf"))
            System.out.println("\n\nYou have encountered a Drunk Dwarf!");
        if(beast.equals("Spiderling"))
            System.out.println("\n\nYou have encountered a Spiderling!");
        if(beast.equals("Dragon"))
            System.out.println("\n\nYou have encountered a Dragon!");
        if(beast.equals("Demon"))
            System.out.println("\n\nYou have encountered a Demon!");
        if(beast.equals("Corrupted Angel"))
            System.out.println("\n\nYou have encountered a Corrupted Angel!");
        if(beast.equals("Lich"))
            System.out.println("\n\nYou have encountered a Lich!");

//        if (capital) {
//            System.out.println("\n\nYou have encountered a " + beast + "!");
//        } else{
//            System.out.println("\n\nYou have encountered an " + beast + "!");
//        }
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
//        beastStats[3] = (accuracy value);
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
        beastStats[3] = 8;
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
        beastStats[3] = 9;
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
        beastStats[3] = 5;
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
        beastStats[3] = 8;
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
        beastStats[3] = 8;
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
        beastStats[3] = 8;
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
        beastStats[3] = 8;
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
        beastStats[3] = 2;
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
        beastStats[3] = 7;
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
        beastStats[3] = 7;
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
        beastStats[3] = 8;
        beastStats[4] = (0);
        beastStats[5] = (99);
        beastStats[6] = (30);
    }
    public static void selectCAngel(){
        beast = "Corrupted Angel";
        capital = false;
        beastStats[0] = 50;
        beastStats[1] = 50;
        beastStats[2] = 25;
        beastStats[3] = 3;
        beastStats[4] = (0);
        beastStats[5] = (100);
        beastStats[6] = (50);
    }
    public static void selectLich(){
        beast = "Lich";
        capital = false;
        beastStats[0] = 35;
        beastStats[1] = 30;
        beastStats[2] = 25;
        beastStats[3] = 9;
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
