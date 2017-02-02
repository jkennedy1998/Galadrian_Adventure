import javax.swing.*;

public class Items {
    public int itemStorage[] = {0, 0, 0, 0, 0};
    public int itemUses[] = {1, 1, 1, 1, 1};

    public Items(int slot0, int slot1, int slot2, int slot3, int slot4) {
        itemStorage[0] = slot0;
        itemStorage[1] = slot1;
        itemStorage[2] = slot2;
        itemStorage[3] = slot3;
        itemStorage[4] = slot4;
        for (int x = 0; x < 5; x++) {
            itemUses[x] = Integer.parseInt(ItemDirectory.findItemValues(itemStorage[x])[11]);
        }
    }

    public void refresh(int slot0, int slot1, int slot2, int slot3, int slot4) {
        itemStorage[0] = slot0;
        itemStorage[1] = slot1;
        itemStorage[2] = slot2;
        itemStorage[3] = slot3;
        itemStorage[4] = slot4;

    }

    public String getItem(int itemValue) {
        if (ItemDirectory.findItemValues(itemValue)[1].equalsIgnoreCase("2")) {

            if (adventure.armor[Integer.parseInt(ItemDirectory.findItemValues(itemValue)[7])] == 0) {
                adventure.armor[Integer.parseInt(ItemDirectory.findItemValues(itemValue)[7])] = itemValue;
            } else {
                String[] buttons = {"replace armor", "keep old armor"};
                String prompt = ("You cannot equip the" + ItemDirectory.findItemValues(itemValue)[0] + " while already wearing the " + ItemDirectory.findItemValues(adventure.armor[Integer.parseInt(ItemDirectory.findItemValues(itemValue)[7])])[0]);
                int answer = JOptionPane.showOptionDialog(null, prompt, "",
                        JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
                if (answer == 0) {
                    adventure.armor[Integer.parseInt(ItemDirectory.findItemValues(itemValue)[7])] = itemValue;
                    System.out.println("You have replaced your old armor.");
                    return "";
                } else {
                    System.out.println("You have abandoned the newly found armor.");
                    return "";
                }
            }
        } else {


            int tempValue = receiveItem(itemValue);
            String[] itemTemp = ItemDirectory.findItemValues(itemValue);
            if (tempValue != 5) {
                if (tempValue == 0) {
                    itemStorage[0] = itemValue;
                    return ("\n" + itemTemp[0] + " has been stored!");
                }
                if (tempValue == 1) {
                    itemStorage[1] = itemValue;
                    return ("\n" + itemTemp[0] + " has been stored!");
                }
                if (tempValue == 2) {
                    itemStorage[2] = itemValue;
                    return ("\n" + itemTemp[0] + " has been stored!");
                }
                if (tempValue == 3) {
                    itemStorage[3] = itemValue;
                    return ("\n" + itemTemp[0] + " has been stored!");
                }
                if (tempValue == 4) {
                    itemStorage[4] = itemValue;
                    return ("\n" + itemTemp[0] + " has been stored!");
                }
            } else {
                String[] buttons = {"yes", "no"};
                String prompt = (itemTemp[0] + " has no available storage slot. Would you like to discard another item for it?");
                int answer = JOptionPane.showOptionDialog(null, prompt, "",
                        JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
                if (answer == 0) {
                    String slot1 = (ItemDirectory.findItemValues(itemStorage[0])[0]);
                    String slot2 = (ItemDirectory.findItemValues(itemStorage[1])[0]);
                    String slot3 = (ItemDirectory.findItemValues(itemStorage[2])[0]);
                    String slot4 = (ItemDirectory.findItemValues(itemStorage[3])[0]);
                    String slot5 = (ItemDirectory.findItemValues(itemStorage[4])[0]);

                    String[] moreButtons = {slot1, slot2, slot3, slot4, slot5};

                    int otherAnswer = JOptionPane.showOptionDialog(null, "Which item would you like to be replaced for the " + itemTemp[0] + "?", "",
                            JOptionPane.PLAIN_MESSAGE, 1, null, moreButtons, null);
                    for (int x = 0; x < 5; x++) {
                        if (otherAnswer == x) {
                            itemStorage[x] = itemValue;
                            System.out.println(itemTemp[0] + " has been stored in slot 1!");
                        }
                    }
                } else {
                    return ("You have chosen to discard the " + itemTemp[0] + ".");

                }
            }
        }
        return null;
    }

    public int receiveItem(int newItem) {
        for(int x = 0; x < 5; x++){
            if (itemStorage[x] == 0) {
                itemStorage[x] = newItem;
                itemUses[x] = Integer.parseInt(ItemDirectory.findItemValues(itemStorage[x])[11]);
                return x;
            }
        }
        return 5; //used as an exception if inventory is full
    }

    public void updateItemUse(int slot) {

        itemUses[slot]--;
        if (itemUses[slot] <= 0&&itemStorage[slot]!=0){
            System.out.println("Your "+ItemDirectory.findItemValues(itemStorage[slot])[0]+" has been depleted!");
            itemStorage[slot]= 0;
            itemUses[slot] = 1;
        }

    }
}


