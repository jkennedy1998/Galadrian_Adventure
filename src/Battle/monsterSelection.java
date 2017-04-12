package Battle;

import java.util.Base64;

public class monsterSelection {
    private static String beast;
    private static String beastStats[] = {"", "", "", "", "", "", "", "1", "1", "1", "1", "", "", ""};
    private static boolean needsAnAn = false;
    private static int monsterCount = 0;
    private static int roundsHere = 0; //only used in locations with a set enemy

    //     Past this point should only contain beast selections.
//
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
    private static Object outOfTwo(Object first, Object second) {
        if (Math.ceil(Math.random()) * 2 == 1) {
            return first;
        } else
            return second;
    }

    public static String selection(cartography.Board board) {
        if (board.area.equals("forest")) {
            monsterCount = 9;
            int monsterNumber = subSelect();

            if (monsterNumber == 1)
                return "rabid dog";
            else if (monsterNumber == 2)
                return "cultist";
            else if (monsterNumber == 3)
                return "goblin";
            else if (monsterNumber == 4)
                return "warlock";
            else if (monsterNumber == 5)
                return "vampire";
            else if (monsterNumber == 6)
                return "spiderling";
            else if (monsterNumber == 7)
                return "yaun-ti malison";
            else if (monsterNumber == 8)
                return "yaun-ti pure blood";
            else
                return "small bat";
        }
        System.out.println("error: monster selection is sent an invalid area name: " + board.area);
        return null;
    }

    public static String[] fetchBeastStats(String name){

        adventurerework.window.print("You have encountered a " + name + "!");
        beastNameGen.assighnName(name);
        if(name.equals("rabid dog"))selectDog();
        else if(name.equals("lesser snake")) selectSmallSnake();
        else if(name.equals("large cat")) selectLargeCat();
        else if(name.equals("small bat")) selectBat();
        else if(name.equals("naga")) selectNaga();
        else if(name.equals("big bat")) selectBigBat();
        else if(name.equals("goblin")) selectGoblin();
        else if(name.equals("warlock")) selectWarlock();
        else if(name.equals("skeleton")) selectSkeleton();
        else if(name.equals("naga")) selectNaga();
        else if(name.equals("vampire")) selectVampire();
        else if(name.equals("cultist")) selectCultist();
        else if(name.equals("drunk dwarf")) selectDrunkDwarf();
        else if(name.equals("spiderling")) selectSpiderling();
        else if(name.equals("dragon")) selectDragon();
        else if(name.equals("lich")) selectLich();
        else if(name.equals("yaun-ti malison")) selectYaunTiMalison();
        else if(name.equals("yaun-ti abomination")) selectYaunTiAbonimation();
        else if(name.equals("yaun-ti holy guard")) selectYaunTiHolyGuard();
        else if(name.equals("merrshaulk")) selectMerrshaulk();
        else if(name.equals("merrshaulk abomination")) selectMerrshaulkAbomination();
        else if(name.equals("yaun-ti pure blood")) selectYaunTiPureBlood();
        else if(name.equals("mimic")) selectMimic();

        return beastStats;
    }
    private static int subSelect(){
        //here are the amount of monsters

        return (int)(Math.round(Math.random()*monsterCount));
    }

    public static void selectDog(){
        beast = "Rabid Dog";
        needsAnAn = false;
        beastStats[0] = ""+25;
        beastStats[1] = "bite";
        beastStats[2] = "maul";
        beastStats[3] = "bite";
        beastStats[4] = ""+("");
        beastStats[5] = ""+(0);
        beastStats[6] = ""+(60);
        beastStats[11] = ""+(7);
        beastStats[12] = ""+(0);
        beastStats[13] = (String) outOfTwo("follow","flee");



    }
    public static void selectMimic(){
        beast = "Mimic";
        needsAnAn = false;
        beastStats[0] = ""+40;
        beastStats[1] = "bite";
        beastStats[2] = "bite";
        beastStats[3] = "fang peirce";
        beastStats[4] = ""+("");
        beastStats[5] = ""+(0);
        beastStats[6] = ""+(70);
        beastStats[11] = ""+(7);
        beastStats[12] = ""+(0);
        beastStats[13] = "guard";


    }
    public static void selectSmallSnake(){
        beast = "Lesser Snake";
        needsAnAn = false;
        beastStats[0] = ""+25;
        beastStats[1] = "bite";
        beastStats[2] = "bite";
        beastStats[3] = "fang peirce";
        beastStats[4] = ""+("");
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
        beastStats[4] = ""+("");
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
        beastStats[4] = ""+("poison");
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
        beastStats[4] = ""+("");
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
        beastStats[4] = ""+("poison");
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
        beastStats[4] = ""+("torch");
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
        beastStats[4] = ""+(outOfTwo("health potion","curse"));
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
        beastStats[4] = ""+("spade");
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
        beastStats[4] = ""+("unknown flesh");
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
        beastStats[4] = ""+("curse");
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
        beastStats[4] = ""+(outOfTwo("mead","spade"));
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
        beastStats[4] = ""+("poison");
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
        beastStats[4] = ""+("");
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
        beastStats[4] = ""+("");
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
        beastStats[4] = ""+("");
        beastStats[5] = ""+(100);
        beastStats[6] = ""+(70);
        beastStats[11] = ""+(19);
        beastStats[12] = ""+(0);
        beastStats[13] = "follow";

    }
    public static void selectYaunTiAbonimation(){
        beast = "Yaun-Ti Abonination";
        needsAnAn = false;
        beastStats[0] = ""+40;
        beastStats[1] = "tail sweep";
        beastStats[2] = "fang peirce";
        beastStats[3] = "slash";
        beastStats[4] = ""+("");
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
        beastStats[4] = ""+("");
        beastStats[5] = ""+(100);
        beastStats[6] = ""+(69);
        beastStats[11] = ""+(28);
        beastStats[12] = ""+(0);
        beastStats[13] = "guard";

    }
    public static void selectMerrshaulk(){
        beast = "Merrshaulk";
        needsAnAn = false;
        beastStats[0] = ""+60;
        beastStats[1] = "tail sweep";
        beastStats[2] = "fang peirce";
        beastStats[3] = "hex";
        beastStats[4] = ""+(""); //should make boss drop a cool item!
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
        beastStats[4] = ""+("unknown flesh");
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
        beastStats[4] = ""+("health potion");
        beastStats[5] = ""+(15);
        beastStats[6] = ""+(60);
        beastStats[11] = ""+(16);
        beastStats[12] = ""+(14);
        beastStats[13] = "follow";

    }
}
//        beastStats[0] = (health value);
//        beastStats[1] = (maxAttack value);
//        beastStats[2] = (minAttack value);
//        beastStats[3] = (accuracy value);
//        beastStats[4] = (item value);
//        beastStats[5] = (item drop rate %);
//        beastStats[6] = (speed value); (positive numbers. unmodded character speed is 60)
