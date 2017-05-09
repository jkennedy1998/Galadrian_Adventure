package cartography;
import Battle.*;
public abstract class Moving extends Thread {
    public int xPosition, yPosition, elevation = 0, speed = 60, initialX, intitialY, tick = 0, facing = 2;
    boolean playerCollide = false, wallCollide = true, flying = false;
    public Board board, lastBoard;
    public String name;
    public int[] lastPosition;
    public byte beat = 0;

    public Moving(int xPosition, int yPosition,int elevation, Board board, String name) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        intitialY = yPosition;
        initialX = xPosition;
        this.board = board;
        this.name = name;
        lastPosition = new int[] {xPosition, yPosition};

    }

    public String getNameAbbreviation(){
        return name.substring(0,1);
    }

    public abstract void questionNonWalls();
    public abstract void run();

    protected boolean questionFloor(int xPosition, int yPosition) {
        if (flying) return true;

                for (int subScan = 0; subScan < board.getWalls(elevation).floors.size(); subScan++) { //account for position you want to go in. not the position you are in
                    if (board.getWalls(elevation).floors.get(subScan).xPosition/30 == xPosition/30 && board.getWalls(elevation).floors.get(subScan).yPosition/30 == yPosition/30) {
                        return true;
                    }

            }
        return false;
    }
    public abstract  void moveUp(int distance);
    public abstract void moveDown(int distance);
    public abstract void moveLeft(int distance);
    public abstract void moveRight(int distance);
    public boolean inBoardBounds(int xMove, int yMove){
        if (xMove+xPosition > board.xDimension-1 || xMove+xPosition < 0) return false;
        if (yMove+yPosition > board.yDimension-1 || yMove+yPosition < 0) return false;
        return true;
    }
//    public abstract boolean questionPlayerCollision(int x, int y);
    public abstract int questionWallCollision(int x, int y);

}