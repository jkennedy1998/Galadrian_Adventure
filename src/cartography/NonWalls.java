package cartography;
public class NonWalls extends Wall {
    byte facing = 0;
    boolean colidable = false, interactOnCollision = true, state = true, interactOnUse = false;
    String description = "";
    Board board;
    NonWalls link;
public NonWalls (int xPosition, int yPosition, int elevation, String wallType, Board board) {
    super(xPosition, yPosition, elevation, wallType);
    this.board = board;
    nonWall = true;
}
public void interact(Mob moving){
    if (interactOnCollision&&!colidable&&xPosition/30 == moving.xPosition/30 && yPosition/30 == moving.yPosition/30&& elevation == moving.elevation) {  //for if you need to walk on the object to interact with it
        NonWallsDatabase.findInteraction(moving, this);
    }
    else if (interactOnCollision&&colidable&&xPosition/30 == moving.xPosition/30 && yPosition/30 == moving.yPosition/30&& elevation == moving.elevation){//for if you need to bump into the object to interact with it
        moving.xPosition = moving.lastPosition[0];
        moving.yPosition = moving.lastPosition[1];
        NonWallsDatabase.findInteraction(moving, this);
    }
    else if (!interactOnCollision && colidable && xPosition/30 == moving.xPosition/30 && yPosition/30 == moving.yPosition/30&& elevation == moving.elevation){//if the nonwall is always active but playes cannot walk into it. (ie a dart trap)
        moving.xPosition = moving.lastPosition[0];
        moving.yPosition = moving.lastPosition[1];
    }
    else if (!interactOnCollision && !colidable){ //for if a nonwall that needs to be triggered with a link based button

    }
}
public void interactOnUse(Mob moving){
    if(interactOnUse)
    NonWallsDatabase.findInteraction(moving,this);
}
public void checkState(){
    if (wallType.equals("pressure plate") && link != null) link.state = state;
    else if (wallType.equals("button") && link != null) link.state = state;
    else if (wallType.equals("open door") || wallType.equals("closed door")){ //an open door is in a false state
        if (state){
            wallType = "open door";
            colidable = false;
        } else{
            wallType = "closed door";
            colidable = true;
        }
    }
    else if(wallType.equals("dart trap")){
        NonWallsDatabase.findInteraction(null,this);
    }
    else System.out.println("error: checkState method activated for non referenced objects or link not set");
}
}
