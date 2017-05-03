package cartography;

import Battle.adventurerework;
import Battle.monsterSelection;

/**
 * Created by citim on 5/2/2017.
 */
public class Projectile extends Moving {
    int beatCounter, beatsAlive;
    Equation equation;

    public Projectile(int xPosition, int yPosition,int xDesired, int yDesired,int beatsAlive, Board board, String name){
        super(xPosition,yPosition,board,name);
        equation = new Equation(new int[] {xPosition,yPosition},new int[] {xDesired,yDesired});
        this.beatsAlive = beatsAlive;

    }



    public void run(){
        int[] temp = equation.getNextMove(xPosition,yPosition);
        if (temp[0] == 1) {
            moveRight();
            board.printTile(xPosition/30,yPosition/30,elevation);
        }
        if (temp[0] == -1) {
            moveLeft();
            board.printTile(xPosition/30,yPosition/30,elevation);
        }
        if (temp[1] == 1) {
            moveDown();
            board.printTile(xPosition/30,yPosition/30,elevation);
        }
        if (temp[1] == -1){
            moveUp();
            board.printTile(xPosition/30,yPosition/30,elevation);
        }


    }
    public void moveUp(){
        facing = 0;
        if (!board.questionCollision(xPosition, yPosition - 1, elevation)&& wallCollide &&!questionPlayerCollision(0,-1)&& inBoardBounds(0,-1)&& questionFloor(xPosition,yPosition-1))
            yPosition--;
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
        lastBoard = board;
        if(beat== 15) beat = 0;
        else beat++;
    }
    public void moveDown() {
        facing = 2;
        if (!board.questionCollision(xPosition, yPosition + 1, elevation)&& wallCollide &&!questionPlayerCollision(0,1)&& inBoardBounds(0,1)&& questionFloor(xPosition, yPosition+1))
            yPosition++;
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
        lastBoard = board;
        if(beat== 15) beat = 0;
        else beat++;

    }
    public void moveLeft() {
        facing = 3;
        if (!board.questionCollision(xPosition - 1, yPosition, elevation)&& wallCollide &&!questionPlayerCollision(-1,0) && inBoardBounds(-1,0)&& questionFloor(xPosition-1, yPosition))
            xPosition--;

        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
        lastBoard = board;
        if(beat== 15) beat = 0;
        else beat++;

    }
    public void moveRight() {
        facing = 1;
        if (!board.questionCollision(xPosition + 1, yPosition,elevation)&& wallCollide &&!questionPlayerCollision(1,0)&& inBoardBounds(1,0)&& questionFloor(xPosition+1, yPosition))
            xPosition++;
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
        lastBoard = board;
        if(beat== 15) beat = 0;
        else beat++;

    }
    public boolean questionPlayerCollision(int x, int y){
        if (!playerCollide) return false;
        Moving temp;
        for(int scan = 0; scan < board.movings.size(); scan++){
            temp = board.movings.get(scan);
            if ((xPosition+x)/30 == temp.xPosition/30&&(yPosition+y)/30 == temp.yPosition/30&&temp.playerCollide &&!(temp.name.equals(name))&&elevation==temp.elevation){
                return true;
            }
        }
        return false;
    }
    public int questionWallCollision(int x, int y){ //0 if no collision, 1 if x collision in desired direction, 2 if y collision in desired direction
        boolean xCollide = false, yCollide = false;
        if (board.questionCollision((xPosition+x)/30, yPosition/30, elevation)) xCollide = true;
        if (board.questionCollision(xPosition/30, (yPosition+y)/30, elevation)) {
            yCollide = true;
        }

        if(xCollide == yCollide)
            return 0;
        else if(xCollide) return 1;
        else return 2;
    }
}
