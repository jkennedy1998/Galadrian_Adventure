/**
 * Created by Jared on 11/28/2016.
 */
public class Items{
    public int itemStorage[] = {0,0,0,0};

    public void initializeItems(int slot0, int slot1, int slot2, int slot3) {
        itemStorage[0] = slot0;
        itemStorage[1] = slot1;
        itemStorage[2] = slot2;
        itemStorage[3] = slot3;
    }

    public int receiveItem(int newItem){
        if (itemStorage[0] == 0) {itemStorage[0] = newItem; return 0;}
        if (itemStorage[1] == 0) {itemStorage[1] = newItem; return 1;}
        if (itemStorage[2] == 0) {itemStorage[2] = newItem; return 2;}
        if (itemStorage[3] == 0) {itemStorage[3] = newItem; return 3;}
        return 4;
    }
    public String[] getItemValues(int slotValue){
        ItemDirectory refresh = new ItemDirectory();
        return refresh.findItemValues(slotValue);
    }

}
