package cartography;
import javax.swing.*;
public class NonWallsDatabase {

    public static NonWalls makeNonWall(int xPosition, int yPosition, int elevation, String wallType){ //needs inclusion of nonwall if presets are not true for desired nonwall object

        NonWalls nonwall = new NonWalls(xPosition,yPosition,elevation,wallType);
        if(wallType.equals("sign")) nonwall.colidable = true;
        else if(wallType.equals("chest")) nonwall.colidable = true;
        else if(wallType.equals("closed door")) nonwall.colidable = true; //starts as a closed door
        else if(wallType.equals("dart trap")) { //needs to assighn a board to it after it is created.
            nonwall.colidable = true;
            nonwall.interactOnCollision = false;
        }

        return nonwall;
    }
    public static void findInteraction(Moving moving, NonWalls current){//needs every single nonwall object and aditional nonplayer colide if its a player based object
        if(current.wallType.equals("stairs up")) moving.elevation++;
        else if(current.wallType.equals("stairs down")) moving.elevation-= 1;
        else if(current.wallType.equals("open door"));
        else if(current.wallType.equals("closed door")){
            current.wallType = "open door";
            current.colidable = false;
            current.state = false;
        }
        else if(current.wallType.equals("pressure plate")){
            current.state = !current.state;
            current.checkState();
            current.link.checkState();
        }
        else if(current.wallType.equals("board door")) {
            moving.xPosition = current.link.xPosition;
            moving.yPosition = current.link.yPosition;
            moving.elevation = current.link.elevation;
            moving.board = current.link.board;
            current.board.removeMoving(moving);
            current.link.board.movings.add(moving);
        }
        else if (current.wallType.equals("item")&& moving.name.equals("player")){
            JOptionPane.showMessageDialog(null,"you picked up "+current.description+"!");
            current.board.removeNonwall(current);
        }
        else if(current.wallType.equals("dart trap")){
            Moving dart = new Moving(current.xPosition,current.yPosition, current.board, "projectile", false);
            current.board.movings.add(dart);
            if(current.facing == 0){ dart.behavior = "linear up";}
            else if(current.facing == 2){ dart.behavior = "linear down";}
            else if(current.facing == 1){ dart.behavior = "linear left";}
            else if(current.facing == 3){ dart.behavior = "linear right";}

        }
        else if (current.wallType.equals("item")&& !moving.name.equals("player"));//does nothing. this is when an enemy runs into an item
        else if(current.wallType.equals("sign") && moving.name.equals("player"))JOptionPane.showMessageDialog(null,current.description);
        else if (current.wallType.equals("sign") && !moving.name.equals("player"));//does nothing. this is when an enemy runs into a sign.
        else if(current.wallType.equals("chest") && moving.name.equals("player"))JOptionPane.showMessageDialog(null,current.description);
        else if (current.wallType.equals("chest") && !moving.name.equals("player"));//does nothing. this is when an enemy runs into a chest.
        else System.out.println("error: wallType isn't set to a legitimate type\nWalltype = ["+current.wallType+"]");
    }
}
