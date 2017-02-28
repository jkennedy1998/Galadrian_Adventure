package cartography; /**
 * Created by citim on 2/23/2017.
 */
public class NonWalls {
    int xPosition, yPosition, elevation, xTransition = 0, yTransition = 0, elevationTransition = 0;
    String wallType;
    boolean colidable = false, interactOnCollision = true;
public NonWalls (int xPosition, int yPosition, int elevation, String wallType) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    this.elevation = elevation;
    this.wallType = wallType;
}
public void interact(Moving moving){
    if (interactOnCollision&&!colidable&&xPosition == moving.xPosition && yPosition == moving.yPosition&& elevation == moving.elevation) {  //for if you need to walk on the object to interact with it
        NonWallsDatabase.findInteraction(moving, wallType);
    }
    if (interactOnCollision&&colidable&&xPosition == moving.xPosition && yPosition == moving.yPosition&& elevation == moving.elevation){//for if you need to bump into the object to interact with it
        moving.xPosition = moving.lastPosition[0];
        moving.yPosition = moving.lastPosition[1];
        NonWallsDatabase.findInteraction(moving, wallType);
    }
    if (!interactOnCollision){ //for if a nonwall can interact with a player standing a few blocks away. (ie a fan)
        NonWallsDatabase.findInteraction(moving, wallType);
    }
}
public String getNameAbbrieviation(){return wallType.substring(0,1);
}

}
