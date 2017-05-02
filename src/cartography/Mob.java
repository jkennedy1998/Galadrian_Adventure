package cartography;

import Battle.adventurerework;
import Battle.monsterSelection;

/**
 * Created by citim on 5/2/2017.
 */
public class Mob extends Moving {
    public int range = 7;
    public String behavior;

    public Mob(int xPosition, int yPosition, Board board, String name){
        super(xPosition,yPosition,board,name);
        if (name.equals("player")) {
            speed = adventurerework.character1.getSpeed();
            behavior = "player";
        }
        else {
            speed = Integer.parseInt(monsterSelection.fetchBeastStats(name)[6]);
            behavior = BehaviorDatabase.getBehavior(this);
        }
    }
    public void run(){
            board.printTile(xPosition/30,yPosition/30,elevation);
            if(behavior.equals("player")){
                if(KeyboardListener.wPressed&&KeyboardListener.dPressed){
                    if(beat%2 == 0)moveUp();
                    else moveRight();
                }
                else if(KeyboardListener.wPressed&&KeyboardListener.aPressed){
                    if(beat%2 == 0)moveUp();
                    else moveLeft();
                }
                else if(KeyboardListener.sPressed&&KeyboardListener.dPressed){
                    if(beat%2 == 0)moveDown();
                    else moveRight();
                }
                else if(KeyboardListener.sPressed&&KeyboardListener.aPressed){
                    if(beat%2 == 0)moveDown();
                    else moveLeft();
                }
                else if (KeyboardListener.wPressed) moveUp();
                else if (KeyboardListener.sPressed) moveDown();
                else if (KeyboardListener.aPressed) moveLeft();
                else if (KeyboardListener.dPressed) moveRight();
                else if (KeyboardListener.ePressed) interact();
            }
            else{
                int temp = (int) Math.round(Math.random());
                int[] answer = BehaviorDatabase.respond(this);
                if (answer[0] == 1 && (temp == 1 || answer[1] == 0)) moveRight();
                else if (answer[0] == -1 && (temp == 1 || answer[1] == 0)) moveLeft();
                else if (answer[1] == -1 && (temp == 0 || answer[0] == 0)) moveUp();
                else if (answer[1] == 1 && (temp == 0 || answer[0] == 0)) moveDown();
            }
    }
    public void updateMovings() {//should only call for adam!
        for (int scan = 0; scan < board.movings.size(); scan++) {
//            if(!board.movings.get(scan).behavior.equals("player"))
            board.movings.get(scan).run();
//        }
        }
        if(lastBoard != null)
            for(int scan = 0; scan < lastBoard.movings.size(); scan++){
                try {
                    lastBoard.movings.get(scan).join();
                }catch (java.lang.InterruptedException e){
                    System.out.println(e);
                }
            }
    }
    public void interact(){
        int x = xPosition, y = yPosition;
        if(facing == 0) y-=15;
        else if(facing == 1) x+=15;
        else if(facing == 2) y+=15;
        else if(facing == 3) x-=15;
        if(board.findNonWall(x,y,elevation) != null){
            board.findNonWall(x,y,elevation).interactOnUse(this);
        }
    }
    public void openMenu(){
        System.out.println("you should code a menu when you stop debugging.");
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
