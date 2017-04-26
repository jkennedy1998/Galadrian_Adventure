package Battle.ItemStuffs;

public class ItemDatabase {


    public static Item makeItem(String itemName) {
        if (itemName.equals("")) return null;
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
        else if (itemName.equals("Mortum's Amulet")) return mortumsAmulet();
        else if (itemName.equals("wood axe")) return woodAxe();
        else if (itemName.equals("pick axe")) return pickAxe();


        System.out.println("error: ItemDatabase sent a invalid String. (" + itemName + ")");
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


    private static Item healthPotion() {
        return new EdibleItem(1, "health potion", 25, 25, 2, 0, 0, 0, 0, "");
    }

    private static Item poison() {
        return new EdibleItem(1, "poison", 20, -25, 1, -.2, 0, 0, -.1, "poison");
    }

    private static Item cursedTome() { return new MageWeapon(2, "cursed tome", 46, 80, -5, 40, "health", 10,"curse",10);}

    private static Item mead() {return new EdibleItem(2, "mead", 10, 15, 3, .3, -.25, 0, -.2, "drunk");}

    private static Item unknownFlesh () {return new EdibleItem(2, "unknown flesh", 13, 19, 2, -.1, 0, 0, -.1, "dizzy");}

    private static Item nail() { //think a big ass rail road nail
        return new MeleeWeapon(4, "spike", 5, 80, 15, 72, 23, "bleed", 25);
    }

    private static Item torch () {
        return new MeleeWeapon(6, "torch", 34, 90, 13, 68, 6, "burn", 60);
    }

    private static Item woodAxe () {return new MeleeWeapon(12,"wood axe",32,60,23,49,16,"bleed",60);}

    private static Item pickAxe () {return new MeleeWeapon(17,"pick axe",40,52,18,40,16,"bleed", 25);}

    private static Item spade () {return new MeleeWeapon(11,"spade",40,58,13,52,16,"stun", 5);}

    private static Item mortumsAmulet(){ return new MiscItem(1,"Mortum's amulet", 287,"");}  //boss item for merrshaulk.

////here be armor!

    private static Item peasantsBlouse(){ return new WearableItem(5,"peasant's blouse",26,1,2,10,5);}

    private static Item peasantsRags () { return new WearableItem(5,"peasant's rags",28,4,2,10,5);}

    private static Item forgottenChestPeice () {return new WearableItem(20,"forgotten chest peice",70,1,5,27,7);}

    private static Item forgottenLegwear () { return new WearableItem(13,"forgotten leg wear",80,4,7,27,7);}

    private static Item forgottenHelm () { return new WearableItem(7,"forgotten helm",67,0,4,27,7);}

    private static Item forgottenGreives () { return new WearableItem(10,"forgotten grieves",62,5,4,27,7);}

    }
