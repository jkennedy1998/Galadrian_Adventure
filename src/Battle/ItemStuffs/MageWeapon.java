package Battle.ItemStuffs;
import Battle.*;

public class MageWeapon extends EquiptableItem {
    public String resource;
    public int resourceQuantity;

    public MageWeapon(int weight, String name,int cost , int accuracy, int damage, int speed,String effect, int effectChance, String resource, int resourceQuantity){
        super(weight,name,cost,accuracy,damage,speed,effect,effectChance);
        this.resource = resource;
        this.resourceQuantity = resourceQuantity;
    }
    public void use(){
        if(resource.equals("health")){
            if(adventurerework.character1.getHealth()-resourceQuantity > 0) {
                adventurerework.character1.setHealth(-resourceQuantity);
                System.out.println("used magic item!");
            }
            else{
                System.out.println("didnt use magic item");
            }
        }
        System.out.println("error: magic item ("+name+") is set to an invalid resource type. ("+resource+")");
    }
}
