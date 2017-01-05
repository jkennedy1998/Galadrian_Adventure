import javax.swing.*;

public class Encounter {
    String attack1;
    String attack2;
    String attack3;
    String attack4;
    public int attackData[] = {0, 0, 0};
    public String attackChoice;
    double damageMult = 1;
    double accuracyMult = 1;
    String tempDialogStored = "";

    public void initialize(String a1, String a2, String a3, String a4) {
        attack1 = a1;
        attack2 = a2;
        attack3 = a3;
        attack4 = a4;

    }
    public String[] PlayerItem() {
        String ItemReturn[] = {"0", "0", "0", "0", "10", "0", "0", "0"};
        ItemDirectory directoryRefresh = new ItemDirectory();
        String Item1[] = directoryRefresh.findItemValues(adventurerework.itemSlot0);
        String item1 = Item1[0];
        String Item2[] = directoryRefresh.findItemValues(adventurerework.itemSlot1);
        String item2 = Item2[0];
        String Item3[] = directoryRefresh.findItemValues(adventurerework.itemSlot2);
        String item3 = Item3[0];
        String Item4[] = directoryRefresh.findItemValues(adventurerework.itemSlot3);
        String item4 = Item4[0];
        String Item5[] = directoryRefresh.findItemValues(adventurerework.itemSlot4);
        String item5 = Item5[0];

        String[] buttons = {item1, item2, item3, item4, item5};


        int choice = JOptionPane.showOptionDialog(null, "\nWhich item would you like to use?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);

        if (choice == 0) {

            ItemReturn = directoryRefresh.findItemValues(adventurerework.itemSlot0);
            adventurerework.itemSlot0=0;
        }
        else if (choice == 1) {
            ItemReturn = directoryRefresh.findItemValues(adventurerework.itemSlot1);
            adventurerework.itemSlot1=0;
        }
        else if (choice == 2) {
            ItemReturn = directoryRefresh.findItemValues(adventurerework.itemSlot2);
            adventurerework.itemSlot2=0;
        }
        else if (choice == 3) {
            ItemReturn = directoryRefresh.findItemValues(adventurerework.itemSlot3);
            adventurerework.itemSlot3=0;
        }
        else if (choice == 4) {
            ItemReturn = directoryRefresh.findItemValues(adventurerework.itemSlot4);
            adventurerework.itemSlot4=0;
        }

        else PlayerAttack(tempDialogStored);
        return ItemReturn;
    }

    public String PlayerAttack(String tempDialog) {
        tempDialogStored = tempDialog;
        String[] buttons = {attack1, attack2, attack3, attack4,"Items"};

        int choice = JOptionPane.showOptionDialog(null, tempDialog+"Which move would you like to use?\n", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);

        if (choice == 0) {
            attackData = attackDatabase.getAttackData(attack1);
            attackChoice = attack1;
        }
        else if (choice == 1) {
            attackData = attackDatabase.getAttackData(attack2);
            attackChoice = attack2;
        }
        else if (choice == 2) {
            attackData = attackDatabase.getAttackData(attack3);
            attackChoice = attack3;
        }
        else if (choice == 3) {
            attackData = attackDatabase.getAttackData(attack4);
            attackChoice = attack4;
        }else
           return "Item";

        return calculateHit(attackData[0], attackData[1], attackData[2]);

    }

    public String calculateHit(int min, int max, int acc) {
        if (Math.round(accuracyMult*acc) >= Math.round(Math.random() * 10)) {
            String randomNum = "" +Math.round(damageMult*(Math.random()*(max-min)+min));
            adventurerework.tempUserString = ("you "+attackChoice+" for "+randomNum+" damage!\n");
            return randomNum;
        }
        else {
            adventurerework.tempUserString = (attackChoice+" has missed!\n");
            return "Miss";
        }

    }
}