
public class Items{
    public int itemStorage[] = {0,0,0,0,0,0};

    public Items(int slot0, int slot1, int slot2, int slot3, int slot4) {
        itemStorage[0] = slot0;
        itemStorage[1] = slot1;
        itemStorage[2] = slot2;
        itemStorage[3] = slot3;
        itemStorage[4] = slot4;

    }
    public void refresh(int slot0, int slot1, int slot2, int slot3, int slot4) {
        itemStorage[0] = slot0;
        itemStorage[1] = slot1;
        itemStorage[2] = slot2;
        itemStorage[3] = slot3;
        itemStorage[4] = slot4;

    }

    public int receiveItem(int newItem){
        if (itemStorage[0] == 0) {itemStorage[0] = newItem; return 0;}
        if (itemStorage[1] == 0) {itemStorage[1] = newItem; return 1;}
        if (itemStorage[2] == 0) {itemStorage[2] = newItem; return 2;}
        if (itemStorage[3] == 0) {itemStorage[3] = newItem; return 3;}
        if (itemStorage[4] == 0) {itemStorage[4] = newItem; return 4;}

        return 5;
    }
    public String[] getItemValues(int slotValue){
        return ItemDirectory.findItemValues(slotValue);
    }

}
