package cartography;
import Battle.*;
public class Moving {
    public int xPosition, yPosition, range = 7, elevation = 0, speed = 60, initialX, intitialY, tick = 0, facing = 2;
    boolean playerCollide = false, wallCollide = true, flying = false;
    public Board board, lastBoard;
    public String name, behavior;
    public int[] lastPosition;

    public Moving(int xPosition, int yPosition, Board board, String name, boolean player) {
        this.xPosition = 30*xPosition;
        this.yPosition = 30*yPosition;
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

                for(int subScan = 0; subScan < board.getWalls(elevation).walls.size();subScan++){
            if (board.getWalls(elevation).walls.get(subScan).nonWall){
                NonWalls temp = (NonWalls)board.getWalls(elevation).walls.get(subScan);
                temp.interact(this);
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
    private boolean questionFloor(int xPosition, int yPosition) {
        if (flying) return true;

                for (int subScan = 0; subScan < board.getWalls(elevation).floors.size(); subScan++) { //account for position you want to go in. not the position you are in
                    if (board.getWalls(elevation).floors.get(subScan).xPosition/30 == xPosition/30 && board.getWalls(elevation).floors.get(subScan).yPosition/30 == yPosition/30) {
                        return true;
                    }

            }
        return false;
    }
    public void moveUp() {
        facing = 0;
        if (!board.questionCollision(xPosition, yPosition - 1, elevation)&& wallCollide &&!questionPlayerCollision(0,-1)&& inBoardBounds(0,-1)&& questionFloor(xPosition,yPosition-1))
            yPosition--;
        else if(name.equals("projectile"))board.removeMoving(this);
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
        lastBoard = board;

    }

    public void moveDown() {
        facing = 2;
        if (!board.questionCollision(xPosition, yPosition + 1, elevation)&& wallCollide &&!questionPlayerCollision(0,1)&& inBoardBounds(0,1)&& questionFloor(xPosition, yPosition+1))
            yPosition++;
        else if(name.equals("projectile"))board.removeMoving(this); //if its a projectile it kills it self
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
        lastBoard = board;

    }

    public void moveLeft() {
        facing = 3;
        if (!board.questionCollision(xPosition - 1, yPosition, elevation)&& wallCollide &&!questionPlayerCollision(-1,0) && inBoardBounds(-1,0)&& questionFloor(xPosition-1, yPosition))
            xPosition--;
        else if(name.equals("projectile"))board.removeMoving(this); //if its a projectile it kills it self
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
        lastBoard = board;

    }

    public void moveRight() {
        facing = 1;
        if (!board.questionCollision(xPosition + 1, yPosition,elevation)&& wallCollide &&!questionPlayerCollision(1,0)&& inBoardBounds(1,0)&& questionFloor(xPosition+1, yPosition))
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
    public boolean questionPlayerCollision(int x, int y){
        if (!playerCollide) return false;
        Moving temp;
        for(int scan = 0; scan < board.movings.size(); scan++){
            temp = board.movings.get(scan);
            if ((xPosition+x)/30 == temp.xPosition/30&&(yPosition+y)/30 == temp.yPosition/30&&temp.playerCollide &&!(temp.name.equals(name))&&elevation==temp.elevation){
//                if(behavior.equals("player"))adventurerework.startEncounter(temp);
//                else adventurerework.startEncounter(this);
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