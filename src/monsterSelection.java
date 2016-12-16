/**
 * Created by Jared on 10/18/2016.
 */


// make a pool of monsters to choose from based on the round
public class monsterSelection {
    public static String beast;
    public static int beastStats[]= {0,0,0,0,0,0};
    public static int grouping = 1;
    public static boolean capital = false;


    public static int[] main (int round){
        setGrouping(round);
        selection_1();
        if (capital) {
            System.out.println("You have encountered a " + beast + "!");
        } else{
            System.out.println("You have encountered an " + beast + "!");
        }
        return beastStats;
    }
    public static void setGrouping(int round){
        if (round>=10){              //make more groupings
            grouping=2;
        }
    }
    public static void selection_1(){
//   standard variables:
//        beast = "rabid dog";
//        capital = false;
//        beastStats[0] = (health value);
//        beastStats[1] = (maxAttack value);
//        beastStats[2] = (minAttack value);
//        beastStats[3] = (accuracy value);
//        beastStats[4] = (item value);
//        beastStats[5] = (item drop rate %);



        if (grouping == 1) {

            int monsterNumber = subSelect();
            if (monsterNumber == 1)
                selectDog();
            else if (monsterNumber == 2)
                selectBat();
            else if (monsterNumber == 3)
                selectGoblin();
            else if (monsterNumber == 4)
                selectWarlock();
            else if (monsterNumber == 5)
                selectVampire();
            else if (monsterNumber == 6)
                selectSkeleton();
            else if (monsterNumber == 7)
                selectCultist();
            else
                selectDrunkDwarf();
        }
    }
    public static int subSelect(){
        //here are the amount of monsters
        int monsterCount = 8;
        return (int)(Math.round(Math.random()*monsterCount));
    }

    // Past this point should only contain beast selections.

    public static void selectDog(){
        beast = "rabid dog";
        capital = false;
        beastStats[0] = 25;
        beastStats[1] = 15;
        beastStats[2] = 10;
        beastStats[3] = 8;
        beastStats[4] = (0);
        beastStats[5] = (100);
    }
    public static void selectBat(){
        beast = "small bat";
        capital = false;
        beastStats[0] = 20;
        beastStats[1] = 10;
        beastStats[2] = 5;
        beastStats[3] = 9;
        beastStats[4] = (2);
        beastStats[5] = (100);
    }

    public static void selectGoblin(){
        beast = "goblin";
        capital = false;
        beastStats[0] = 30;
        beastStats[1] = 20;
        beastStats[2] = 17;
        beastStats[3] = 3;
        beastStats[4] = (1);
        beastStats[5] = (100);
    }
    public static void selectWarlock(){
        beast = "Warlock";
        capital = false;
        beastStats[0] = 20;
        beastStats[1] = 40;
        beastStats[2] = 20;
        beastStats[3] = 8;
        beastStats[4] = (0);
        beastStats[5] = (100);
    }
    public static void selectSkeleton(){
        beast = "Skeleton";
        capital = false;
        beastStats[0] = 15;
        beastStats[1] = 12;
        beastStats[2] = 3;
        beastStats[3] = 8;
        beastStats[4] = (0);
        beastStats[5] = (100);
    }
    public static void selectVampire(){
        beast = "Vampire";
        capital = false;
        beastStats[0] = 50;
        beastStats[1] = 40;
        beastStats[2] = 35;
        beastStats[3] = 9;
        beastStats[4] = (0);
        beastStats[5] = (100);
    }
    public static void selectCultist(){
        beast = "Cultist";
        capital = false;
        beastStats[0] = 20;
        beastStats[1] = 12;
        beastStats[2] = 9;
        beastStats[3] = 8;
        beastStats[4] = (0);
        beastStats[5] = (100);
    }
    public static void selectDrunkDwarf(){
        beast = "Drunk Dwarf";
        capital = false;
        beastStats[0] = 35;
        beastStats[1] = 35;
        beastStats[2] = 30;
        beastStats[3] = 6;
        beastStats[4] = (0);
        beastStats[5] = (100);
    }
}
