/**
 * Created by citim on 1/19/2017.
 */
public class SideQuests {
    //attack = strength
    //accuracy = perception
    //defence = lore
    //speed = endurance
    // level = intelegence (might change to add an intelegence level. would correlate to magic dam)
    public static void selectSidequest(){
        int questType = 0; //0 is common, 1 is uncommon, 2 is rare
        {double temp = Math.random()*100;
        if (temp>90) questType = 2;
        else if (temp>70) questType = 1;
        else questType = 0;}

        if (questType == 0){//common
            int commonCount = 2;
            int temp = (int)Math.ceil(Math.random()*commonCount);
             if (temp==1) receiveHealthPotion();
             if (temp==2) receivePoison();
        }

        if (questType == 1){//uncommon
            int commonCount = 0;
            int temp = (int)Math.ceil(Math.random()*commonCount);

        }

        if (questType == 2){//rare
            int commonCount = 0;
            int temp = (int)Math.ceil(Math.random()*commonCount);

        }
    }
    //area for common quests.
    public static void receiveHealthPotion(){
        System.out.print("You find an unopened health potion in the cold hands of a late adventurer.");
        System.out.println(adventurerework.getItem(1));
    }
    public static void receivePoison(){
        System.out.print("You find an open bottle of poison in the cold hands of a late adventurer.");
        System.out.println(adventurerework.getItem(2));
    }

    //area for uncommon quests.

    //area for rare quests.

}
