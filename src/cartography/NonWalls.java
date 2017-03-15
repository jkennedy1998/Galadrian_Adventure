package cartography;
public class NonWalls extends Wall {
    boolean colidable = false, interactOnCollision = true, state = true;
    String description = "";
    Board board;
    NonWalls link;
public NonWalls (int xPosition, int yPosition, int elevation, String wallType) {
    super(xPosition, yPosition, elevation, wallType);
    nonWall = true;
}
public void interact(Moving moving){
    if (interactOnCollision&&!colidable&&xPosition == moving.xPosition && yPosition == moving.yPosition&& elevation == moving.elevation) {  //for if you need to walk on the object to interact with it
        NonWallsDatabase.findInteraction(moving, this);
    }
    if (interactOnCollision&&colidable&&xPosition == moving.xPosition && yPosition == moving.yPosition&& elevation == moving.elevation){//for if you need to bump into the object to interact with it
        moving.xPosition = moving.lastPosition[0];
        moving.yPosition = moving.lastPosition[1];
        NonWallsDatabase.findInteraction(moving, this);
        System.out.println(wallType);
    }
    if (!interactOnCollision){ //for if a nonwall can interact with a player standing a few blocks away. (ie a fan)
        NonWallsDatabase.findInteraction(moving, this);
    }
}
public void checkState(){
    if (wallType.equals("pressure plate") && link != null) link.state = state;
    else if (wallType.equals("open door") || wallType.equals("closed door")){
        if (state) wallType = "closed door";
        else wallType = "open door";
    }
    else System.out.println("error: checkState method activated for non referenced objects or link not set");
}
public String getNameAbbrieviation(){if (!wallType.equals(""))return wallType.substring(0,1);
else return "[]";
}

}
