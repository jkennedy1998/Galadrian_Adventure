package cartography;
import Battle.*;
public class Moving {
    public int xPosition, yPosition, range = 7, elevation = 0, speed = 60, initialX, intitialY, tick = 0;
    boolean playerCollide = true, wallCollide = true;
    public Board board, lastBoard;
    public String name, behavior;
    public int[] lastPosition;

    public Moving(int xPosition, int yPosition, Board board, String name, boolean player) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        intitialY = yPosition;
        initialX = xPosition;
        this.board = board;
        this.name = name;
        lastPosition = new int[] {xPosition, yPosition};
        if (player) {
            speed = adventurerework.character1.getSpeed();
            behavior = "player";
        }
        else {
            speed = Integer.parseInt(monsterSelection.fetchBeastStats(name)[6]);
            behavior = BehaviorDatabase.getBehavior(this);
        }
    }

    public String getNameAbbreviation(){
        return name.substring(0,1);
    }

    public void questionNonWalls(){
        for (int scan = 0; scan < board.walls.size(); scan++){
            if (board.walls.get(scan).elevation == elevation)
                for(int subScan = 0; subScan < board.walls.get(scan).walls.size();subScan++){
            if (board.walls.get(scan).walls.get(subScan).nonWall){
                NonWalls temp = (NonWalls)board.walls.get(scan).walls.get(subScan);
                temp.interact(this);
            }
            }
        }
    }
    public void moveUp() {
        if (!board.questionCollision(xPosition, yPosition - 1, elevation)&& wallCollide &&!questionPlayerCollision(0,-1)&& inBoardBounds(0,-1))
            yPosition--;
        else if(name.equals("projectile")){

            board.removeMoving(this); //if its a projectile it kills it self
        }
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
        lastBoard = board;
    }

    public void moveDown() {
        if (!board.questionCollision(xPosition, yPosition + 1, elevation)&& wallCollide &&!questionPlayerCollision(0,1)&& inBoardBounds(0,1))
            yPosition++;
        else if(name.equals("projectile"))board.removeMoving(this); //if its a projectile it kills it self
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
        lastBoard = board;
    }

    public void moveLeft() {
        if (!board.questionCollision(xPosition - 1, yPosition, elevation)&& wallCollide &&!questionPlayerCollision(-1,0) && inBoardBounds(-1,0))
            xPosition--;
        else if(name.equals("projectile"))board.removeMoving(this); //if its a projectile it kills it self
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
        lastBoard = board;
    }

    public void moveRight() {
        if (!board.questionCollision(xPosition + 1, yPosition,elevation)&& wallCollide &&!questionPlayerCollision(1,0)&& inBoardBounds(1,0))
            xPosition++;
        else if(name.equals("projectile"))board.removeMoving(this); //if its a projectile it kills it self
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
        lastBoard = board;
    }
    public boolean inBoardBounds(int xMove, int yMove){
        if (xMove+xPosition > board.xDimension-1 || xMove+xPosition < 0) return false;
        if (yMove+yPosition > board.yDimension-1 || yMove+yPosition < 0) return false;
        return true;
    }
    public boolean questionPlayerCollision(int x, int y){ //up down left right in respective order starting at 0
        if (!playerCollide) return false;
        Moving temp;
        for(int scan = 0; scan < board.movings.size(); scan++){
            temp = board.movings.get(scan);
            if (xPosition+x == temp.xPosition&&yPosition+y == temp.yPosition&&temp.playerCollide &&!(temp.name.equals(name))&&elevation==temp.elevation){

                if(behavior.equals("player"))adventurerework.startEncounter(temp);
                else adventurerework.startEncounter(this);
                return true;
            }
        }
        return false;
    }
    public int questionWallCollision(int x, int y){ //0 if no collision, 1 if x collision in desired direction, 2 if y collision in desired direction
        boolean xCollide = false, yCollide = false;
        if (board.questionCollision(xPosition+x, yPosition, elevation)) xCollide = true;
        if (board.questionCollision(xPosition, yPosition+y, elevation)) yCollide = true;

        if(xCollide == yCollide)
            return 0;
        else if(xCollide) return 1;
        else return 2;
    }
}