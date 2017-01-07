
public class attackDatabase {

    //attackData contains min,max,accuracy

    public static int attackData[]= {0,0,0};
    public static void main(String args[]){ //nothing should be here or call to here
    }
    public static int[] getAttackData(String attack) {
        if (attack.equalsIgnoreCase("Slash")) {slash();
            return attackData;}
        if (attack.equalsIgnoreCase("Stab")) {Stab();
            return attackData;}
        if (attack.equalsIgnoreCase("Shield Bash")) {ShieldBash();
            return attackData;}
        if (attack.equalsIgnoreCase("Bow Shot")) {BowShot();
            return attackData;}
        if (attack.equalsIgnoreCase("Marksman's Shot")) {MarksmansShot();
            return attackData;}
        if (attack.equalsIgnoreCase("Shadow Bolt")) {ShadowBolt();
            return attackData;}
        if (attack.equalsIgnoreCase("Hex")) {Hex();
            return attackData;}
        if (attack.equalsIgnoreCase("Sparks")) {Sparks();
            return attackData;}
        if (attack.equalsIgnoreCase("Punch")) {Punch();
            return attackData;}
        if (attack.equalsIgnoreCase("Body Slam")) {BodySlam();
            return attackData;}
        if (attack.equalsIgnoreCase("Club")) {Club();
            return attackData;}
        if (attack.equalsIgnoreCase("Meditation")) {Meditation();
            return attackData;}
        if (attack.equalsIgnoreCase("Uppercut")) {Uppercut();
            return attackData;}
        if (attack.equalsIgnoreCase("")) {attackData[2] = 0;
            return attackData;}
        return attackData;
    }
//      This is the formatting
//    public static void slash(){
//        attackData[0] = min attack (int);
//        attackData[1] = max attack (int);
//        attackData[2] = accuracy (0 to 10);
//    }
    public static void instaKill(){ //for testing purposes only!
        attackData[0] = 100;
        attackData[1] = 100;
        attackData[2] = 10;
    }
    public static void ShieldBash(){ //certain mid damage, lacking accuracy
        attackData[0] = 20;
        attackData[1] = 25;
        attackData[2] = 7;
    }
    public static void Punch(){ //certain hit, lacking damage
        attackData[0] = 14;
        attackData[1] = 15;
        attackData[2] = 10;
    }
    public static void slash(){ //moderate hit, questionable damage
        attackData[0] = 5;
        attackData[1] = 30;
        attackData[2] = 8;
    }
    public static void BowShot(){ //questionable damage, decent accuracy
        attackData[0] = 15;
        attackData[1] = 40;
        attackData[2] = 7;
    }
    public static void MarksmansShot(){ //certain moderate damage, certain accuracy
        attackData[0] = 25;
        attackData[1] = 27;
        attackData[2] = 8;
    }
    public static void Stab(){ //certain hit, low damage
        attackData[0] = 15;
        attackData[1] = 18;
        attackData[2] = 9;
    }
    public static void Hex(){ //ok accuracy, good damage
        attackData[0] = 25;
        attackData[1] = 32;
        attackData[2] = 6;
    }
    public static void ShadowBolt(){ //good accuracy, ok damage
        attackData[0] = 15;
        attackData[1] = 19;
        attackData[2] = 8;
    }
    public static void Sparks(){ //high damage, low accuracy
        attackData[0] = 30;
        attackData[1] = 35;
        attackData[2] = 5;
    }
    public static void BodySlam(){ //ok accuracy, high damage
        attackData[0] = 29;
        attackData[1] = 35;
        attackData[2] = 6;
    }
    public static void Club() { //decent accuracy, uncertain damage damage
        attackData[0] = 15;
        attackData[1] = 29;
        attackData[2] = 8;
    }
    public static void Meditation() { //make this heal the user and always hit
        attackData[0] = 0;
        attackData[1] = 0;
        attackData[2] = 10;
    }
    public static void Uppercut() { //decent accuracy, certain damage
        attackData[0] = 19;
        attackData[1] = 25;
        attackData[2] = 7;
    }
}
//        attackData[0] = min attack (int);
//        attackData[1] = max attack (int);
//        attackData[2] = accuracy (0 to 10);