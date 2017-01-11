
public class effectDatabase {

    private static String[] effectData = {"","","","","","",""};

    public static String[] getAttackData(int effect) {
        if (effect == 0) { poison();
            return effectData;
        }
        if (effect == 1) { meditation();
            return effectData;
        }


        return null; //this is bad if this does this!
    }

//      past this point should only be effects!

//    public static void poison(){ //id number of the effect
//        effectData[0] = "Name of the effect to be displayed as a String";
//        effectData[1] = ""+(effected health each turn as an integer);
//        effectData[2] = ""+(turns in which the effect is in place as an integer);
//        effectData[3] = ""+(damage multiplier as a double.);
//        effectData[4] = ""+(speed multiplier as a double.);
//        effectData[5] = ""+(defence multiplier as a double.);
//        effectData[6] = ""+(accuracy multiplier as a double.);
//    }
    public static void poison(){ //1
        effectData[0] = "poison";
        effectData[1] = ""+(-3);
        effectData[2] = ""+(3);
        effectData[3] = ""+(1);
        effectData[4] = ""+(1);
        effectData[5] = ""+(1);
        effectData[6] = ""+(1);
    }
    public static void meditation(){ //2
        effectData[0] = "meditation";
        effectData[1] = ""+(+4);
        effectData[2] = ""+(2);
        effectData[3] = ""+(.5);
        effectData[4] = ""+(.5);
        effectData[5] = ""+(1);
        effectData[6] = ""+(1.2);
    }




}
