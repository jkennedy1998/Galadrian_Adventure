package cartography;

import javax.swing.*;

/**
 * Created by citim on 2/23/2017.
 */
public class NonWallsDatabase {

    public static NonWalls makeNonWall(int xPosition, int yPosition, int elevation, String wallType){

        NonWalls nonwall = new NonWalls(xPosition,yPosition,elevation,wallType);
        return nonwall;
    }
    public static boolean checkIfNonWall(Wall wall){
        if (wall.wallType.equalsIgnoreCase("stairs up")||
                wall.wallType.equalsIgnoreCase("stairs down")||
                wall.wallType.equalsIgnoreCase("sign"))return true;
        return false;
    }

    public static int findMovingLocation(Moving moving){
        for (int scan = 0; scan < CollisionProject.movings.size();scan++){
            if (CollisionProject.movings.get(scan).equals(moving)) return scan;
        }
        return -1;
    }
    public static void findInteraction(Moving moving, NonWalls current){
        if(current.wallType.equalsIgnoreCase("stairs up")) moving.elevation++;
        else if(current.wallType.equalsIgnoreCase("stairs down")) moving.elevation-= 1;
        else if(current.wallType.equalsIgnoreCase("sign") && moving.name.equals("player"))JOptionPane.showMessageDialog(null,current.description);

        else System.out.print("error: wallType isn't set to a legitimate type");
    }
}
