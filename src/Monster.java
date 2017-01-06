
public class Monster {
    public int health;
    public int maxHit, minHit, accuracy;
    public int[] itemDrop = {0,0};
    public double accuracyMult = 1;
    public double damageMult  = 1;
    public double speed;
    public String name = "";
    public double speedMult = 1;

    public Monster(int h, int max, int min, int acc, int item, int dropRate, double spd)
    {
        health = h;
        maxHit = max;
        minHit = min;
        accuracy = acc;
        itemDrop[0] = item;
        itemDrop[1] = dropRate;
        speed = spd;



    }
    public int questionItem(){
        if (itemDrop[1] >= Math.round(Math.random() * 100)){
            return itemDrop[0];
        } else {
            return 0;
        }
    }

    public String calculateHit() {
        if (Math.round(accuracyMult*accuracy) >= Math.round(Math.random() * 10)) {
            String randomNum = "" +Math.round(damageMult*(Math.random()*(maxHit-minHit)+minHit));
            return randomNum;
        }
        else {
            return ("The beast has missed!");
        }

    }
    public int receiveHit(int hit){
        health -= hit;
        return health;
    }
    public boolean questionlife(){
        if (health > 0){
            return true;
        }
        else
            return false;
    }
//    public int calculateSpeed() {
//
//    }
}
