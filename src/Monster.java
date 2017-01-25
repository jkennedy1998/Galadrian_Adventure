
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
    public int questionItem(int item, int dropRate){
        itemDrop[0] = item;
        itemDrop[1] = dropRate;
        if (itemDrop[1] >= Math.round(Math.random() * 100)){
            return itemDrop[0];
        } else {
            return 0;
        }
    }

    public String calculateHit(int armor) { //armor of person he is attacking
        if (accuracy <= Math.round(Math.random() * 100 * accuracyMult)) {
            double temp = (damageMult*(Math.random()*(maxHit-minHit)+minHit))/3;
            if (armor<=100)
                temp += (temp * 2) - (temp * 2 * ((double)armor / 100));
            temp = Math.round(temp);
            String randomNum = "" + (int)temp;
            return randomNum;
        }
        else {
            return ("The beast has missed!");
        }

    }
}
