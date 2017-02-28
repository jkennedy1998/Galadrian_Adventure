package cartography;import java.util.ArrayList;

public class Walls {
     ArrayList wallX;
     ArrayList wallY;
     int elevation = 0;

    public Walls(Board board){//walls around board
        for(int x = 0; x < board.xDimension; x++){wallX.add(x);wallY.add(0);wallX.add(x);wallY.add(board.yDimension);}
        for(int y = 0; y < board.yDimension; y++){wallX.add(0);wallY.add(y);wallX.add(0);wallY.add(board.xDimension);}
    }
    public Walls(){//no walls
        wallX = new ArrayList();
        wallY = new ArrayList();
    }
    public Walls(int[] wallX, int[] wallY){
        this.wallX = new ArrayList();
        this.wallY = new ArrayList();
        for(int scan = 0; scan < wallX.length; scan++){
            this.wallX.add(wallX[scan]);
            this.wallY.add(wallY[scan]);
        }
    }
    public Walls (ArrayList wallX, ArrayList wallY){//walls from array list
        this.wallX = wallX;
        this.wallY = wallY;
    }

    public Walls (Walls walls){ // walls from another wall object
        wallX = walls.wallX;
        wallY = walls.wallY;
    }
    public void addWall (int[] wallXCoordinates, int[] wallYCoordinates){
        if (wallX.size()!=wallY.size())
            System.exit(1);
        for (int x = 0; x < wallXCoordinates.length; x++){
            wallX.add(wallXCoordinates[x]);
            wallY.add(wallYCoordinates[x]);
        }
    }
    public void addWall (int xPosition, int yPosition){
        wallX.add(xPosition);
        wallY.add(yPosition);
        deleteDuplicates();
    }
    public void addWall (ArrayList wallX, ArrayList wallY){ //two arrays of equal sizes.
        if (wallX.size()!=wallY.size())
            System.exit(1);
        this.wallX.addAll(wallX);
        this.wallY.addAll(wallY);
        deleteDuplicates();

    }
    private void deleteDuplicates() { //make this work

        for (int scan = 0; scan < wallX.size(); scan++) {

            for (int subScan = 0; subScan < wallY.size(); subScan++){
                if ((int)wallX.get(scan) == (int)wallX.get(subScan) && (int)wallY.get(scan) == (int)wallY.get(subScan)&& scan!=subScan){
                    wallX.remove(scan);
                    wallY.remove(scan);
                    subScan--;
                }
            }
        }
    }
    public void deleteWall(int x, int y){
        for (int scan = 0; scan < wallX.size(); scan++) {
            if ((int)wallX.get(scan) == x && (int)wallY.get(scan) == y){
                    wallX.remove(scan);
                    wallY.remove(scan);
            }
        }
    }
    public void deleteWall(ArrayList x, ArrayList y){
        for (int scan = 0; scan < x.size(); scan++) deleteWall((int)x.get(scan),(int)y.get(scan));
    }
    public boolean questionWall(int x, int y){

        for (int xScan = 0; xScan < wallX.size(); xScan++){
            for (int yScan = 0; yScan < wallX.size(); yScan++){
                if ((int)wallY.get(xScan) == y && (int) wallX.get(xScan) == x)
                    return true;
                }
        }return false;
    }
    public void getWallArrays(){ //used when writing code. outputs simplified array.

        deleteDuplicates();
        System.out.print("int[] xOfWalls = {");
        for (int scan = 0; scan < wallX.size(); scan++){
            System.out.print((int)wallX.get(scan));
            if (scan != wallX.size()-1) System.out.print(", ");
        }
        System.out.println("};");
        System.out.print("int[] yOfWalls = {");
        for (int scan = 0; scan < wallY.size(); scan++){
            System.out.print((int)wallY.get(scan));
            if (scan != wallY.size()-1) System.out.print(", ");
        }
        System.out.println("};");
    }
}
