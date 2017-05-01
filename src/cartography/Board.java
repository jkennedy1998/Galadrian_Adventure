package cartography;
import java.util.ArrayList;
import Battle.adventurerework;

public class Board {
    int xDimension, yDimension, levels = 1;
    private ArrayList<Walls> walls = new ArrayList<>();
    public ArrayList<Moving> movings = new ArrayList<>();
    public String area = "forest";


    public Board(int x, int y) { //no walls
        xDimension = x;
        yDimension = y;
        walls.add(new Walls());
    }

    public Board(int x, int y, Walls walls) { //preExistingWalls
        xDimension = x;
        yDimension = y;
        this.walls.add(walls);
    }

    public Board(int x, int y, ArrayList walls) { //preExistingWalls
        xDimension = x;
        yDimension = y;
        this.walls.addAll(walls);
    }

    public Board(Board board) {
        xDimension = board.xDimension;
        yDimension = board.yDimension;
        this.walls.addAll(board.walls);
    }

    public void addWalls(Walls walls){
        for(int scan = 0; scan < this.walls.size(); scan++)
        if(walls.elevation == this.walls.get(scan).elevation){
            System.out.println("error: walls added to the same board with equal elevations");
        }
        this.walls.add(walls);
        levels++;
    }
    public Walls getWalls(int elevation){
        for(int scan = 0; scan < walls.size(); scan++){
            if (walls.get(scan).elevation == elevation) return walls.get(scan);
        }
        System.out.println("error: no walls available on board at called elevation");
        return null;
    }
    public boolean questionCollision(int xPosition, int yPosition, int elevtion) {
        for (int scan = 0; scan < walls.size(); scan++) {
            if (walls.get(scan).elevation == elevtion)
                for (int subScan = 0; subScan < walls.get(scan).walls.size(); subScan++)
                    if (walls.get(scan).questionWall(xPosition, yPosition) != null) return true;
        }
        return false;
    }

//    public String questionWallCharacters(int xPosition, int yPosition, int elevtion) {
//        for (int scan = 0; scan < walls.size(); scan++) {
//            if (walls.get(scan).elevation == elevtion)
//                for (int subScan = 0; subScan < walls.get(scan).walls.size(); subScan++) {
//                    if ((walls.get(scan).questionWall(xPosition, yPosition)) ||
//                            (walls.get(scan).walls.get(subScan).nonWall &&
//                                    walls.get(scan).walls.get(subScan).xPosition == xPosition &&
//                                    walls.get(scan).walls.get(subScan).yPosition == yPosition))
//                        return "[|" + walls.get(scan).walls.get(subScan).wallType.substring(0, 1) + "]";
//                }
//        }
////        System.out.println("error: no walls found at current elevation");
//        return "";
//    }

    public void addNonWall(NonWalls nonWall) {
        Wall nonWallObject = nonWall;
        for (int scan = 0; scan < walls.size(); scan++) {
            if (nonWallObject.elevation == walls.get(scan).elevation)
                walls.get(scan).addWall(nonWallObject);
        }
    }

    public NonWalls findNonWall(int xPosition, int yPosition, int elevation) {
        for (int scan = 0; scan < walls.size(); scan++) {

            if (walls.get(scan).elevation == elevation)
                for (int subScan = 0; subScan < walls.get(scan).walls.size(); subScan++)
                    if (walls.get(scan).walls.get(subScan).yPosition/30 == yPosition/30 && walls.get(scan).walls.get(subScan).xPosition/30 == xPosition/30&&walls.get(scan).walls.get(subScan).nonWall) {
                        return (NonWalls) walls.get(scan).walls.get(subScan);
                    }
        }
        return null;
    }
     public NonWalls findNonWallOnGrid(int xPosition, int yPosition, int elevation) {
        for (int scan = 0; scan < walls.size(); scan++) {

            if (walls.get(scan).elevation == elevation)
                for (int subScan = 0; subScan < walls.get(scan).walls.size(); subScan++)
                    if (walls.get(scan).walls.get(subScan).yPosition/30 == yPosition && walls.get(scan).walls.get(subScan).xPosition/30 == xPosition&&walls.get(scan).walls.get(subScan).nonWall) {
                        return (NonWalls) walls.get(scan).walls.get(subScan);
                    }
        }
        return null;
    }

    public void removeMoving(Moving moving) {
        for (int scan = 0; scan < movings.size(); scan++) {
            if (movings.get(scan).xPosition == moving.xPosition && movings.get(scan).yPosition == moving.yPosition && moving.name.equals(movings.get(scan).name))
                movings.remove(scan);
        }
        if (!moving.behavior.equals("player"))
            moving.board = adventurerework.hell;
    }

    public void removeNonwall(NonWalls nonWalls) {
        for (int scan = 0; scan < walls.size(); scan++) {
            if (walls.get(scan).elevation == nonWalls.elevation)
                for (int subScan = 0; subScan < walls.get(scan).walls.size(); subScan++) {
                    if (walls.get(scan).walls.get(subScan).xPosition == nonWalls.xPosition && walls.get(scan).walls.get(subScan).yPosition == nonWalls.yPosition)
                        walls.get(scan).walls.remove(subScan);
                }
        }
    }


//    public void printBoard() { //use of Screen
//        adventurerework.window.refreshBoard();
//        int elevation = adventurerework.adam.elevation;
//        int xScan = 0, yScan = 0;
//        while (yScan < yDimension) {
//            while (xScan < xDimension) {
//                String tempCharacter;
//                tempCharacter = questionWallCharacters(xScan, yScan, elevation);
//                if (tempCharacter == null) adventurerework.window.drawCharacter(xScan, yScan, null);
//                for (int characterScan = 0; characterScan < movings.size(); characterScan++)
//                    if (movings.get(characterScan).xPosition == xScan && movings.get(characterScan).yPosition == yScan && movings.get(characterScan).elevation == elevation)
//                        tempCharacter = movings.get(characterScan).getNameAbbreviation();
//                adventurerework.window.drawCharacter(xScan, yScan, tempCharacter);
//                adventurerework.window.removeAll();
//                xScan++;
//            }
//            yScan++;
//            xScan = 0;
//        }
//    }

        public void printBoard(){//only called at the start of a new board.
        printFloors();
        printWalls(); //and nonwalls;
        printMovings();
    }
    public void printTile(int x, int y,int elevation){//called when things move or change.
        //print floors per tile
        adventurerework.window.drawFloor(x*30-30,y*30,getWalls(elevation).questionFloor(x*30-30,y*30));
        adventurerework.window.drawFloor(x*30+30,y*30,getWalls(elevation).questionFloor(x*30+30,y*30));
        adventurerework.window.drawFloor(x*30,y*30,getWalls(elevation).questionFloor(x*30,y*30));
        adventurerework.window.drawFloor(x*30,y*30-30,getWalls(elevation).questionFloor(x*30,y*30-30));
        adventurerework.window.drawFloor(x*30,y*30+30,getWalls(elevation).questionFloor(x*30,y*30+30));
//        adventurerework.window.drawFloor(x*30+30,y*30+30,getWalls(elevation).questionFloor(x*30+30,y*30+30));
//        adventurerework.window.drawFloor(x*30+30,y*30-30,getWalls(elevation).questionFloor(x*30+30,y*30-30));
//        adventurerework.window.drawFloor(x*30-30,y*30+30,getWalls(elevation).questionFloor(x*30-10,y*30+30));
//        adventurerework.window.drawFloor(x*30-30,y*30-30,getWalls(elevation).questionFloor(x*30-30,y*30-30));
        //print walls per tile
        adventurerework.window.drawWall(x*30,y*30,getWalls(elevation).questionWallAndNon(x*30,y*30));
        adventurerework.window.drawWall(x*30+30,y*30,getWalls(elevation).questionWallAndNon(x*30+30,y*30));
        adventurerework.window.drawWall(x*30-30,y*30,getWalls(elevation).questionWallAndNon(x*30-30,y*30));
        adventurerework.window.drawWall(x*30,y*30+30,getWalls(elevation).questionWallAndNon(x*30,y*30+30));
        adventurerework.window.drawWall(x*30,y*30-30,getWalls(elevation).questionWallAndNon(x*30,y*30-30));

        //print movings per tile
        for(int scan = 0; movings.size() > scan; scan++){
            if(movings.get(scan).xPosition/30 == x && movings.get(scan).yPosition/30 == y){
                adventurerework.window.drawCharacter(movings.get(scan).xPosition,movings.get(scan).yPosition,movings.get(scan).getNameAbbreviation());
            }
        }


    }
    private void printMovings(){
        int elevation = adventurerework.adam.elevation;
        for(int scan = 0; scan < movings.size(); scan++){
            if(movings.get(scan).elevation == elevation) adventurerework.window.drawCharacter(movings.get(scan).xPosition, movings.get(scan).yPosition,movings.get(scan).getNameAbbreviation());
        }
    }
    private void printWalls(){
        int elevation = adventurerework.adam.elevation;
        int xScan = 0, yScan = 0, wallsIndex = 0;
        for (int scan = 0; scan < walls.size(); scan++) if (walls.get(scan).elevation == elevation) wallsIndex = scan;
        while (yScan < yDimension) {
            while (xScan < xDimension) {
                if(walls.get(wallsIndex).questionWallAndNon(xScan,yScan) != null)adventurerework.window.drawWall(xScan,yScan,(String)walls.get(wallsIndex).questionWallAndNon(xScan,yScan).subSequence(0,1));
            xScan++;
            }
            xScan = 0;
            yScan++;
        }
    }
    private void printFloors() {
        int elevation = adventurerework.adam.elevation;
        int xScan = 0, yScan = 0, wallsIndex = 0;
        for (int scan = 0; scan < walls.size(); scan++) if (walls.get(scan).elevation == elevation) wallsIndex = scan;
        while (yScan < yDimension) {
            while (xScan < xDimension) {
                if(walls.get(wallsIndex).questionFloor(xScan,yScan) != null)adventurerework.window.drawFloor(xScan,yScan,walls.get(wallsIndex).questionFloor(xScan,yScan));
                xScan++;
            }
            xScan = 0;
            yScan++;
        }
    }
}
