package cartography;
import java.util.ArrayList;
public class Walls {
     ArrayList<Wall> walls;
     ArrayList<Floor> floors;
     int elevation = 0;
    public Walls(){//no walls
        walls = new ArrayList<Wall>();
        floors = new ArrayList<Floor>();
    }
    public Walls(int[] wallX, int[] wallY){

        walls = new ArrayList<Wall>();
        for(int scan = 0; scan < wallX.length; scan++){
            Wall wallObject = new Wall (wallX[scan], wallY[scan],elevation,"wall");
            walls.add(wallObject);
        }
        deleteWallDuplicates();
    }
    public Walls(int[] wallX, int[] wallY,int[] floorsX, int[] floorsY){

       this(wallX,wallY);
        floors = new ArrayList<Floor>();
        for(int scan = 0; scan < floorsX.length; scan++){
            Floor floorObject = new Floor (floorsX[scan], floorsY[scan],elevation,"floor");
            floors.add(floorObject);
        }
        deleteFloorDuplicates();
    }
    public Walls (Walls walls){ // walls from another wall object
        this.walls = walls.walls; //hahaha
    }
    public void addWall (Wall wall){
        walls.add(wall);
        deleteWallDuplicates();
    }
    public void addFloor (Floor floor){
        floors.add(floor);
        deleteFloorDuplicates();
    }
    public void addFloor (int[] floorXCoordinates, int[] floorYCoordinates){
        if (floorXCoordinates.length!=floorYCoordinates.length) {
            System.out.println("error: sent uneven floor arrays to addFloor()");
            System.exit(1);
        }
        for(int scan = 0; scan < floorXCoordinates.length; scan++){
            Floor floorObject = new Floor (floorXCoordinates[scan], floorYCoordinates[scan],elevation,"floor");
            floors.add(floorObject);
        }
        deleteFloorDuplicates();
    }
    public void addFloor (int xPosition, int yPosition){
        Floor floorObject = new Floor(xPosition,yPosition,elevation,"floor");
        floors.add(floorObject);
        deleteFloorDuplicates();

    }
    public void addSquare(int xPosition, int yPosition, int xDimension, int yDimension, boolean filled){
        ArrayList wallX = new ArrayList();
        ArrayList wallY = new ArrayList();
        if(!filled) {
            for (int x = xPosition; x < xDimension + xPosition; x++) wallX.add(x);
            for (int scan = 0; scan < xDimension; scan++) wallY.add(yPosition);
            for (int x = xPosition; x < xDimension + xPosition; x++) wallX.add(x);
            for (int scan = 0; scan < xDimension; scan++) wallY.add(yPosition + yDimension - 1);
            for (int y = yPosition; y < yDimension + yPosition; y++) wallY.add(y);
            for (int scan = 0; scan < yDimension; scan++) wallX.add(xPosition);
            for (int y = yPosition; y < yDimension + yPosition; y++) wallY.add(y);
            for (int scan = 0; scan < yDimension; scan++) wallX.add(xPosition + xDimension - 1);
            int[] x = new int[wallX.size()];
            int[] y = new int[wallX.size()];
            if(wallX.size() != wallY.size()){
                System.out.println("error: walls not created with equal x and y coord lengths when attempting to make a square");
            }
            for (int scan = 0; scan < wallX.size(); scan++) {
                x[scan] = (int) wallX.get(scan);
            }
            for (int scan = 0; scan < wallY.size(); scan++) {
                y[scan] = (int) wallY.get(scan);
            }
            addWall(x, y);
        }
        else {
            int x = xPosition,y = yPosition;
            for(int scan = 0; scan < xDimension*yDimension; scan++){
                addWall(x,y);
                x++;
                if (x > xDimension+xPosition){
                    x = xPosition;
                    y++;
                }
            }
        }

    }
    public void addWall (int[] wallXCoordinates, int[] wallYCoordinates){
        if (wallXCoordinates.length!=wallYCoordinates.length){
            System.out.println("error: sent uneven wall arrays to addWall()");
        System.exit(1);
    }
        for(int scan = 0; scan < wallXCoordinates.length; scan++){
            Wall wallObject = new Wall (wallXCoordinates[scan], wallYCoordinates[scan],elevation,"wall");
            walls.add(wallObject);
        }
        deleteWallDuplicates();
    }
    public void addWall (int xPosition, int yPosition){
        Wall wallObject = new Wall(xPosition,yPosition,elevation,"wall");
        walls.add(wallObject);
        deleteWallDuplicates();

    }
    public void addWall (ArrayList walls){
        this.walls.addAll(walls);
        deleteWallDuplicates();
    }
    private void deleteWallDuplicates() {

        for (int scan = 0; scan < walls.size(); scan++) {

            for (int subScan = 0; subScan < walls.size(); subScan++){
                if (walls.get(scan).xPosition == walls.get(subScan).xPosition && walls.get(scan).yPosition == walls.get(subScan).yPosition&& scan!=subScan && !walls.get(scan).nonWall && !walls.get(subScan).nonWall){
                    walls.remove(scan);
                    subScan--;
                }
            }
        }

    }
    private void deleteFloorDuplicates() {

        for (int scan = 0; scan < floors.size(); scan++) {

            for (int subScan = 0; subScan < floors.size(); subScan++){
                if (floors.get(scan).xPosition == floors.get(subScan).xPosition && floors.get(scan).yPosition == floors.get(subScan).yPosition&& scan!=subScan){
                    floors.remove(scan);
                    subScan--;
                }
            }
        }

    }
    public void deleteWall(int x, int y){
        for (int scan = 0; scan < walls.size(); scan++) {
            if (walls.get(scan).xPosition == x && walls.get(scan).yPosition == y&& !walls.get(scan).nonWall){
                    walls.remove(scan);
            }
        }
    }
    public void deleteFloor(int x, int y) {
        for (int scan = 0; scan < walls.size(); scan++) {
            if (floors.get(scan).xPosition == x && floors.get(scan).yPosition == y) {
                floors.remove(scan);
            }
        }
    }
    public String questionWall(int x, int y){

        for (int scan = 0; scan < walls.size(); scan++){
                if (walls.get(scan).yPosition == y && walls.get(scan).xPosition == x && !walls.get(scan).nonWall)
                    return walls.get(scan).wallType;
        }return null;
    }
    public String questionWallAndNon(int x, int y){

        for (int scan = 0; scan < walls.size(); scan++){
            if (walls.get(scan).yPosition == y && walls.get(scan).xPosition == x)
                return walls.get(scan).wallType;
        }return null;
    }
    public String questionFloor(int x, int y){

        for (int scan = 0; scan < floors.size(); scan++){
            if (floors.get(scan).yPosition == y && floors.get(scan).xPosition == x)
                return floors.get(scan).floorType;
        }return null;
    }
    public void getWallArrays(){ //used when writing code. outputs simplified array.

        deleteWallDuplicates();
        System.out.print("int[] xOfWalls = {");
        for (int scan = 0; scan < walls.size(); scan++){
            System.out.print(walls.get(scan).xPosition);
            if (scan != walls.size()-1) System.out.print(", ");
        }
        System.out.println("};");
        System.out.print("int[] yOfWalls = {");
        for (int scan = 0; scan < walls.size(); scan++){
            System.out.print(walls.get(scan).yPosition);
            if (scan != walls.size()-1) System.out.print(", ");
        }
        System.out.println("};");
    }
    public void addSquareFloor(int xPosition, int yPosition, int xDimension, int yDimension, boolean filled){
        ArrayList floorX = new ArrayList();
        ArrayList floorY = new ArrayList();
        if(!filled) {
            for (int x = xPosition; x < xDimension + xPosition; x++) floorX.add(x);
            for (int scan = 0; scan < xDimension; scan++) floorY.add(yPosition);
            for (int x = xPosition; x < xDimension + xPosition; x++) floorX.add(x);
            for (int scan = 0; scan < xDimension; scan++) floorY.add(yPosition + yDimension - 1);
            for (int y = yPosition; y < yDimension + yPosition; y++) floorY.add(y);
            for (int scan = 0; scan < yDimension; scan++) floorX.add(xPosition);
            for (int y = yPosition; y < yDimension + yPosition; y++) floorY.add(y);
            for (int scan = 0; scan < yDimension; scan++) floorX.add(xPosition + xDimension - 1);
            int[] x = new int[floorX.size()];
            int[] y = new int[floorX.size()];
            if(floorX.size() != floorY.size()){
                System.out.println("error: floors not created with equal x and y coord lengths when attempting to make a square");
            }
            for (int scan = 0; scan < floorX.size(); scan++) {
                x[scan] = (int) floorX.get(scan);
            }
            for (int scan = 0; scan < floorY.size(); scan++) {
                y[scan] = (int) floorY.get(scan);
            }
            addFloor(x, y);
        }
        else {
            int x = xPosition,y = yPosition;
            for(int scan = 0; scan < xDimension*yDimension; scan++){
                addFloor(x,y);
                x++;
                if (x > xDimension+xPosition){
                    x = xPosition;
                    y++;
                }
            }
        }

    }
}
