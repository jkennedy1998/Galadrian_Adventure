package cartography;
import java.util.ArrayList;
public class Walls {
     ArrayList<Wall> walls;
     int elevation = 0;

//    public Walls(Board board){//walls around board
//        for(int x = 0; x < board.xDimension; x++){wallX.add(x);wallY.add(0);wallX.add(x);wallY.add(board.yDimension);}
//        for(int y = 0; y < board.yDimension; y++){wallX.add(0);wallY.add(y);wallX.add(0);wallY.add(board.xDimension);}
//    }
    public Walls(){//no walls
        walls = new ArrayList<Wall>();
    }
    public Walls(int[] wallX, int[] wallY){

        walls = new ArrayList<Wall>();
        for(int scan = 0; scan < wallX.length; scan++){
            Wall wallObject = new Wall (wallX[scan], wallY[scan],elevation,"w");
            walls.add(wallObject);
        }
        deleteDuplicates();
    }

    public Walls (Walls walls){ // walls from another wall object
        this.walls = walls.walls; //hahaha
    }

    public void addWall (Wall wall){
        walls.add(wall);
        deleteDuplicates();
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
                System.out.println("error: walls not created with equal x and y coord lengths");
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
        if (wallXCoordinates.length!=wallYCoordinates.length)
            //sent uneven wall arrays to addWall();
            System.exit(1);
        for(int scan = 0; scan < wallXCoordinates.length; scan++){
            Wall wallObject = new Wall (wallXCoordinates[scan], wallYCoordinates[scan],elevation,"w");
            walls.add(wallObject);
        }
        deleteDuplicates();
    }
    public void addWall (int xPosition, int yPosition){
        Wall wallObject = new Wall(xPosition,yPosition,elevation,"w");
        walls.add(wallObject);
        deleteDuplicates();

    }
    public void addWall (ArrayList walls){ //two arrays of equal sizes.
        this.walls.addAll(walls);
        deleteDuplicates();
    }
    private void deleteDuplicates() {

        for (int scan = 0; scan < walls.size(); scan++) {

            for (int subScan = 0; subScan < walls.size(); subScan++){
                if (walls.get(scan).xPosition == walls.get(subScan).xPosition && walls.get(scan).yPosition == walls.get(subScan).yPosition&& scan!=subScan && !walls.get(scan).nonWall && !walls.get(subScan).nonWall){
                    walls.remove(scan);
                    subScan--;
                }
            }
        }
    }
    public void deleteWall(int x, int y){
        for (int scan = 0; scan < walls.size(); scan++) {
            if (walls.get(scan).xPosition == x && walls.get(scan).yPosition == y){
                    walls.remove(scan);
            }
        }
    }
    public void deleteWall(ArrayList x, ArrayList y){
        for (int scan = 0; scan < x.size(); scan++) deleteWall((int)x.get(scan),(int)y.get(scan));
    }
    public boolean questionWall(int x, int y){

        for (int scan = 0; scan < walls.size(); scan++){
                if (walls.get(scan).yPosition == y && walls.get(scan).xPosition == x && !walls.get(scan).nonWall)
                    return true;
        }return false;
    }
    public void getWallArrays(){ //used when writing code. outputs simplified array.

        deleteDuplicates();
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
}
