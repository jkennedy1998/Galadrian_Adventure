package Battle;

public
class attackDatabase {

    //attackData contains min,max,accuracy

    private static int attackData[]= {0,0,0,0,0,0,0};
    private final static int emptyData[]= {0,0,0,0,0,0,0};
    public static int[] getAttackData(String attack) {
        if (attack.equalsIgnoreCase("Slash")) {slash();
            return attackData;}
        if (attack.equalsIgnoreCase("Stab")) {Stab();
            return attackData;}
        if (attack.equalsIgnoreCase("Shield Bash")) {ShieldBash();
            return attackData;}
        if (attack.equalsIgnoreCase("Bow Shot")) {BowShot();
            return attackData;}
        if (attack.equalsIgnoreCase("Dual Shot")) {DualShot();
            return attackData;}
        if (attack.equalsIgnoreCase("Shadow Bolt")) {ShadowBolt();
            return attackData;}
        if (attack.equalsIgnoreCase("Hex")) {Hex();
            return attackData;}
        if (attack.equalsIgnoreCase("Sparks")) {Sparks();
            return attackData;}
        if (attack.equalsIgnoreCase("Punch")) {Punch();
            return attackData;}
        if (attack.equalsIgnoreCase("Blood Lust")) {BloodLust();
            return attackData;}
        if (attack.equalsIgnoreCase("Rend")) {Rend();
            return attackData;}
        if (attack.equalsIgnoreCase("Meditation")) {Meditation();
            return attackData;}
        if (attack.equalsIgnoreCase("Flying Jump Kick")) {FlyingJumpKick();
            return attackData;}
        if (attack.equalsIgnoreCase("Bite")) {bite();
            return attackData;}
        if (attack.equalsIgnoreCase("Maul")) {maul();
            return attackData;}
        if (attack.equalsIgnoreCase("claw swipe")) {clawSwipe();
            return attackData;}
        if (attack.equalsIgnoreCase("tail sweep")) {tailSweep();
            return attackData;}
        if (attack.equalsIgnoreCase("bombard")) {bombard();
            return attackData;}
        if (attack.equalsIgnoreCase("fang peirce")) {fangPeirce();
            return attackData;}
        if (attack.equalsIgnoreCase("club")) {club();
            return attackData;}
        if (attack.equalsIgnoreCase("skull toss")) {skullToss();
            return attackData;}
        if (attack.equalsIgnoreCase("stoneToss")) {stoneToss();
            return attackData;}
        if (attack.equalsIgnoreCase("sting")) {sting();
            return attackData;}
        if (attack.equalsIgnoreCase("suffer")) {suffer();
            return attackData;}
        return emptyData;
    }
//      This is the formatting

//    public static void attackName(){
//        attackData[0] = min attack (int);
//        attackData[1] = max attack (int);
//        attackData[2] = accuracy (0 to 100); lower numbers hit more
//        attackData[3] = effect status calling number (0 as no status)      //comment which effect is changed if applicable
//        attackData[4] = effect status state (NA as 0, on self as 1, off self as 2, on enemy as 3, off enemy as 4)
//        attackData[5] = effect status calling number (0 as no status)      //comment which effect is changed if applicable (second effect)
//        attackData[6] = effect status state (NA as 0, on as 1, off as 2, on enemy as 3, off enemy as 4)9   (second effect)
//
    private static void instaKill(){ //for testing purposes only!
        attackData[0] = 100;
        attackData[1] = 100;
        attackData[2] = 0;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void ShieldBash(){ //certain mid damage, lacking accuracy
        attackData[0] = 20;
        attackData[1] = 25;
        attackData[2] = 35;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void Punch(){ //certain hit, lacking damage
        attackData[0] = 14;
        attackData[1] = 15;
        attackData[2] = 5;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void slash(){ //moderate hit, questionable damage
        attackData[0] = 5;
        attackData[1] = 30;
        attackData[2] = 28;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;

    }
    private static void BowShot(){ //questionable damage, decent accuracy
        attackData[0] = 25;
        attackData[1] = 27;
        attackData[2] = 10;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void DualShot(){ //certain moderate damage, certain accuracy
        attackData[0] = 37;
        attackData[1] = 41;
        attackData[2] = 100;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void Stab(){ //certain hit, low damage
        attackData[0] = 15;
        attackData[1] = 18;
        attackData[2] = 5;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void Hex(){ //ok accuracy, good damage
        attackData[0] = 25;
        attackData[1] = 32;
        attackData[2] = 45;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void ShadowBolt(){ //good accuracy, ok damage
        attackData[0] = 15;
        attackData[1] = 19;
        attackData[2] = 24;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void Sparks(){ //high damage, low accuracy
        attackData[0] = 30;
        attackData[1] = 35;
        attackData[2] = 70;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void BloodLust(){ //ok accuracy, high damage
        attackData[0] = 29;
        attackData[1] = 35;
        attackData[2] = 60;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void Rend() { //decent accuracy, uncertain damage damage
        attackData[0] = 15;
        attackData[1] = 29;
        attackData[2] = 36;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void Meditation() { //make this heal the user and always hit
        attackData[0] = 0;
        attackData[1] = 0;
        attackData[2] = 5;
        attackData[3] = 2; //meditation
        attackData[4] = 1;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void FlyingJumpKick() { //decent accuracy, certain damage
        attackData[0] = 19;
        attackData[1] = 20;
        attackData[2] = 40;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void bite(){ //certain hit, lacking damage
        attackData[0] = 14;
        attackData[1] = 15;
        attackData[2] = 5;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void maul(){ //certain hit, moderate damage
        attackData[0] = 15;
        attackData[1] = 25;
        attackData[2] = 7;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void clawSwipe(){ //moderate accuracy, moderate damage
        attackData[0] = 15;
        attackData[1] = 28;
        attackData[2] = 35;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void bombard(){ //eh accuracy, uncertain damage
        attackData[0] = 2;
        attackData[1] = 40;
        attackData[2] = 38;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void tailSweep(){ //lowish accuracy, eh damage
        attackData[0] = 15;
        attackData[1] = 23;
        attackData[2] = 45;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void fangPeirce(){ //good accuracy, moderate damage
        attackData[0] = 19;
        attackData[1] = 25;
        attackData[2] = 17;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void club(){ //moderate accuracy, moderate damage
        attackData[0] = 19;
        attackData[1] = 27;
        attackData[2] = 37;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void skullToss(){ //good accuracy, lacking damage, mildly funny
        attackData[0] = 14;
        attackData[1] = 15;
        attackData[2] = 20;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void stoneToss(){ //good accuracy, better damage, less funny
        attackData[0] = 21;
        attackData[1] = 27;
        attackData[2] = 20;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void sting(){ //moderate accuracy, moderate low damage
        attackData[0] = 14;
        attackData[1] = 27;
        attackData[2] = 30;
        attackData[3] = 0;
        attackData[4] = 0;
        attackData[5] = 0;
        attackData[6] = 0;
    }
    private static void suffer(){ //always missed. enemy does this only when we want it to. (like when mershauk is turned into an abomination)
        attackData[0] = 0;
        attackData[1] = 0;
        attackData[2] = 100;
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