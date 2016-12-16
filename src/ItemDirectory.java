/**
 * Created by Jared on 11/28/2016.
 */
public class ItemDirectory {

    public String ItemReturn[] = {"0", "0", "0", "0", "10", "0", "0", "0"};

    public String[] findItemValues(int itemNumber) {
        if (itemNumber == 0)
            return noItem();
        if (itemNumber == 1)
                return healthPotion();
        if (itemNumber == 2)
            return poison();

            return noItem(); //should NEVER return this from this line of code.
        }

        //past this point should only be data values for items

//use no item as a rubric.

        public String[] noItem () {
            ItemReturn[0] = "No Items";           //name
            ItemReturn[1] = "0";                  //self as 0 or enemy as 1
            ItemReturn[2] = "0";                  //health modifier
            ItemReturn[3] = "0";                  //attack modifier
            ItemReturn[4] = "0";                  //accuracy modifier
            ItemReturn[5] = "10";                 //accuracy
            ItemReturn[6] = "0";                  //effect # on
            ItemReturn[7] = "0";                  //effect # off

            return ItemReturn;
        }
        public String[] healthPotion () {
            ItemReturn[0] = "health potion";      //name
            ItemReturn[1] = "0";                  //self as 0 or enemy as 1
            ItemReturn[2] = "25";                 //health modifier
            ItemReturn[3] = "0";                  //attack modifier
            ItemReturn[4] = "0";                  //accuracy modifier
            ItemReturn[5] = "10";                 //accuracy
            ItemReturn[6] = "0";                  //effect # on
            ItemReturn[7] = "0";                  //effect # off

            return ItemReturn;
        }
    public String[] poison () {
        ItemReturn[0] = "Poison";           //name
        ItemReturn[1] = "1";                  //self as 0 or enemy as 1
        ItemReturn[2] = "-25";                  //health modifier
        ItemReturn[3] = "0";                  //attack modifier
        ItemReturn[4] = "0";                  //accuracy modifier
        ItemReturn[5] = "10";                 //accuracy
        ItemReturn[6] = "0";                  //effect # on
        ItemReturn[7] = "0";                  //effect # off

        return ItemReturn;
    }
    }

