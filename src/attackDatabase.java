
public class attackDatabase {

    //attackData contains min,max,accuracy

    public static int attackData[]= {0,0,0};
    public static void main(String args[]){ //nothing should be here or call to here
    }
    public static int[] getAttackData(String attack) {
        if (attack.equalsIgnoreCase("Slash")) {slash();
            return attackData;}
        if (attack.equalsIgnoreCase("One-Ton Punch")) {onetonpunch();
            return attackData;}
        if (attack.equalsIgnoreCase("Shield Batter")) {ShieldBatter();
            return attackData;}
        if (attack.equalsIgnoreCase("Perfect Shot")) {PerfectShot();
            return attackData;}
        if (attack.equalsIgnoreCase("QuadShot")) {QuadShot();
            return attackData;}
        if (attack.equalsIgnoreCase("Hidden Shank")) {HiddenShank();
            return attackData;}
        if (attack.equalsIgnoreCase("Hex")) {Hex();
            return attackData;}
        if (attack.equalsIgnoreCase("Dark Ones Blessing")) {DarkOnesBlessing();
            return attackData;}
        if (attack.equalsIgnoreCase("Pyro Assault")) {PyroAssault();
            return attackData;}
        if (attack.equalsIgnoreCase("SunSpot")) {SunSpot();
            return attackData;}
        if (attack.equalsIgnoreCase("MoonBeam")) {MoonBeam();
            return attackData;}
        if (attack.equalsIgnoreCase("ThunderWave")) {ThunderWave();
            return attackData;}
        if (attack.equalsIgnoreCase("Pure Rend")) {PureRend();
            return attackData;}
        if (attack.equalsIgnoreCase("Toxic Pierce")) {ToxicPierce();
            return attackData;}
        if (attack.equalsIgnoreCase("Explosive Pellets")) {ExplosivePellets();
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
    public static void ShieldBatter(){
        attackData[0] = 25;
        attackData[1] = 30;
        attackData[2] = 7;
    }
    public static void onetonpunch(){
        attackData[0] = 10;
        attackData[1] = 15;
        attackData[2] = 10;
    }
    public static void slash(){
        attackData[0] = 5;
        attackData[1] = 30;
        attackData[2] = 9;
    }
    public static void PerfectShot(){
        attackData[0] = 10;
        attackData[1] = 20;
        attackData[2] = 9;
    }
    public static void QuadShot(){
        attackData[0] = 35;
        attackData[1] = 40;
        attackData[2] = 4;
    }
    public static void HiddenShank(){
        attackData[0] = 5;
        attackData[1] = 10;
        attackData[2] = 9;
    }
    public static void Hex(){
        attackData[0] = 5;
        attackData[1] = 15;
        attackData[2] = 9;
    }
    public static void DarkOnesBlessing(){
        attackData[0] = 5;
        attackData[1] = 35;
        attackData[2] = 7;
    }
    public static void PyroAssault(){
        attackData[0] = 20;
        attackData[1] = 25;
        attackData[2] = 7;
    }
    public static void SunSpot() {
        attackData[0] = 20;
        attackData[1] = 25;
        attackData[2] = 8;
    }
    public static void MoonBeam() {
        attackData[0] = 5;
        attackData[1] = 15;
        attackData[2] = 9;
    }
    public static void ThunderWave() {
        attackData[0] = 20;
        attackData[1] = 30;
        attackData[2] = 7;
    }
    public static void PureRend() {
        attackData[0] = 25;
        attackData[1] = 30;
        attackData[2] = 6;
    }
    public static void ToxicPierce() {
        attackData[0] = 15;
        attackData[1] = 25;
        attackData[2] = 7;
    }
    public static void ExplosivePellets() {
        attackData[0] = 1;
        attackData[1] = 50;
        attackData[2] = 7;
    }
}
//        attackData[0] = min attack (int);
//        attackData[1] = max attack (int);
//        attackData[2] = accuracy (0 to 10);