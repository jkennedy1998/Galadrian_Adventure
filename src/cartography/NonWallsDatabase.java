package cartography;
import javax.swing.*;
public class NonWallsDatabase {

    public static NonWalls makeNonWall(int xPosition, int yPosition, int elevation, String wallType){ //needs inclusion of nonwall if presets are not true for desired nonwall object

        NonWalls nonwall = new NonWalls(xPosition,yPosition,elevation,wallType);
        if(wallType.equalsIgnoreCase("sign")) nonwall.colidable = true;
        else if(wallType.equalsIgnoreCase("chest")) nonwall.colidable = true;
        else if(wallType.equalsIgnoreCase("closed door")) nonwall.colidable = true; //starts as a closed door

        return nonwall;
    }
    public static void findInteraction(Moving moving, NonWalls current){//needs every single nonwall object and aditional nonplayer colide if its a player based object
        if(current.wallType.equalsIgnoreCase("stairs up")) moving.elevation++;
        else if(current.wallType.equalsIgnoreCase("stairs down")) moving.elevation-= 1;
        else if(current.wallType.equalsIgnoreCase("open door"));
        else if(current.wallType.equalsIgnoreCase("closed door")){
            current.wallType = "open door";
            current.colidable = false;
        }
        else if(current.wallType.equalsIgnoreCase("board door")) {
            moving.xPosition = current.link.xPosition;
            moving.yPosition = current.link.yPosition;
            moving.elevation = current.link.elevation;
            moving.board = current.link.board;
            current.board.removeMoving(moving);
            current.link.board.movings.add(moving);
        }
        else if (current.wallType.equalsIgnoreCase("item")&& moving.name.equals("player")){
            JOptionPane.showMessageDialog(null,"you picked up "+current.description+"!");
            current.board.removeNonwall(current);
        }
        else if (current.wallType.equalsIgnoreCase("item")&& !moving.name.equals("player"));//does nothing. this is when an enemy runs into an item
        else if(current.wallType.equalsIgnoreCase("sign") && moving.name.equals("player"))JOptionPane.showMessageDialog(null,current.description);
        else if (current.wallType.equalsIgnoreCase("sign") && !moving.name.equals("player"));//does nothing. this is when an enemy runs into a sign.
        else if(current.wallType.equalsIgnoreCase("chest") && moving.name.equals("player"))JOptionPane.showMessageDialog(null,current.description);
        else if (current.wallType.equalsIgnoreCase("chest") && !moving.name.equals("player"));//does nothing. this is when an enemy runs into a chest.
        else System.out.println("error: wallType isn't set to a legitimate type\nWalltype = ["+current.wallType+"]");
    }
}
