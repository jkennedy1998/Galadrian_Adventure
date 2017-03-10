package cartography;import java.util.ArrayList;

public class Board {
    int xDimension;
    int yDimension;
    ArrayList<Walls> walls = new ArrayList<>();
    ArrayList<Moving> movings = new ArrayList<>();


    public Board(int x, int y){ //no walls
        xDimension = x;
        yDimension = y;
        walls.add(new Walls());
    }
    public Board (int x, int y, Walls walls){ //preExistingWalls
        xDimension = x;
        yDimension = y;
        this.walls.add(walls);
    }
    public Board (int x, int y, ArrayList walls){ //preExistingWalls
        xDimension = x;
        yDimension = y;
        this.walls.addAll(walls);
    }
    public Board (Board board){
        xDimension = board.xDimension;
        yDimension = board.yDimension;
        this.walls.addAll(board.walls);
    }
public boolean questionCollision(int xPosition, int yPosition, int elevtion){
        for(int scan = 0; scan < walls.size(); scan++){
            if (walls.get(scan).elevation == elevtion)
                for (int subScan = 0; subScan < walls.get(scan).walls.size(); subScan++)
                return (walls.get(scan).questionWall(xPosition, yPosition));
        }
    System.out.println("error: no walls found at current elevation");
    return false;
}
    public String questionWallCharacters(int xPosition, int yPosition, int elevtion){
        for(int scan = 0; scan < walls.size(); scan++){
            if (walls.get(scan).elevation == elevtion)
                for (int subScan = 0; subScan < walls.get(scan).walls.size(); subScan++) {
                    if ((walls.get(scan).questionWall(xPosition, yPosition))||
                            (NonWallsDatabase.checkIfNonWall(walls.get(scan).walls.get(subScan)) &&
                                    walls.get(scan).walls.get(subScan).xPosition == xPosition &&
                                    walls.get(scan).walls.get(subScan).yPosition == yPosition))
                        return "[|" + walls.get(scan).walls.get(subScan).wallType.substring(0,1) + "]";

                }
        }
//        System.out.println("error: no walls found at current elevation");
        return "___";
    }
public void addNonWall( NonWalls nonWall){
    Wall nonWallObject = nonWall;
    for (int scan = 0; scan < walls.size(); scan++){
        if (nonWallObject.elevation == walls.get(scan).elevation)
            walls.get(scan).addWall(nonWallObject);

    }
}
public String printBoard(){

    String output = "";
    int xScan = 0, yScan = 0;
    while (yScan < yDimension){
        while (xScan < xDimension) {
            String tempCharacter;
            int elevation = 999;
            for(int scan = 0; scan < movings.size(); scan++)
                if(movings.get(scan).behavior.equals("player"))
                    elevation = movings.get(scan).elevation;
            if (elevation == 999) System.out.println("error: no players found (or elevation is at 999)");
//            if (questionCollision(xScan,yScan,elevation)) tempCharacter = "[|#|]";
//            else tempCharacter = "___";
            tempCharacter = questionWallCharacters(xScan,yScan,elevation);
            for (int characterScan = 0; characterScan < movings.size(); characterScan++)
            if (movings.get(characterScan).xPosition == xScan && movings.get(characterScan).yPosition == yScan && movings.get(characterScan).elevation == elevation) tempCharacter = " |"+movings.get(characterScan).getNameAbbreviation()+"| ";
            if (xScan == xDimension-1) tempCharacter += "\n";
            output+= tempCharacter;
            xScan++;
        }
        yScan++;
        xScan = 0;
    }
    return output;
}
}
