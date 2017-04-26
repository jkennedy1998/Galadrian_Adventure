package Battle.ItemStuffs;

/**
 * Created by citim on 4/21/2017.
 */
public abstract class Item {
    public int weight, cost;
    public String name;

    public Item(int weight, String name, int cost){
        this.weight = weight;
        this.name = name;
        this.cost = cost;
    }
    public abstract void use();


}
