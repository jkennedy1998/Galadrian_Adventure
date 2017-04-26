package Battle.ItemStuffs;
import Battle.*;

/**
 * Created by citim on 4/21/2017.
 */
public class EdibleItem extends Item {
    public int health, uses;
    public double attackMod, defenceMod, speedMod, accuracyMod;
    public String effect;

    public EdibleItem(int weight, String name,int cost, int health, int uses, double attackMod, double defenceMod, double speedMod, double accuracyMod, String effect) {
        super(weight, name, cost);
        this.health = health;
        this.uses = uses;
        this.attackMod = attackMod;
        this.defenceMod = defenceMod;
        this.speedMod = speedMod;
        this.accuracyMod = accuracyMod;
        this.effect = effect;
    }
    public void use() {
        adventurerework.character1.setHealth(health);
        uses--;
//        adventurerework.character1
//        make a timer for food items to work. can just do one item at a time. would limit player so he doesnt eat 500 carrots.
    }
}
