import javax.swing.*;

public class Story {
    public static String location = "Forest";
    private static String possibleDestination1;
    private static String possibleDestination2;
    private static String attack1, attack2, attack3, attack4;
    private static String race = "";
    private static String role = "";

    public static void initialize(String a1, String a2, String a3, String a4){ //should only be used once!
        attack1 = a1;
        attack2 = a2;
        attack3 = a3;
        attack4 = a4;
        race = adventure.character1.getRace();
        role = adventure.character1.getRole();


    }

    public static void refresh(String a1, String a2, String a3, String a4){ //should be used before each area change!
        attack1 = a1;
        attack2 = a2;
        attack3 = a3;
        attack4 = a4;
    }
    public static void setDestination(){
        questionPossible();
        String[] buttons = {possibleDestination1, possibleDestination2,"turn back and continue exploring the "+location+"."};
        int answer = JOptionPane.showOptionDialog(null, "You reach the end of the "+location+".\nWhere would you like to go next?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        if (answer == 0&&questionRequirements(possibleDestination1)) {
            System.out.println("\nYou have entered the "+possibleDestination1+"!");
            location = possibleDestination1;
        } else if (answer == 1&&questionRequirements(possibleDestination2)) {
            location = possibleDestination2;
            System.out.println("\nYou have entered the "+possibleDestination2+"!");
        } else if (answer == 2){
            System.out.println("\nYou have chosen to continue exploring the "+location+"!");
            //location will stay the same regardless of if the requirements are fulfilled.
        } else {
            setDestination();
        }
    }
    public static void questionPossible(){
        //possible areas include:

        //forest
        //deepForest
        //mountains
        //plains
        //cave
        //jaggedCoastline
        //JUNGLE
        // Yuan-ti Fortress
        // Yuan-ti Dungeon

        //needs to have a method  for each area! will not work otherwise
        if (location.equalsIgnoreCase("forest")){
            possibleDestination1 ="deepForest";
            possibleDestination2 = outOf2("Plains","Jungle");
        }
        if (location.equalsIgnoreCase("Jungle")){
            possibleDestination1 ="Yuan-ti Fortress";
            possibleDestination2 = "forest";
        }
        if (location.equalsIgnoreCase("Yuan-ti Fortress")){
            possibleDestination1 ="Yuan-ti Dungeon";
            possibleDestination2 = "Jungle";
        }
        if (location.equalsIgnoreCase("Yuan-ti Dungeon")){
            possibleDestination1 ="Yuan-ti Fortress";
            possibleDestination2 = "Jungle";
        }
        if (location.equalsIgnoreCase("deepForest")){
            possibleDestination1 ="forest";
            possibleDestination2 = outOf2("cave","mountains");
        }
        if (location.equalsIgnoreCase("mountains")){
            possibleDestination1 ="jaggedCoastline";
            possibleDestination2 = outOf2("cave","forest");
        }
        if (location.equalsIgnoreCase("plains")){
            possibleDestination1 ="forest";
            possibleDestination2 = outOf2("jaggedCoastline","Mountains");
        }
        if (location.equalsIgnoreCase("cave")){
            possibleDestination1 ="forest";
            possibleDestination2 = outOf2("deepForest","Mountains");
        }
        if (location.equalsIgnoreCase("jaggedCoastline")){
            possibleDestination1 ="forest";
            possibleDestination2 = "Mountains";
        }


    }
    public static boolean questionRequirements(String location){
        if (location.equalsIgnoreCase("deepForest")&&(!(questionItem(7)&&!questionAttack("Sparks")))) {
            System.out.println("You need a light source to enter the deeps of the forest!");
            return false;}
        if (location.equalsIgnoreCase("cave")&&(!(questionItem(7)&&!questionAttack("Sparks")))) {
            System.out.println("Without a light source a cave is an adventurers death sentence!");
            return false;}
        return true;
    }
    public static boolean questionItem(int itemNumber){
        if (adventure.inventory.itemStorage[0]==itemNumber
                ||adventure.inventory.itemStorage[1] ==itemNumber
                || adventure.inventory.itemStorage[2] == itemNumber
                || adventure.inventory.itemStorage[3] == itemNumber
                || adventure.inventory.itemStorage[4] ==itemNumber)
            return true;
        return false;
    }
    public static boolean questionAttack(String attackNumber){
        if (attack1.equalsIgnoreCase(attackNumber)||attack2.equalsIgnoreCase(attackNumber) || attack3.equalsIgnoreCase(attackNumber)|| attack4.equalsIgnoreCase(attackNumber))
            return true;
        return false;
    }
    public static String outOf2(String first, String second){
        if (Math.ceil(Math.random())*2==1){
            return first;
        }else
            return second;
    }

}
