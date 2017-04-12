package Battle;

public class Monster {
    private int health, dropRate;
    private String attack1, attack2, attack3;
    private String item;
    private double accuracyMult,defenceMult,damageMult,speedMult;
    private double speed;
    public String attack = "";

    public Monster(int h, String at1, String at2, String at3, String item, int dropRate, double spd, double daM,double spM, double acM, double deM)
    {
        health = h;
        attack1 = at1;
        attack2 = at2;
        attack3 = at3;
        this.item = item;
        this.dropRate = dropRate;
        speed = spd;
        damageMult = daM;
        speedMult = spM;
        accuracyMult = acM;
        defenceMult = deM;

    }
    public String questionItem(){
        if (dropRate >= Math.round(Math.random() * 100)){
            return item;
        } else {
            return "";
        }
    }

    public String calculateHit(int armor) { //armor of person he is attacking

            int tempA = (int) Math.round(Math.random() * 2);

            if (tempA == 0) attack = attack1;
            else if (tempA == 1) attack = attack2;
            else attack = attack3;



        int[] attackData = attackDatabase.getAttackData(attack);
        if (attackData[2] <= Math.round(Math.random() * 100 * accuracyMult)) {
            double temp = (damageMult*(Math.random()*(attackData[1]-attackData[0])+attackData[0]))/3;
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
