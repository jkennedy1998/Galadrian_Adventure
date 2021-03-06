package Battle;

public class ItemDirectory {

    public static String ItemReturn[] = {"name", "0", "0", "0", "0", "0", "0", "0", "0", "0","0","1","0"};

    public static String[] findItemValues(String itemName) {
        if (itemName.equals("")) return noItem();
        else if (itemName.equals("health potion")) return healthPotion();
        else if (itemName.equals("poison")) return poison();
        else if (itemName.equals("cursed tome")) return cursedTome();
        else if (itemName.equals("mead")) return mead();
        else if (itemName.equals("unknown flesh")) return unknownFlesh();
        else if (itemName.equals("nail")) return nail();
        else if (itemName.equals("torch")) return torch();
        else if (itemName.equals("peasant's blouse")) return peasantsBlouse();
        else if (itemName.equals("peasant's rags")) return peasantsRags();
        else if (itemName.equals("spade")) return spade();
        else if (itemName.equals("forgotten chest piece")) return forgottenChestPeice();
        else if (itemName.equals("forgotten leg wear")) return forgottenLegwear();
        else if (itemName.equals("forgotten helm")) return forgottenHelm();
        else if (itemName.equals("forgotten grieves")) return forgottenGreives();
        else if (itemName.equals("Mortum's Amulet")) return forgottenHelm();
        else if (itemName.equals("wood axe")) return woodAxe();
        else if (itemName.equals("pick axe")) return woodAxe();



        System.out.println("error: ItemDirectory sent a invalid String. ("+itemName+")");
        return null;


    }

        //past this point should only be data values for items and rubrics
        //here be items!
//        public static String[] noItem () {
//            ItemReturn[0] = "no items";           //name
//            ItemReturn[1] = "0";                  //self as 0 or enemy as 1
//            ItemReturn[2] = "0";                  //health modifier
//            ItemReturn[3] = "0";                  //attack modifier
//            ItemReturn[4] = "0";                  //accuracy modifier
//            ItemReturn[5] = "0";                  //defence modifier
//            ItemReturn[6] = "0";                  //speed modifier
//            ItemReturn[7] = "0";                 //accuracy
//            ItemReturn[8] = "0";                  //effect # on
//            ItemReturn[9] = "0";                  //effect # off
//            ItemReturn[10] = "0";                  //base price for shops
//            ItemReturn[11] = "0";                  //number of uses before discard
//            ItemReturn[12] = "0";                  //weight (int pounds)
//
//
//
//            return ItemReturn;
//        }


        public static String[] noItem () {
            ItemReturn[0] = "no items";           //name
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
            ItemReturn[11] = "0";                  //number of uses before discard
            ItemReturn[12] = "0";                  //weight (int pounds)



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
            ItemReturn[11] = "2";                  //number of uses before discard (one time use is 1)
            ItemReturn[12] = "1";                  //weight (int grams)


            return ItemReturn;
        }
    public static String[] poison () {
        ItemReturn[0] = "poison";           //name
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
        ItemReturn[11] = "1";                  //number of uses before discard (one time use is 1)
        ItemReturn[12] = "1";                  //weight (int grams)

        return ItemReturn;
    }
    public static String[] cursedTome (){ //like a textbook sized book.
        ItemReturn[0] = "cursed tome";           //name
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
        ItemReturn[11] = "1";                  //number of uses before discard (one time use is 1)
        ItemReturn[12] = "2";                  //weight (int grams)


        return ItemReturn;
    }
    public static String[] mead () {
        ItemReturn[0] = "mead";           //name
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
        ItemReturn[11] = "3";                  //number of uses before discard (one time use is 1)
        ItemReturn[12] = "1";                  //weight (int grams)

        return ItemReturn;
    }
    public static String[] unknownFlesh () {
        ItemReturn[0] = "unknown flesh";           //name
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
        ItemReturn[11] = "1";                  //number of uses before discard (one time use is 1)
        ItemReturn[12] = "2";                  //weight (int grams)


        return ItemReturn;
    }
    public static String[] nail() //think a big ass rail road nail
    {
        ItemReturn[0] = "nail";          //name
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
        ItemReturn[11] = "1";                  //number of uses before discard (one time use is 1)
        ItemReturn[12] = "1";                  //weight (int grams)


        return ItemReturn;
    }
    public static String[] torch () {
        ItemReturn[0] = "torch";           //name
        ItemReturn[1] = "1";                 //self as 0 or enemy as 1
        ItemReturn[2] = "-13";                  //health modifier
        ItemReturn[3] = "0";                  //attack modifier
        ItemReturn[4] = "0";                  //accuracy modifier
        ItemReturn[5] = "0";                  //defence modifier
        ItemReturn[6] = "0";                  //speed modifier
        ItemReturn[7] = "50";                 //accuracy
        ItemReturn[8] = "3";                  //effect # on
        ItemReturn[9] = "0";                  //effect # off
        ItemReturn[10] = "34";                  //base price for shops
        ItemReturn[11] = "1";                  //number of uses before discard (one time use is 1)
        ItemReturn[12] = "4";                  //weight (int grams)


        return ItemReturn;
    }
    public static String[] woodAxe () {
        ItemReturn[0] = "wood axe";           //name
        ItemReturn[1] = "1";                 //self as 0 or enemy as 1
        ItemReturn[2] = "-23";                  //health modifier
        ItemReturn[3] = "0";                  //attack modifier
        ItemReturn[4] = "0";                  //accuracy modifier
        ItemReturn[5] = "-.2";                  //defence modifier
        ItemReturn[6] = "0";                  //speed modifier
        ItemReturn[7] = "60";                 //accuracy
        ItemReturn[8] = "0";                  //effect # on
        ItemReturn[9] = "0";                  //effect # off
        ItemReturn[10] = "32";                  //base price for shops
        ItemReturn[11] = "8";                  //number of uses before discard (one time use is 1)
        ItemReturn[12] = "12";                  //weight (int grams)


        return ItemReturn;
    }
    public static String[] pickAxe () {
        ItemReturn[0] = "wood axe";           //name
        ItemReturn[1] = "1";                 //self as 0 or enemy as 1
        ItemReturn[2] = "-18";                  //health modifier
        ItemReturn[3] = "0";                  //attack modifier
        ItemReturn[4] = "0";                  //accuracy modifier
        ItemReturn[5] = "-.3";                  //defence modifier
        ItemReturn[6] = "0";                  //speed modifier
        ItemReturn[7] = "52";                 //accuracy
        ItemReturn[8] = "0";                  //effect # on
        ItemReturn[9] = "0";                  //effect # off
        ItemReturn[10] = "40";                  //base price for shops
        ItemReturn[11] = "8";                  //number of uses before discard (one time use is 1)
        ItemReturn[12] = "17";                  //weight (int grams)


        return ItemReturn;
    }
    public static String[] spade () {
        ItemReturn[0] = "spade";           //name
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
        ItemReturn[11] = "1";                  //number of uses before discard (one time use is 1)
        ItemReturn[12] = "10";                  //weight (int grams)


        return ItemReturn;
    }
    public static String[] mortumsAmulet () { //boss item for merrshaulk.
        ItemReturn[0] = "Mortum's amulet";           //name
        ItemReturn[1] = "1";                  //self as 0 or enemy as 1
        ItemReturn[2] = "0";                  //health modifier
        ItemReturn[3] = "-.5";                  //attack modifier
        ItemReturn[4] = "0";                  //accuracy modifier
        ItemReturn[5] = "-.5";                  //defence modifier
        ItemReturn[6] = "-.5";                  //speed modifier
        ItemReturn[7] = "90";                 //accuracy
        ItemReturn[8] = "0";                  //effect # on
        ItemReturn[9] = "0";                  //effect # off
        ItemReturn[10] = "200";                  //base price for shops
        ItemReturn[11] = "1";                  //number of uses before discard (one time use is 1)
        ItemReturn[12] = "1";                  //weight (int grams)


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
//    ItemReturn[10] = "26";                  //base price for shops
//    ItemReturn[12] = "5";                  //weight (int grams)

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
        ItemReturn[12] = "5";                  //weight (int grams)


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
        ItemReturn[12] = "5";                  //weight (int grams)


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
        ItemReturn[12] = "20";                  //weight (int grams)


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
        ItemReturn[12] = "13";                  //weight (int grams)


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
        ItemReturn[12] = "7";                  //weight (int grams)


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
        ItemReturn[12] = "10";                  //weight (int grams)


        return ItemReturn;
    }

    }

