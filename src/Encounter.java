import javax.swing.*;

public class Encounter {
    String attack1;
    String attack2;
    String attack3;
    String attack4;
    public int attackData[] = {0, 0, 0, 0, 0, 0, 0};
    public String attackChoice;
    double damageMult = 1;
    double accuracyMult = 1;
    String tempDialogStored = "";

    public void initialize(String a1, String a2, String a3, String a4, double damageMultiplier, double accuracyMultiplier) {
        attack1 = a1;
        attack2 = a2;
        attack3 = a3;
        attack4 = a4;
        damageMult = damageMultiplier;
        accuracyMult = accuracyMultiplier;

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

    public String[] PlayerAttack(String tempDialog) {
        tempDialogStored = tempDialog;
        String[] buttons = {attack1, attack2, attack3, attack4,"Items"};
        String[] returningData = {"","","","",""};

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
        }else {
            returningData[0] = "Item";
            return returningData;
        }

        returningData[0] = calculateHit(attackData[0], attackData[1], attackData[2]);
        returningData[1] = ""+(attackData[3]);
        returningData[2] = ""+(attackData[4]);
        returningData[3] = ""+(attackData[5]);
        returningData[4] = ""+(attackData[6]);
        return returningData;

    }

    public String calculateHit(int min, int max, int acc) {
        if (Math.round(acc) <= Math.round(Math.random() * 100*accuracyMult)) {
            String randomNum = "" +Math.round(damageMult*(Math.random()*(max-min)+min));
            if (Integer.parseInt(randomNum) > 0) {
                adventurerework.tempUserString = ("you " + attackChoice + " for " + randomNum + " damage!\n");
            }else
                adventurerework.tempUserString = ("you " + attackChoice + " with vigor!\n");
            return randomNum;
        }
        else {
            System.out.print(attackChoice+" has missed!\n");
            return "Miss";
        }
    }
}