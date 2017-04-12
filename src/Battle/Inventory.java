package Battle;

import java.util.ArrayList;

/**
 * Created by citim on 4/10/2017.
 */
public class Inventory {
    private int carryCapacity;
    public ArrayList<String> items = new ArrayList<>();
    public Inventory(){
        carryCapacity = (int)(adventurerework.character1.getAttackMultiplier()*adventurerework.character1.getDefensiveMultiplier()*25);
        items.add("torch");
    }
    public void refreshCapacity(){
        carryCapacity = (int)(adventurerework.character1.getAttackMultiplier()*adventurerework.character1.getDefensiveMultiplier()*25);

    }
    private int getWeight(){
        int weight = 0;
        for(int scan = 0; scan < items.size(); scan++){
            weight+= Integer.parseInt(ItemDirectory.findItemValues(items.get(scan))[12]);
        }
        return weight;
    }
    public boolean recieceItem(String itemName){//returns false if no items can be carries
        if(Integer.parseInt(ItemDirectory.findItemValues(itemName)[12])+getWeight() <= carryCapacity){
            items.add(itemName);
            adventurerework.window.print("you found a "+itemName+"!");
            return true;
        }
        return false;
    }
    public void updateItemUse(int slot) {//for when you have used items

        adventurerework.window.print("the "+items.get(slot)+" has been used up!");
        items.remove(slot);

        }

    }

