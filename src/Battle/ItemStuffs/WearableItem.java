package Battle.ItemStuffs;

/**
 * Created by citim on 4/21/2017.
 */
public class WearableItem extends Item {
    public int slot, armor, durability,damageRating;

    //use armor() should test its amor and durability and if armor is less than damage durrability--. if durability == 0 item is gone.
    public WearableItem(int weight, String name, int cost, int slot, int armor,int damageRating, int durability){
        super(weight,name,cost);
        this.slot = slot;
        this.armor = armor;
        this.damageRating = damageRating;
        this.durability = durability;
    }
    public void use(){
        System.out.println("why did you call use from an armor?");
    }
}
