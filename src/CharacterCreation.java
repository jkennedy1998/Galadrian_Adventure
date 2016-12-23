/**
 * Created by jnebl on 12/22/2016.
 */
public class CharacterCreation {


    public static String race()
    {
        int x = 0;
        int y = 0;
        String race = "";
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
               race = "Dwarf";
           }
           else if (rac.equalsIgnoreCase("Elf")){
               x = 1;
               race = "Elf";
           }
           else if (rac.equalsIgnoreCase("Human")){
               x = 1;
               race = "Human";
           }
           else{
               y = 1;
           }
        }while (x == 0);
        return race;
    }
    public static String role()
    {
        int x = 0;
        int y = 0;
        String role = "";
        do {
            if (y == 0)
                System.out.println("When given the option enter your desired class");
            else
                System.out.println("When given the option enter your desired class not some random shit like you apparently did");
            String roles = "Your class options are Warrior, Ranger, or Warlock";
            String standard =" please enter the exact name of your desired class";
            System.out.println(role);
            String rac = IO.getString(standard);
            if (rac.equalsIgnoreCase("Warrior")){
                x = 1;
                role = "Warrior";
            }
            else if (rac.equalsIgnoreCase("Ranger")){
                x = 1;
                role = "Ranger";
            }
            else if (rac.equalsIgnoreCase("Warlock")){
                x = 1;
                role = "Warlock";
            }
            else{
                y = 1;
            }
        }while (x == 0);
        return role;
    }
}