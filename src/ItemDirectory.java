
public class ItemDirectory {

    public String ItemReturn[] = {"0", "0", "0", "0", "10", "0", "0", "0"};

    public String[] findItemValues(int itemNumber) {
        if (itemNumber == 0)
            return noItem();
        if (itemNumber == 1)
                return healthPotion();
        if (itemNumber == 2)
            return poison();
        if (itemNumber == 3)
            return curse();
        if (itemNumber == 4)
            return mead();

            return noItem(); //should NEVER return this from this line of code.
        }

        //past this point should only be data values for items

//use no item as a rubric.

        public String[] noItem () {
            ItemReturn[0] = "No Items";           //name
            ItemReturn[1] = "0";                  //self as 0 or enemy as 1
            ItemReturn[2] = "0";                  //health modifier
            ItemReturn[3] = "1";                  //attack modifier
            ItemReturn[4] = "1";                  //accuracy modifier
            ItemReturn[5] = "10";                 //accuracy
            ItemReturn[6] = "0";                  //effect # on
            ItemReturn[7] = "0";                  //effect # off

            return ItemReturn;
        }
        public String[] healthPotion () {
            ItemReturn[0] = "health potion";      //name
            ItemReturn[1] = "0";                  //self as 0 or enemy as 1
            ItemReturn[2] = "25";                 //health modifier
            ItemReturn[3] = "1";                  //attack modifier
            ItemReturn[4] = "1";                  //accuracy modifier
            ItemReturn[5] = "10";                 //accuracy
            ItemReturn[6] = "0";                  //effect # on
            ItemReturn[7] = "0";                  //effect # off

            return ItemReturn;
        }
    public String[] poison () {
        ItemReturn[0] = "Poison";           //name
        ItemReturn[1] = "1";                  //self as 0 or enemy as 1
        ItemReturn[2] = "-25";                  //health modifier
        ItemReturn[3] = "1";                  //attack modifier
        ItemReturn[4] = "1";                  //accuracy modifier
        ItemReturn[5] = "10";                 //accuracy
        ItemReturn[6] = "0";                  //effect # on
        ItemReturn[7] = "0";                  //effect # off

        return ItemReturn;
    }
    public String[] curse (){
        ItemReturn[0] = "Curse";           //name
        ItemReturn[1] = "1";                  //self as 0 or enemy as 1
        ItemReturn[2] = "-15";                  //health modifier
        ItemReturn[3] = "-.5";                  //attack modifier
        ItemReturn[4] = "-.8";                  //accuracy modifier
        ItemReturn[5] = "10";                 //accuracy
        ItemReturn[6] = "0";                  //effect # on
        ItemReturn[7] = "0";                  //effect # off

        return ItemReturn;
    }
    public String[] mead () {
        ItemReturn[0] = "Mead";           //name
        ItemReturn[1] = "0";                  //self as 0 or enemy as 1
        ItemReturn[2] = "20";                  //health modifier
        ItemReturn[3] = "1.5";                  //attack modifier
        ItemReturn[4] = "-.75";                  //accuracy modifier
        ItemReturn[5] = "10";                 //accuracy
        ItemReturn[6] = "0";                  //effect # on
        ItemReturn[7] = "0";                  //effect # off

        return ItemReturn;
    }
    }

