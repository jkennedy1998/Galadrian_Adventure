package cartography;

import Battle.adventurerework;
import Battle.monsterSelection;

/**
 * Created by citim on 5/2/2017.
 */
public class Projectile extends Moving {
    int beatCounter, beatsAlive, milisOfRecoil;
    Equation equation;
    String projectileType;

    public Projectile(int xPosition, int yPosition, int elevation,int xDesired, int yDesired,int beatsAlive, Board board, String name, int milisOfRecoil){
        super(xPosition,yPosition,elevation,board,"projectile");
        equation = new Equation(new int[] {xPosition,yPosition},new int[] {xDesired,yDesired});
        this.beatsAlive = beatsAlive;
        this.milisOfRecoil = milisOfRecoil;
        projectileType = name;

    }



    public void questionNonWalls(){}
    public void run(){
        int[] temp = equation.getNextMove(xPosition,yPosition);
        beatCounter++;
        if (temp[0] == 1) {
            moveRight(5);
            board.printTile(xPosition/30,yPosition/30,elevation);
        }
        if (temp[0] == -1) {
            moveLeft(5);
            board.printTile(xPosition/30,yPosition/30,elevation);
        }
        if (temp[1] == 1) {
            moveDown(5);
            board.printTile(xPosition/30,yPosition/30,elevation);
        }
        if (temp[1] == -1){
            moveUp(5);
            board.printTile(xPosition/30,yPosition/30,elevation);
        }
        if(beatsAlive == beatCounter){
            board.removeMoving(this);
            board.printTile(xPosition,yPosition,elevation);
            try{
                join();
            }catch (Exception e){
                System.out.println(e);
            }
        }


    }
    public void moveUp(int distance){
        facing = 0;
        if (!board.questionCollision(xPosition, yPosition - distance, elevation)&& wallCollide &&!questionPlayerCollision(0,-distance)&& inBoardBounds(0,-distance)&& questionFloor(xPosition,yPosition-distance))
            yPosition-=distance;
        else{
            board.removeMoving(this);
            try{
                join();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
        lastBoard = board;
        if(beat== 15) beat = 0;
        else beat++;
    }
    public void moveDown(int distance) {
        facing = 2;
        if (!board.questionCollision(xPosition, yPosition + distance, elevation)&& wallCollide &&!questionPlayerCollision(0,distance)&& inBoardBounds(0,distance)&& questionFloor(xPosition, yPosition+distance))
            yPosition+=distance;
        else{
            board.removeMoving(this);
            try{
                join();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
        lastBoard = board;
        if(beat== 15) beat = 0;
        else beat++;

    }
    public void moveLeft(int distance) {
        facing = 3;
        if (!board.questionCollision(xPosition - distance, yPosition, elevation)&& wallCollide &&!questionPlayerCollision(-distance,0) && inBoardBounds(-distance,0)&& questionFloor(xPosition-distance, yPosition))
            xPosition-=distance;
        else{
            board.removeMoving(this);
            try{
                join();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
        lastBoard = board;
        if(beat== 15) beat = 0;
        else beat++;

    }
    public void moveRight(int distance) {
        facing = 1;
        if (!board.questionCollision(xPosition + distance, yPosition,elevation)&& wallCollide &&!questionPlayerCollision(distance,0)&& inBoardBounds(distance,0)&& questionFloor(xPosition+distance, yPosition))
            xPosition+=distance;
        else{
            board.removeMoving(this);
            try{
                join();
            }catch (Exception e){
                System.out.println(e);
            }
        }
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
