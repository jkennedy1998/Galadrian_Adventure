package Battle.ItemStuffs;

import cartography.Map;

/**
 * Created by citim on 4/21/2017.
 */
public class MeleeWeapon extends EquiptableItem {
    public int durability;

    public MeleeWeapon(int weight, String name,int cost, int accuracy, int damage, int speed, int durability, String effect, int effectChance){
        super(weight,name,cost,accuracy,damage,speed,effect,effectChance);
        this.durability = durability;

    }
    public void use() {
        durability--;
        //make shoot a damage projectile that kills itself after a tick ammount
    }
}
