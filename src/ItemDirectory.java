
public class ItemDirectory {

    public String ItemReturn[] = {"0", "0", "0", "0", "0", "0", "0", "0","0","0"};

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
        if (itemNumber == 5)
            return unknownFlesh();
        if (itemNumber == 6)
            return  nail();
        if (itemNumber == 7)
            return  torch();

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
            ItemReturn[5] = "0";                  //defence modifier
            ItemReturn[6] = "0";                  //speed modifier
            ItemReturn[7] = "0";                 //accuracy
            ItemReturn[8] = "0";                  //effect # on
            ItemReturn[9] = "0";                  //effect # off

            return ItemReturn;
        }
        public String[] healthPotion () {
            ItemReturn[0] = "health potion";      //name
            ItemReturn[1] = "0";                  //self as 0 or enemy as 1
            ItemReturn[2] = "25";                 //health modifier
            ItemReturn[3] = "0";                  //attack modifier
            ItemReturn[4] = "0";                  //accuracy modifier
            ItemReturn[5] = "0";                  //defence modifier
            ItemReturn[6] = "0";                  //speed modifier
            ItemReturn[7] = "5";                 //accuracy
            ItemReturn[8] = "0";                  //effect # on
            ItemReturn[9] = "0";                  //effect # off

            return ItemReturn;
        }
    public String[] poison () {
        ItemReturn[0] = "Poison";           //name
        ItemReturn[1] = "1";                  //self as 0 or enemy as 1
        ItemReturn[2] = "-25";                  //health modifier
        ItemReturn[3] = "-.2";                  //attack modifier
        ItemReturn[4] = "0";                  //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = "-.1";                  //speed modifier
        ItemReturn[7] = "25";                 //accuracy
        ItemReturn[8] = "1";//poison                  //effect # on
        ItemReturn[9] = "0";                  //effect # off

        return ItemReturn;
    }
    public String[] curse (){
        ItemReturn[0] = "Curse";           //name
        ItemReturn[1] = "0";                  //self as 0 or enemy as 1
        ItemReturn[2] = "0";                  //health modifier
        ItemReturn[3] = ".5";                  //attack modifier
        ItemReturn[4] = "-.5";                  //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = "0";                  //speed modifier
        ItemReturn[7] = "32";                 //accuracy
        ItemReturn[8] = "0";                  //effect # on
        ItemReturn[9] = "0";                  //effect # off

        return ItemReturn;
    }
    public String[] mead () {
        ItemReturn[0] = "Mead";           //name
        ItemReturn[1] = "0";                  //self as 0 or enemy as 1
        ItemReturn[2] = "20";                  //health modifier
        ItemReturn[3] = ".3";                  //attack modifier
        ItemReturn[4] = "-.25";                  //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = "-.2";                  //speed modifier
        ItemReturn[7] = "13";                 //accuracy
        ItemReturn[8] = "0";                  //effect # on
        ItemReturn[9] = "0";                  //effect # off

        return ItemReturn;
    }
    public String[] unknownFlesh () {
        ItemReturn[0] = "Unknown Flesh";           //name
        ItemReturn[1] = "0";                  //self as 0 or enemy as 1
        ItemReturn[2] = "25";                  //health modifier
        ItemReturn[3] = "-.1";                  //attack modifier
        ItemReturn[4] = "-.1";                  //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = "0";                  //speed modifier
        ItemReturn[7] = "11";                 //accuracy
        ItemReturn[8] = "0";                  //effect # on
        ItemReturn[9] = "0";                  //effect # off

        return ItemReturn;
    }
    public String[] nail()
    {
        ItemReturn[0] = "Nail";          //name
        ItemReturn[1] = "0";                  //self as 0; enemy as 1
        ItemReturn[2] = "-10";                //health modifier
        ItemReturn[3] = ".2";                 //attack modifier
        ItemReturn[4] = ".3";                //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = ".1";                  //speed modifier
        ItemReturn[7] = "10";                //acc
        ItemReturn[8] = "0";                  //effects # on
        ItemReturn[9] = "0";                  // effects # off

        return ItemReturn;
    }
    public String[] torch () {
        ItemReturn[0] = "Torch";           //name
        ItemReturn[1] = "1";                  //self as 0 or enemy as 1
        ItemReturn[2] = "-13";                  //health modifier
        ItemReturn[3] = "0";                  //attack modifier
        ItemReturn[4] = "0";                  //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = "0";                  //speed modifier
        ItemReturn[7] = "50";                 //accuracy
        ItemReturn[8] = "3";                  //effect # on
        ItemReturn[9] = "0";                  //effect # off

        return ItemReturn;
    }
    }

