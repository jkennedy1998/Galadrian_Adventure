package cartography; /**
 * Created by citim on 2/23/2017.
 */
public class NonWallsDatabase {

    public static NonWalls makeNonWall(int xPosition, int yPosition, int elevation, String wallType){

        NonWalls nonwall = new NonWalls(xPosition,yPosition,elevation,wallType);
        return nonwall;
    }
    public static boolean checkIfNonWall(Wall wall){
        if (wall.wallType.equalsIgnoreCase("stairs up")) return true;
        if (wall.wallType.equalsIgnoreCase("stairs down")) return true;
        return false;
    }

    public static int findMovingLocation(Moving moving){
        for (int scan = 0; scan < CollisionProject.movings.size();scan++){
            if (CollisionProject.movings.get(scan).equals(moving)) return scan;
        }
        return -1;
    }
    public static void findInteraction(Moving moving, String wallType){
        if(wallType.equalsIgnoreCase("stairs up")) moving.elevation++;
        else if(wallType.equalsIgnoreCase("stairs down")) moving.elevation-= 1;
        else System.out.print("error: wallType isn't set to a legitimate type");
    }
}
