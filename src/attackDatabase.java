
public
class attackDatabase {

    //attackData contains min,max,accuracy

    private static int attackData[]= {0,0,0,0,0,0,0};
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

//    public static void attackName(){
//        attackData[0] = min attack (int);
//        attackData[1] = max attack (int);
//        attackData[2] = accuracy (0 to 10);
//        attackData[3] = effect status calling number (0 as no status)      //comment which effect is changed if applicable
//        attackData[4] = effect status state (NA as 0, on self as 1, off self as 2, on enemy as 3, off enemy as 4)
//        attackData[5] = effect status calling number (0 as no status)      //comment which effect is changed if applicable (second effect)
//        attackData[6] = effect status state (NA as 0, on as 1, off as 2, on enemy as 3, off enemy as 4)9   (second effect)
//
    private static void instaKill(){ //for testing purposes only!
        attackData[0] = 100;
        attackData[1] = 100;
        attackData[2] = 10;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void ShieldBash(){ //certain mid damage, lacking accuracy
        attackData[0] = 20;
        attackData[1] = 25;
        attackData[2] = 7;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void Punch(){ //certain hit, lacking damage
        attackData[0] = 14;
        attackData[1] = 15;
        attackData[2] = 10;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void slash(){ //moderate hit, questionable damage
        attackData[0] = 5;
        attackData[1] = 30;
        attackData[2] = 8;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;

    }
    private static void BowShot(){ //questionable damage, decent accuracy
        attackData[0] = 15;
        attackData[1] = 40;
        attackData[2] = 7;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void MarksmansShot(){ //certain moderate damage, certain accuracy
        attackData[0] = 25;
        attackData[1] = 27;
        attackData[2] = 8;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void Stab(){ //certain hit, low damage
        attackData[0] = 15;
        attackData[1] = 18;
        attackData[2] = 9;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void Hex(){ //ok accuracy, good damage
        attackData[0] = 25;
        attackData[1] = 32;
        attackData[2] = 6;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void ShadowBolt(){ //good accuracy, ok damage
        attackData[0] = 15;
        attackData[1] = 19;
        attackData[2] = 8;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void Sparks(){ //high damage, low accuracy
        attackData[0] = 30;
        attackData[1] = 35;
        attackData[2] = 5;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void BodySlam(){ //ok accuracy, high damage
        attackData[0] = 29;
        attackData[1] = 35;
        attackData[2] = 6;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void Club() { //decent accuracy, uncertain damage damage
        attackData[0] = 15;
        attackData[1] = 29;
        attackData[2] = 8;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void Meditation() { //make this heal the user and always hit
        attackData[0] = 0;
        attackData[1] = 0;
        attackData[2] = 10;
        attackData[3] = 2; //meditation
        attackData[4] = 1;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void Uppercut() { //decent accuracy, certain damage
        attackData[0] = 19;
        attackData[1] = 20;
        attackData[2] = 7;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
}
//        attackData[0] = min attack (int);
//        attackData[1] = max attack (int);
//        attackData[2] = accuracy (0 to 10);
//        attackData[3] = effect status calling number (0 as no status)      //comment which effect is changed if applicable
//        attackData[4] = effect status state (NA as 0, on self as 1, off self as 2, on enemy as 3, off enemy as 4)
//        attackData[5] = effect status calling number (0 as no status)      //comment which effect is changed if applicable (second effect)
//        attackData[6] = effect status state (NA as 0, on as 1, off as 2, on enemy as 3, off enemy as 4)9   (second effect)