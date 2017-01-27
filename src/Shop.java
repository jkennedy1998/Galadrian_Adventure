import javax.swing.*;

/**
 * Created by student5 on 1/20/17.
 */

public class Shop {

    private static int[] possibleItems = {0,0,0,0,0,0,0,0,0,0};
    private static int[] itemsSold = {0,0,0,0};
    private static int[] itemPrices = {0,0,0,0};

    public static void start() {
        getPossibleItems(); //also prints some text about the shop!
        setItemsSold();
        setPrices();
        boolean done= false;
        String[] buttons = {ItemDirectory.findItemValues(itemsSold[0])[0] + " for " + itemPrices[0], ItemDirectory.findItemValues(itemsSold[1])[0] + " for " + itemPrices[1], ItemDirectory.findItemValues(itemsSold[2])[0] + " for " + itemPrices[2], ItemDirectory.findItemValues(itemsSold[3])[0] + " for " + itemPrices[3],"Leave the shop."};
        do {
            int answer = JOptionPane.showOptionDialog(null, "Which items would you like to purchase?\nYou have "+adventurerework.coins+" coins.", "",
                    JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);

            if (answer == 0){
                if (!(buttons[0]).equals("Sold Out!")) {
                    if (adventurerework.coins >= itemPrices[0]) {
                        adventurerework.getItem(itemsSold[0]);
                        adventurerework.coins-=itemPrices[0];
                        buttons[0] = "Sold Out!";
                    } else System.out.println("You don't have the coins for that!");
                }else System.out.println("You have bought all of that stock!");
            }
            else if (answer == 1){
                if (!(buttons[1]).equals("Sold Out!")) {
                    if (adventurerework.coins >= itemPrices[1]) {
                        adventurerework.getItem(itemsSold[1]);
                        adventurerework.coins-=itemPrices[1];
                        buttons[1] = "Sold Out!";
                    } else System.out.println("You don't have the coins for that!");
                }else System.out.println("You have bought all of that stock!");
            }
            else if (answer == 2){
                if (!(buttons[2]).equals("Sold Out!")) {
                    if (adventurerework.coins >= itemPrices[2]) {
                        adventurerework.getItem(itemsSold[2]);
                        adventurerework.coins-=itemPrices[2];
                        buttons[2] = "Sold Out!";
                    } else System.out.println("You don't have the coins for that!");
                }else System.out.println("You have bought all of that stock!");
            }
            else if (answer == 3){
                if (!(buttons[3]).equals("Sold Out!")) {
                    if (adventurerework.coins >= itemPrices[3]) {
                        adventurerework.getItem(itemsSold[3]);
                        adventurerework.coins-=itemPrices[3];
                        buttons[3] = "Sold Out!";
                    } else System.out.println("You don't have the coins for that!");
                }else System.out.println("You have bought all of that stock!");
            }
            else if (answer == 4){
                done = true;
            }

        }while (!done);
    }
    private static void setItemsSold(){
        for(int slot=0;slot<4;slot++){
            int temp = possibleItems[(int)Math.round(Math.random()*10)];
            if (temp!=0)
                itemsSold[slot] = temp;
            else
                slot--;
        }
    }
    private static void getPossibleItems(){
        String location = Story.location;
        boolean changed = false;
        //this is a template!
//        if (location.equalsIgnoreCase("nameOfArea")){
//            possibleItems[0] = 0; //
//            possibleItems[1] = 0; //
//            possibleItems[2] = 0; //
//            possibleItems[3] = 0; //
//            possibleItems[4] = 0; //
//            possibleItems[5] = 0; //
//            possibleItems[6] = 0; //
//            possibleItems[7] = 0; //
//            possibleItems[8] = 0; //
//            possibleItems[9] = 0; //
//            System.out.println("some text about the shop.");
//            changed = true;
//        }
        if (location.equalsIgnoreCase("forest")){
            possibleItems[0] = 1; //health potion
            possibleItems[1] = 2; //poison
            possibleItems[2] = 1; //
            possibleItems[3] = 2; //
            possibleItems[4] = 1; //
            possibleItems[5] = 3; // curse
            possibleItems[6] = 7; // torch
            possibleItems[7] = 10; // spade
            possibleItems[8] = 0; //
            possibleItems[9] = 0; //
            System.out.println("You come across a small clearing in the forest. \nBrightly colored bottles and traveling equipment line the shelves.");
            changed = true;
        }
        if (location.equalsIgnoreCase("deepForest")){
            possibleItems[0] = 1; //health potion
            possibleItems[1] = 2; //poison
            possibleItems[2] = 2; //
            possibleItems[3] = 2; //
            possibleItems[4] = 3; // curse
            possibleItems[5] = 7; // torch
            possibleItems[6] = 7; //
            possibleItems[7] = 5; //unknown flesh
            possibleItems[8] = 0; //
            possibleItems[9] = 0; //
            System.out.println("Through the darkness you see the light of candles of candles and movement.\nAs you approach you are offered goods from a less than shady merchant.");
            changed = true;
        }
        if (location.equalsIgnoreCase("mountains")){
            possibleItems[0] = 1; //health potion
            possibleItems[1] = 4; //MEAD!
            possibleItems[2] = 4; //
            possibleItems[3] = 4; //
            possibleItems[4] = 4; //
            possibleItems[5] = 6; // nail
            possibleItems[6] = 7; // torch
            possibleItems[7] = 10; // spade
            possibleItems[8] = 10; //
            possibleItems[9] = 10; //
            System.out.println("The peak's slope levels off and you are hit with a potent smell of mead.\nDwarves and travelers offer you goods as you walk the mountain pass.");
            changed = true;
        }
        if (location.equalsIgnoreCase("plains")){
            possibleItems[0] = 1; //health potion
            possibleItems[1] = 1; //
            possibleItems[2] = 1; //
            possibleItems[3] = 6; //nail
            possibleItems[4] = 6; //
            possibleItems[5] = 10; //spade
            possibleItems[6] = 10; //
            possibleItems[7] = 4; //mead
            possibleItems[8] = 0; //
            possibleItems[9] = 0; //
            System.out.println("In the distance you see a small farmstead.\nYou are friendlily greeted by a muddy farm worker.");
            changed = true;
        }
        if (location.equalsIgnoreCase("cave")){
            possibleItems[0] = 1; //health potion
            possibleItems[1] = 2; //
            possibleItems[2] = 2; //
            possibleItems[3] = 2; //poison
            possibleItems[4] = 5; // unknown flesh
            possibleItems[5] = 5; //
            possibleItems[6] = 10; // spade
            possibleItems[7] = 4; // mead
            possibleItems[8] = 4; //
            possibleItems[9] = 0; //
            System.out.println("Sounds of laughter echho through the cave.\nAs you pass a corner you are presented with drunken dwarves and resting adventurers.\nThe host offers you their goods.");
            changed = true;
        }
        if (location.equalsIgnoreCase("jaggedCoastline")){
            possibleItems[0] = 1; //health potion
            possibleItems[1] = 1; //
            possibleItems[2] = 5; //unknown flesh
            possibleItems[3] = 5; //
            possibleItems[4] = 5; //
            possibleItems[5] = 4; // mead
            possibleItems[6] = 0; //
            possibleItems[7] = 0; //
            possibleItems[8] = 0; //
            possibleItems[9] = 0; //
            System.out.println("A tent appears on the horrizon.\nAs you approach a hermit presents you with goods out of the abode.");
            changed = true;
        }
                if (location.equalsIgnoreCase("Jungle")){
            possibleItems[0] = 1; //
            possibleItems[1] = 2; //
            possibleItems[2] = 2; //
            possibleItems[3] = 7; //
            possibleItems[4] = 4; //
            possibleItems[5] = 3; //
            possibleItems[6] = 1; //
            possibleItems[7] = 0; //
            possibleItems[8] = 0; //
            possibleItems[9] = 0; //
            System.out.println("Through the mass of foliage a trading post immerges.\nYou are greeted by an insect like creature and an ork.");
            changed = true;
        }
        if (location.equalsIgnoreCase("Yuan-ti Fortress")){
            possibleItems[0] = 1; //
            possibleItems[1] = 1; //
            possibleItems[2] = 2; //
            possibleItems[3] = 4; //
            possibleItems[4] = 4; //
            possibleItems[5] = 4; //
            possibleItems[6] = 3; //
            possibleItems[7] = 0; //
            possibleItems[8] = 0; //
            possibleItems[9] = 0; //
            System.out.println("A seemly relaxed human resides in the fortress. \nHe offers you his wares as you notice his slitted eyes blink friendlily");
            changed = true;
        }
        if (location.equalsIgnoreCase("Yuan-ti Dungeon")){
            possibleItems[0] = 1; //
            possibleItems[1] = 1; //
            possibleItems[2] = 2; //
            possibleItems[3] = 4; //
            possibleItems[4] = 4; //
            possibleItems[5] = 3; //
            possibleItems[6] = 11; //
            possibleItems[7] = 12; //
            possibleItems[8] = 13; //
            possibleItems[9] = 14; //
            System.out.println("A Yuan-ti half-blood shifts his slitted eyes to you. \nAggravated, he hisses \"Are you going to buy something or just sit there like all the other pure-bloods?\"");
            changed = true;
        }


        if(!changed){
            System.out.println("\nYou goof! you added an area without adding items to the shop in that area! learn how to code!\nYou didnt add "+location);
            System.exit(0);
        }
    }
    private static void setPrices(){
        for(int place = 0;place<4;place++){
            int item = itemsSold[place];
            int price = 0;
            price += Integer.parseInt(ItemDirectory.findItemValues(item)[10]);
            price += Math.round(price*(adventurerework.roundCount/10)); //every 10 rounds the price of an object increases by its base price.
            itemPrices[place] = price;
        }
    }

}
