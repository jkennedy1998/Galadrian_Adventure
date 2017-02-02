import javax.swing.*;

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

    public String getItem(int itemValue) {
        refresh(adventure.itemSlot0,adventure.itemSlot1,adventure.itemSlot2,adventure.itemSlot3,adventure.itemSlot4);
        if(ItemDirectory.findItemValues(itemValue)[1].equalsIgnoreCase("2")) {

            if (adventure.armor[Integer.parseInt(ItemDirectory.findItemValues(itemValue)[7])] == 0) {
                adventure.armor[Integer.parseInt(ItemDirectory.findItemValues(itemValue)[7])] = itemValue;
            } else {
                String[] buttons = {"replace armor", "keep old armor"};
                String prompt = ("You cannot equip the"+ItemDirectory.findItemValues(itemValue)[0]+ " while already wearing the "+ItemDirectory.findItemValues(adventure.armor[Integer.parseInt(ItemDirectory.findItemValues(itemValue)[7])])[0]);
                int answer = JOptionPane.showOptionDialog(null, prompt, "",
                        JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
                if (answer ==0){
                    adventure.armor[Integer.parseInt(ItemDirectory.findItemValues(itemValue)[7])] = itemValue;
                    System.out.println("You have replaced your old armor.");
                    return "";
                }else {
                    System.out.println("You have abandoned the newly found armor.");
                    return "";
                }
            }
        } else {


            int tempValue = receiveItem(itemValue);
            String[] itemTemp = getItemValues(itemValue);
            if (tempValue != 5) {
                if (tempValue == 0) {
                    itemStorage[0] = itemValue;
                    return ("\n" + itemTemp[0] + " has been stored in slot 1!");
                }
                if (tempValue == 1) {
                    itemStorage[1] = itemValue;
                    return ("\n" + itemTemp[0] + " has been stored in slot 2!");
                }
                if (tempValue == 2) {
                    itemStorage[2] = itemValue;
                    return ("\n" + itemTemp[0] + " has been stored in slot 3!");
                }
                if (tempValue == 3) {
                    itemStorage[3] = itemValue;
                    return ("\n" + itemTemp[0] + " has been stored in slot 4!");
                }
                if (tempValue == 4) {
                    itemStorage[4] = itemValue;
                    return ("\n" + itemTemp[0] + " has been stored in slot 5!");
                }
            } else {
                String[] buttons = {"yes", "no"};
                String prompt = (itemTemp[0] + " has no available storage slot. Would you like to discard another item for it?");
                int answer = JOptionPane.showOptionDialog(null, prompt, "",
                        JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
                if (answer == 0) {
                    String slot1 = (getItemValues(itemStorage[0])[0]);
                    String slot2 = (getItemValues(itemStorage[1])[0]);
                    String slot3 = (getItemValues(itemStorage[2])[0]);
                    String slot4 = (getItemValues(itemStorage[3])[0]);
                    String slot5 = (getItemValues(itemStorage[4])[0]);

                    String[] moreButtons = {slot1, slot2, slot3, slot4, slot5};

                    int otherAnswer = JOptionPane.showOptionDialog(null, "Which item would you like to be replaced for the "+itemTemp[0]+"?", "",
                            JOptionPane.PLAIN_MESSAGE, 1, null, moreButtons, null);
                    for(int x =0;x<5; x++){
                        if (otherAnswer == x) {
                            itemStorage[x] = itemValue;
                            System.out.println(itemTemp[0] + " has been stored in slot 1!");
                        }
                    }
                } else {
                    return ("You have chosen to discard the "+itemTemp[0]+".");

                }
            }
        }return null;
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
