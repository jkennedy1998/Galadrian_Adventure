
public class effectDatabase {

    private static String[] effectData = {"","","","","","",""};
    final static String[] blankSlate = {"0","0","0","0","0","0","0"};//just for returning 0 as an effect

    public static String[] getEffectData(int effect) {

        if (effect == 1) { poison();
            return effectData;
        }
        if (effect == 2) { meditation();
            return effectData;
        }
        if (effect == 0) {
            return blankSlate;
        }



        return blankSlate; //this is bad if this does this!
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
        effectData[3] = ""+(0);
        effectData[4] = ""+(0);
        effectData[5] = ""+(0);
        effectData[6] = ""+(0);
    }
    public static void meditation(){ //2
        effectData[0] = "meditation";
        effectData[1] = ""+(+4);
        effectData[2] = ""+(4);
        effectData[3] = ""+(-.5);
        effectData[4] = ""+(-.5);
        effectData[5] = ""+(0);
        effectData[6] = ""+(.2);
    }




}
