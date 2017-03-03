package cartography; /**
 * Created by citim on 2/23/2017.
 */
public class NonWalls extends Wall {
    boolean colidable = false, interactOnCollision = true;
    String description = "";
public NonWalls (int xPosition, int yPosition, int elevation, String wallType) {
    super(xPosition,yPosition, elevation,wallType);
}
public NonWalls(NonWalls nonWalls){
    super(nonWalls.xPosition, nonWalls.yPosition, nonWalls.elevation, nonWalls.wallType);
}
public void interact(Moving moving){
    if (interactOnCollision&&!colidable&&xPosition == moving.xPosition && yPosition == moving.yPosition&& elevation == moving.elevation) {  //for if you need to walk on the object to interact with it
        NonWallsDatabase.findInteraction(moving, this);
    }
    if (interactOnCollision&&colidable&&xPosition == moving.xPosition && yPosition == moving.yPosition&& elevation == moving.elevation){//for if you need to bump into the object to interact with it
        moving.xPosition = moving.lastPosition[0];
        moving.yPosition = moving.lastPosition[1];
        NonWallsDatabase.findInteraction(moving, this);
    }
    if (!interactOnCollision){ //for if a nonwall can interact with a player standing a few blocks away. (ie a fan)
        NonWallsDatabase.findInteraction(moving, this);
    }
}
public String getNameAbbrieviation(){if (!wallType.equals(""))return wallType.substring(0,1);
else return "[]";
}

}
