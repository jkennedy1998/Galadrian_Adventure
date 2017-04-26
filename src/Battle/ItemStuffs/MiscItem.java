package Battle.ItemStuffs;

/**
 * Created by citim on 4/21/2017.
 */
public class MiscItem extends Item {
    String description;

    public MiscItem(int weight, String name,int cost, String description){
        super(weight,name,cost);
        this.description = description;
    }

    public void use() {
        System.out.println("you used some misc item");
    }
}
