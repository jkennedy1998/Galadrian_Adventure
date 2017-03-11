package cartography;
import javax.swing.*;
public class NonWallsDatabase {

    public static NonWalls makeNonWall(int xPosition, int yPosition, int elevation, String wallType){

        NonWalls nonwall = new NonWalls(xPosition,yPosition,elevation,wallType);
        if(wallType.equalsIgnoreCase("sign")) nonwall.colidable = true;
        if(wallType.equalsIgnoreCase("chest")) nonwall.colidable = true;
        return nonwall;
    }
    public static boolean checkIfNonWall(Wall wall){
        if (wall.wallType.equalsIgnoreCase("stairs up")||
                wall.wallType.equalsIgnoreCase("stairs down")||
                wall.wallType.equalsIgnoreCase("chest")||   //description = item in chest
                wall.wallType.equalsIgnoreCase("board door")|| // description is whats on the sign
                wall.wallType.equalsIgnoreCase("sign") // description is whats on the sign

                )return true;
        return false;
    }
    public static void findInteraction(Moving moving, NonWalls current){
        if(current.wallType.equalsIgnoreCase("stairs up")) moving.elevation++;
        else if(current.wallType.equalsIgnoreCase("stairs down")) moving.elevation-= 1;
        else if(current.wallType.equalsIgnoreCase("board door")) {
            moving.xPosition = current.link.xPosition;
            moving.yPosition = current.link.yPosition;
            moving.elevation = current.link.elevation;
            moving.board = current.link.board;
            current.board.removeMoving(moving);
            current.link.board.movings.add(moving);

        }
        else if(current.wallType.equalsIgnoreCase("sign") && moving.name.equals("player"))JOptionPane.showMessageDialog(null,current.description);
        else if (current.wallType.equalsIgnoreCase("sign") && !moving.name.equals("player"));//does nothing. this is when an enemy runs into a sign.
        else if(current.wallType.equalsIgnoreCase("chest") && moving.name.equals("player"))JOptionPane.showMessageDialog(null,current.description);
        else if (current.wallType.equalsIgnoreCase("chest") && !moving.name.equals("player"));//does nothing. this is when an enemy runs into a chest.
        else System.out.println("error: wallType isn't set to a legitimate type\nWalltype = ["+current.wallType+"]");
    }
}
