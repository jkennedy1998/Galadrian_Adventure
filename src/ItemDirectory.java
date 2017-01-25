
public class ItemDirectory {

    public static String ItemReturn[] = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0","0"};

    public static String[] findItemValues(int itemNumber) {
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
        if (itemNumber == 8)
            return  peasantsBlouse();
        if (itemNumber == 9)
            return  peasantsRags();
        if (itemNumber == 10)
            return  spade();
        if (itemNumber == 11)
            return  forgottenChestPeice();
        if (itemNumber == 12)
            return  forgottenLegwear();
        if (itemNumber == 13)
            return  forgottenHelm();
        if (itemNumber == 14)
            return  forgottenGreives();
            return noItem(); //should NEVER return this from this line of code.
        }

        //past this point should only be data values for items and rubrics
        //here be items!
//public static String[] ItemName () {
//    ItemReturn[0] = "ItemName";           //name
//    ItemReturn[1] = "0";                  //self as 0 or enemy as 1
//    ItemReturn[2] = "0";                  //health modifier
//    ItemReturn[3] = "0";                  //attack modifier
//    ItemReturn[4] = "0";                  //accuracy modifier
//    ItemReturn[5] = "0";                  //defence modifier
//    ItemReturn[6] = "0";                  //speed modifier
//    ItemReturn[7] = "0";                 //accuracy
//    ItemReturn[8] = "0";                  //effect # on
//    ItemReturn[9] = "0";                  //effect # off
//    ItemReturn[10] = "0";                  //base price for shops
//    return ItemReturn;
//}


        public static String[] noItem () {
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
            ItemReturn[10] = "0";                  //base price for shops

            return ItemReturn;
        }
        public static String[] healthPotion () {
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
            ItemReturn[10] = "25";                  //base price for shops

            return ItemReturn;
        }
    public static String[] poison () {
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
        ItemReturn[10] = "20";                  //base price for shops

        return ItemReturn;
    }
    public static String[] curse (){
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
        ItemReturn[10] = "46";                  //base price for shops

        return ItemReturn;
    }
    public static String[] mead () {
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
        ItemReturn[10] = "10";                  //base price for shops

        return ItemReturn;
    }
    public static String[] unknownFlesh () {
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
        ItemReturn[10] = "13";                  //base price for shops

        return ItemReturn;
    }
    public static String[] nail()
    {
        ItemReturn[0] = "Nail";          //name
        ItemReturn[1] = "0";                  //self as 0 or enemy as 1
        ItemReturn[2] = "-10";                //health modifier
        ItemReturn[3] = ".2";                 //attack modifier
        ItemReturn[4] = ".3";                //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = ".1";                  //speed modifier
        ItemReturn[7] = "10";                //acc
        ItemReturn[8] = "0";                  //effects # on
        ItemReturn[9] = "0";                  // effects # off
        ItemReturn[10] = "5";                  //base price for shops

        return ItemReturn;
    }
    public static String[] torch () {
        ItemReturn[0] = "Torch";           //name
        ItemReturn[1] = "1";                 //self as 0 or enemy as 1
        ItemReturn[2] = "-13";                  //health modifier
        ItemReturn[3] = "0";                  //attack modifier
        ItemReturn[4] = "0";                  //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = "0";                  //speed modifier
        ItemReturn[7] = "50";                 //accuracy
        ItemReturn[8] = "3";                  //effect # on
        ItemReturn[9] = "0";                  //effect # off
        ItemReturn[10] = "42";                  //base price for shops

        return ItemReturn;
    }
    public static String[] spade () {
        ItemReturn[0] = "Spade";           //name
        ItemReturn[1] = "1";                 //self as 0 or enemy as 1
        ItemReturn[2] = "-7";                  //health modifier
        ItemReturn[3] = "0";                  //attack modifier
        ItemReturn[4] = "0";                  //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = "0";                  //speed modifier
        ItemReturn[7] = "50";                 //accuracy
        ItemReturn[8] = "0";                  //effect # on
        ItemReturn[9] = "0";                  //effect # off
        ItemReturn[10] = "49";                  //base price for shops

        return ItemReturn;
    }

//here be armor!
    //public static String[] EquiptableName () {
//    ItemReturn[0] = "ItemName";           //name
//    ItemReturn[1] = "2";                  //2 for id'ing an equipt without adding another directory
//    ItemReturn[2] = "0";                  //defence as a positive int. 0 is no defence.
//    ItemReturn[3] = "0";                  //attack modifier
//    ItemReturn[4] = "0";                  //accuracy modifier
//    ItemReturn[5] = "0";                  //defence modifier
//    ItemReturn[6] = "0";                  //speed modifier
//    ItemReturn[7] = "0";                 //Body part ID (0 head, 1 torso, 2 hands, 3 rings, 4 leggings, 5 boots
//    ItemReturn[8] = "0";                  //defence breaking point (idk about this)
//    ItemReturn[9] = "0";                  //effect deter (idk if i want this to be a thing. not implemented.)
//
//    return ItemReturn;
//}
    public static String[] peasantsBlouse () {
        ItemReturn[0] = "peasant's blouse";           //name
        ItemReturn[1] = "2";                  //2 for id'ing an equipt without adding another directory
        ItemReturn[2] = "2";                  //defence as a positive int. 0 is no defence. 15 is high end armor.
        ItemReturn[3] = "0";                  //attack modifier
        ItemReturn[4] = "0";                  //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = "0";                  //speed modifier
        ItemReturn[7] = "1";                 //Body part ID (0 head, 1 torso, 2 hands, 3 rings, 4 leggings, 5 boots
        ItemReturn[8] = "10";                  //defence breaking point (idk about this)
        ItemReturn[9] = "0";                  //effect deter (idk if i want this to be a thing. not implemented.)
        ItemReturn[10] = "26";                  //base price for shops

    return ItemReturn;
}
    public static String[] peasantsRags () {
        ItemReturn[0] = "peasant's rags";           //name
        ItemReturn[1] = "2";                  //2 for id'ing an equipt without adding another directory
        ItemReturn[2] = "2";                  //defence as a positive int. 0 is no defence. 15 is high end armor.
        ItemReturn[3] = "0";                  //attack modifier
        ItemReturn[4] = "0";                  //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = "0";                  //speed modifier
        ItemReturn[7] = "4";                 //Body part ID (0 head, 1 torso, 2 hands, 3 rings, 4 leggings, 5 boots
        ItemReturn[8] = "10";                  //defence breaking point (idk about this)
        ItemReturn[9] = "0";                  //effect deter (idk if i want this to be a thing. not implemented.)
        ItemReturn[10] = "28";                  //base price for shops

        return ItemReturn;
    }
    public static String[] forgottenChestPeice () {
        ItemReturn[0] = "forgotten chest piece";           //name
        ItemReturn[1] = "2";                  //2 for id'ing an equipt without adding another directory
        ItemReturn[2] = "5";                  //defence as a positive int. 0 is no defence. 15 is high end armor.
        ItemReturn[3] = "0";                  //attack modifier
        ItemReturn[4] = "0";                  //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = "-.05";                  //speed modifier
        ItemReturn[7] = "1";                 //Body part ID (0 head, 1 torso, 2 hands, 3 rings, 4 leggings, 5 boots
        ItemReturn[8] = "40";                  //defence breaking point (idk about this)
        ItemReturn[9] = "0";                  //effect deter (idk if i want this to be a thing. not implemented.)
        ItemReturn[10] = "70";                  //base price for shops

        return ItemReturn;
    }
    public static String[] forgottenLegwear () {
        ItemReturn[0] = "forgotten leg wear";           //name
        ItemReturn[1] = "2";                  //2 for id'ing an equipt without adding another directory
        ItemReturn[2] = "4";                  //defence as a positive int. 0 is no defence. 15 is high end armor.
        ItemReturn[3] = "0";                  //attack modifier
        ItemReturn[4] = "0";                  //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = "-.07";                  //speed modifier
        ItemReturn[7] = "4";                 //Body part ID (0 head, 1 torso, 2 hands, 3 rings, 4 leggings, 5 boots
        ItemReturn[8] = "40";                  //defence breaking point (idk about this)
        ItemReturn[9] = "0";                  //effect deter (idk if i want this to be a thing. not implemented.)
        ItemReturn[10] = "80";                  //base price for shops

        return ItemReturn;
    }
    public static String[] forgottenHelm () {
        ItemReturn[0] = "forgotten helm";           //name
        ItemReturn[1] = "2";                  //2 for id'ing an equipt without adding another directory
        ItemReturn[2] = "4";                  //defence as a positive int. 0 is no defence. 15 is high end armor.
        ItemReturn[3] = "0";                  //attack modifier
        ItemReturn[4] = "-.05";                  //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = "0";                  //speed modifier
        ItemReturn[7] = "0";                 //Body part ID (0 head, 1 torso, 2 hands, 3 rings, 4 leggings, 5 boots
        ItemReturn[8] = "37";                  //defence breaking point (idk about this)
        ItemReturn[9] = "0";                  //effect deter (idk if i want this to be a thing. not implemented.)
        ItemReturn[10] = "67";                  //base price for shops

        return ItemReturn;
    }
    public static String[] forgottenGreives () {
        ItemReturn[0] = "forgotten grieves";           //name
        ItemReturn[1] = "2";                  //2 for id'ing an equipt without adding another directory
        ItemReturn[2] = "3";                  //defence as a positive int. 0 is no defence. 15 is high end armor.
        ItemReturn[3] = "0";                  //attack modifier
        ItemReturn[4] = "0";                  //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = "-.07";                  //speed modifier
        ItemReturn[7] = "5";                 //Body part ID (0 head, 1 torso, 2 hands, 3 rings, 4 leggings, 5 boots
        ItemReturn[8] = "35";                  //defence breaking point (idk about this)
        ItemReturn[9] = "0";                  //effect deter (idk if i want this to be a thing. not implemented.)
        ItemReturn[10] = "72";                  //base price for shops

        return ItemReturn;
    }

    }

