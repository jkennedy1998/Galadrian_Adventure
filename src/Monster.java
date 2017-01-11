
public class Monster {
    public int health;
    public int maxHit, minHit, accuracy;
    public int[] itemDrop = {0,0};
    public double accuracyMult,defenceMult,damageMult,speedMult;
    public double speed;
    public String name = "";

    public Monster(int h, int max, int min, int acc, int item, int dropRate, double spd, double daM,double spM, double acM, double deM)
    {
        health = h;
        maxHit = max;
        minHit = min;
        accuracy = acc;
        itemDrop[0] = item;
        itemDrop[1] = dropRate;
        speed = spd;
        damageMult = daM;
        speedMult = spM;
        accuracyMult = acM;
        defenceMult = deM;

    }
    public int questionItem(){
        if (itemDrop[1] >= Math.round(Math.random() * 100)){
            return itemDrop[0];
        } else {
            return 0;
        }
    }

    public String calculateHit() {
        if (accuracy <= Math.round(Math.random() * 100 * accuracyMult)) {
            String randomNum = "" +Math.round(damageMult*(Math.random()*(maxHit-minHit)+minHit));
            return randomNum;
        }
        else {
            return ("The beast has missed!");
        }

    }
}
