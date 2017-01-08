/**
 * Created by Jared on 12/22/2016.
 */
public class beastNameGen {


    public static void main (String beastType){
        if (Math.ceil(Math.random())*2==1){
            adventurerework.tempBeastName = preName()+postName()+" the "+beastType;
        }else
            adventurerework.tempBeastName = fullName()+" the "+beastType;


    }



    public static String preName(){
        int precount = 4;
        int rand = (int)Math.ceil(Math.random()*precount);

        if (rand == 1){
            return "Elf";
        }
        if (rand == 2){
            return "Skull";
        }
        if (rand == 3){
            return "Ork";
        }
        if (rand == 4){
            return "Earth";
        }
        return "error";
    }


    public static String postName(){
        int postcount = 4;
        int rand = (int)Math.ceil(Math.random()*postcount);
        if (rand == 1){
            return "-Bane";
        }
        if (rand == 2){
            return "-Eater";
        }
        if (rand == 3){
            return "-Torturer";
        }
        if (rand == 4){
            return "-Killer";
        }
        return "error";
    }
    public static String fullName(){
        int fullCount = 8;
        int rand = (int)Math.ceil(Math.random()*fullCount);
        if (rand == 1){
            return "Ballgruff";
        }
        if (rand == 2){
            return "Endri";
        }
        if (rand == 3){
            return "Justin";
        }
        if (rand == 4){
            return "Jared";
        }
        if (rand == 5){
            return "Bob Brown";
        }
        if (rand == 6){
            return "Jonas";
        }
        if (rand == 7){
            return "Noah";
        }
        if (rand == 8){
            return "Skywalker";
        }
        return "error";
    }

}
