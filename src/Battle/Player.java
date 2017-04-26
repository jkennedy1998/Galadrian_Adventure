package Battle;

import Battle.ItemStuffs.*;

import javax.swing.*;

public class Player {
    String attack1;
    String attack2;
    String attack3;
    String attack4;
    public int attackData[] = {0, 0, 0, 0, 0, 0, 0};
    public String attackChoice;
    double damageMult = 1;
    double accuracyMult = 1;
    public void initialize(String a1, String a2, String a3, String a4, double damageMultiplier, double accuracyMultiplier) {
        attack1 = a1;
        attack2 = a2;
        attack3 = a3;
        attack4 = a4;
        damageMult = damageMultiplier;
        accuracyMult = accuracyMultiplier;

    }
    public Item PlayerItem() {
        Item ItemReturn;
        String[] buttons = new String[adventurerework.inventory.items.size()];
        for(int scan = 0; scan < adventurerework.inventory.items.size(); scan++) {
            buttons[scan] = adventurerework.inventory.items.get(scan).name;
        }
        adventurerework.window.makeButtons(buttons);
        adventurerework.window.drawButtons();
        int choice = -1;
        while(choice == -1){
            System.out.print("");
            choice = adventurerework.window.questionButtonClick();
        }
        adventurerework.window.voidButtons();
        ItemReturn = ItemDatabase.makeItem(adventurerework.inventory.items.get(choice).name);
        adventurerework.inventory.updateItemUse(ItemReturn);
        return ItemReturn;
    }

    public String[] PlayerAttack() {
        String[] buttons = {attack1, attack2, attack3, attack4,"Items"};
        String[] returningData = {"","","","",""};
        adventurerework.window.makeButtons(buttons);
        adventurerework.window.drawButtons();
        int choice = -1;
        while(choice == -1){
            System.out.print("");
            choice = adventurerework.window.questionButtonClick();
        }

        adventurerework.window.voidButtons();

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
        }else if (choice ==4&&adventurerework.inventory.items.size()!=0) {
            returningData[0] = "Item";
            return returningData;
        }
        else if(choice ==4 && adventurerework.inventory.items.size()==0){
            adventurerework.window.print("you have no items to use!");
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
            adventurerework.window.print(attackChoice+" has missed!\n");
            return "Miss";
        }
    }
}