/**
 * Created by jnebl on 12/22/2016.
 */
public class CharacterCreation {

    public static void create()
    {
        CharacterCreation.race();
        CharacterCreation.role();
    }
    public static void race()
    {
        int x = 0;
        int y = 0;
        do {
           if (y == 0)
               System.out.println("When given the option enter your desired race");
           else
               System.out.println("When given the option enter your desired race not some random shit like you apparently did");
           String races = "Your race options are Human, Elf, or Dwarf";
           String standard =" please enter the exact name of your desired race";
           System.out.println(races);
           String rac = IO.getString(standard);
           if (rac.equalsIgnoreCase("Dwarf")){
               x = 1;
           }
           else if (rac.equalsIgnoreCase("Elf")){
               x = 1;
           }
           else if (rac.equalsIgnoreCase("Human")){
               x = 1;
           }
           else{
               y = 1;
           }
        }while (x == 0);
    }
    public static void role()
    {

    }
}