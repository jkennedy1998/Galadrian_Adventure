package Battle.ItemStuffs;
import Battle.*;
public class RangedWeapon extends EquiptableItem {
    public String ammo;

    public RangedWeapon(int weight, String name, int cost, int accuracy, int damage, int speed, String ammo,String effect,int effectChance){
        super(weight,name, cost,accuracy,damage,speed,effect,effectChance);
        this.ammo = ammo;
    }

    public void use() {
        if(adventurerework.inventory.hasItem(ammo)!=null){
            adventurerework.inventory.voidItem(adventurerework.inventory.hasItem(ammo));
            System.out.println("used ranged weapon");
        }
        else System.out.println("no ammo!");
    }
}
