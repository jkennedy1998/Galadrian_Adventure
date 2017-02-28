package cartography;import java.util.ArrayList;

public class Board {
    int xDimension;
    int yDimension;
    ArrayList<Walls> walls = new ArrayList<>();
    ArrayList<NonWalls> nonWalls = new ArrayList<>();


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
        this.nonWalls.addAll(board.nonWalls);
    }
public boolean questionCollision(int xPosition, int yPosition, int elevtion){
        for(int scan = 0; scan < walls.size(); scan++){
            if (walls.get(scan).elevation == elevtion) return (walls.get(scan).questionWall(xPosition, yPosition));
        }
    System.out.println("error: no walls found at current elevation");
    return false;
}
public void addNonWall( NonWalls nonWall){
    nonWalls.add(nonWall);
}
public String printBoard(ArrayList<Moving> movingArray){

    String output = "";
    int xScan = 0, yScan = 0;
    while (yScan < yDimension){
        while (xScan < xDimension) {
            String tempCharacter;
            int elevation = 999;
            for(int scan = 0; scan < movingArray.size(); scan++)
                if(movingArray.get(scan).behavior.equals("player"))
                    elevation = movingArray.get(scan).elevation;
            if (elevation == 999) System.out.println("error: no players found (or elevation is at 999)");
            if (questionCollision(xScan,yScan,elevation)) tempCharacter = "[|#|]";
            else tempCharacter = "___";
            for (int scan = 0; scan < nonWalls.size(); scan++){
                NonWalls temp = nonWalls.get(scan);
                if (temp.elevation == elevation && temp.xPosition == xScan && temp.yPosition == yScan) tempCharacter = "[|"+temp.getNameAbbrieviation()+"|]";
            }
            for (int characterScan = 0; characterScan < movingArray.size(); characterScan++)
            if (movingArray.get(characterScan).xPosition == xScan && movingArray.get(characterScan).yPosition == yScan && movingArray.get(characterScan).elevation == elevation) tempCharacter = " |"+movingArray.get(characterScan).getNameAbbreviation()+"| ";
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
