package Battle.ItemStuffs;

/**
 * Created by citim on 4/21/2017.
 */
public abstract class EquiptableItem extends Item {
    public int accuracy, damage, speed, effectChance;
    String effect;

    public EquiptableItem(int weight, String name, int cost, int accuracy, int damage, int speed, String effect, int effectChance){
        super(weight,name,cost);
        this.accuracy = accuracy;
        this.damage = damage;
        this.speed = speed;
        this.effect = effect;
        this.effectChance = effectChance;
    }
    public abstract void use();
}
