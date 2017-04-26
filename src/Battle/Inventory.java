package Battle;

import java.util.ArrayList;

/**
 * Created by citim on 4/10/2017.
 */
import Battle.ItemStuffs.*;
public class Inventory {
    private int carryCapacity;
    public ArrayList<Item> items = new ArrayList<>();

    public Inventory() {
        carryCapacity = (int) (adventurerework.character1.getAttackMultiplier() * adventurerework.character1.getDefensiveMultiplier() * 25);
        items.add(ItemDatabase.makeItem("torch"));
    }

    public void refreshCapacity() {
        carryCapacity = (int) (adventurerework.character1.getAttackMultiplier() * adventurerework.character1.getDefensiveMultiplier() * 25);

    }

    private int getWeight() {
        int weight = 0;
        for (int scan = 0; scan < items.size(); scan++) {
            weight += items.get(scan).weight;
        }
        return weight;
    }

    public Item hasItem(String itemName) {
        for (int scan = 0; scan < items.size(); scan++) {
            if (items.get(scan).equals(itemName)) return items.get(scan);
        }
        return null;
    }

    public boolean recieceItem(String itemName) {//returns false if no items can be carries
        Item ItemObject = ItemDatabase.makeItem(itemName);
        if (ItemObject.weight + getWeight() <= carryCapacity) {
            adventurerework.window.print("you found a " + itemName + "!");
            return true;
        }
        adventurerework.window.print("The " + itemName + " was too heavy to carry.");
        adventurerework.window.print("You question the its importance over your current stash of items.");
        //make this question if you wawnt to swap some items out. or add it and add effect overencumbered.
        return false;
    }
    public void voidItem(Item itemInInventory){
        for(int scan = 0; scan < items.size(); scan++){
            if(items.get(scan)==itemInInventory) {
                items.remove(scan);
                break;
            }

        }
    }
    public void updateItemUse(Item itemUsed) {//for when you have used items

        itemUsed.use();
        }

    }

