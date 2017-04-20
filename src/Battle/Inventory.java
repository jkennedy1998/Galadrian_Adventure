package Battle;

import java.util.ArrayList;

/**
 * Created by citim on 4/10/2017.
 */
public class Inventory {
    private int carryCapacity;
    public ArrayList<String> items = new ArrayList<>();
    public ArrayList<Integer> itemUses = new ArrayList<>();
    public Inventory(){
        carryCapacity = (int)(adventurerework.character1.getAttackMultiplier()*adventurerework.character1.getDefensiveMultiplier()*25);
        items.add("torch");
        itemUses.add(Integer.parseInt(ItemDirectory.findItemValues("torch")[11]));
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
    public boolean hasItem(String itemName){
        for(int scan = 0; scan < items.size(); scan++){
            if(items.get(scan).equals(itemName))return true;
        }
        return false;
    }
    public boolean recieceItem(String itemName){//returns false if no items can be carries
        if(Integer.parseInt(ItemDirectory.findItemValues(itemName)[12])+getWeight() <= carryCapacity){
            items.add(itemName);
            itemUses.add(Integer.parseInt(ItemDirectory.findItemValues(itemName)[11]));

            adventurerework.window.print("you found a "+itemName+"!");
            return true;
        }
        adventurerework.window.print("The "+itemName+" was too heavy to carry.");
        adventurerework.window.print("You question the its importance over your current stash of items.");
        return false;
    }
    public void updateItemUse(int slot) {//for when you have used items

        itemUses.set(slot,itemUses.get(slot)-1);
        if(itemUses.get(slot) == 0){
            itemUses.remove(slot);
            adventurerework.window.print("the "+items.get(slot)+" has been destroyed in use!");
            items.remove(slot);
        }else{
            adventurerework.window.print("the "+items.get(slot)+" has "+itemUses.get(slot)+" more uses.");

        }

        }

    }

