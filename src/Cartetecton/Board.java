package Cartetecton;
import java.util.ArrayList;

public class Board {
    int xDimension;
    int yDimension;
    ArrayList<Walls> walls = new ArrayList<>();

    public Board(int x, int y){ //no walls
        xDimension = x;
        yDimension = y;
        walls.add(new Walls());
    }
    public Board(int x, int y, Walls walls){ //preExistingWalls
        xDimension = x;
        yDimension = y;
        this.walls.add(walls);
    }
    public Board(int x, int y, ArrayList walls){ //preExistingWalls
        xDimension = x;
        yDimension = y;
        this.walls.addAll(walls);
    }
    public Board(Board board){
        xDimension = board.xDimension;
        yDimension = board.yDimension;
        this.walls.addAll(board.walls);
    }

    public String questionWallCharacters(int xPosition, int yPosition, int elevtion){
        for(int scan = 0; scan < walls.size(); scan++){
            if (walls.get(scan).elevation == elevtion)
                for (int subScan = 0; subScan < walls.get(scan).walls.size(); subScan++) {
                    if ((walls.get(scan).questionWall(xPosition, yPosition))||
                            (walls.get(scan).walls.get(subScan).nonWall &&
                                    walls.get(scan).walls.get(subScan).xPosition == xPosition &&
                                    walls.get(scan).walls.get(subScan).yPosition == yPosition))
                        return "[|" + walls.get(scan).walls.get(subScan).wallType.substring(0,1) + "]";
                }
        }
//        System.out.println("error: no walls found at current elevation");
        return "";
    }
 public void addNonWall( NonWalls nonWall){
    Wall nonWallObject = nonWall;
    for (int scan = 0; scan < walls.size(); scan++){
        if (nonWallObject.elevation == walls.get(scan).elevation)
            walls.get(scan).addWall(nonWallObject);
    }
}
public NonWalls findNonWall(int xPosition, int yPosition, int elevation){
    for (int scan = 0; scan < walls.size(); scan++){
        if(walls.get(scan).elevation == elevation)
            for (int subScan = 0; subScan < walls.get(scan).walls.size(); subScan++)
            if (walls.get(scan).walls.get(subScan).yPosition == yPosition && walls.get(scan).walls.get(subScan).xPosition == xPosition){
            return (NonWalls)walls.get(scan).walls.get(subScan);
            }
    }
    System.out.println("no NonWalls object at called location");
    return null;
}

    public void removeNonwall(NonWalls nonWalls){
        for(int scan = 0; scan < walls.size(); scan++){
            if(walls.get(scan).elevation == nonWalls.elevation)
                for( int subScan = 0; subScan < walls.get(scan).walls.size(); subScan++){
                if(walls.get(scan).walls.get(subScan).xPosition == nonWalls.xPosition && walls.get(scan).walls.get(subScan).yPosition == nonWalls.yPosition)
                    walls.get(scan).walls.remove(subScan);
                }
            }
        }

public String printBoard(){ //use of Screen
    System.out.println("here!");
    Cartetecton.window.refreshBoard();
    String output = "";
    int xScan = 0, yScan = 0;
    while (yScan < yDimension){
        while (xScan < xDimension) {
            String tempCharacter;
            int elevation = 999;

            tempCharacter = questionWallCharacters(xScan,yScan,elevation);
            if (tempCharacter == null) Cartetecton.window.drawCharacter(xScan,yScan,null);
            xScan++;
        }
        yScan++;
        xScan = 0;
    }
    return output;
}
}
