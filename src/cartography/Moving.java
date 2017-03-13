package cartography;
public class Moving {
    int xPosition, yPosition, range = 7, elevation = 0, speed = 60;
    boolean playerCollide = true, wallCollide = true;
    Board board;
    String name, behavior;
    int[] lastPosition;

    public Moving (){
        name = "empty";
    }
    public Moving(int xPosition, int yPosition, Board board, String name, boolean player) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.board = board;
        this.name = name;
        lastPosition = new int[] {xPosition, yPosition};
        if (player)
            behavior = "player";
        else
            behavior = BehaviorDatabase.getBehavior(this);
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
        if (!board.questionCollision(xPosition, yPosition - 1, elevation)&& wallCollide &&!questionPlayerCollision(0,-1))
            yPosition--;
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
    }

    public void moveDown() {
        if (!board.questionCollision(xPosition, yPosition + 1, elevation)&& wallCollide &&!questionPlayerCollision(0,1))
            yPosition++;
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
    }

    public void moveLeft() {
        if (!board.questionCollision(xPosition - 1, yPosition, elevation)&& wallCollide &&!questionPlayerCollision(-1,0))
            xPosition--;
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
    }

    public void moveRight() {
        if (!board.questionCollision(xPosition + 1, yPosition,elevation)&& wallCollide &&!questionPlayerCollision(1,0))
            xPosition++;
        questionNonWalls();
        lastPosition[0] = xPosition;
        lastPosition[1] = yPosition;
    }

    public boolean questionPlayerCollision(int x, int y){ //up down left right in respective order starting at 0
        if (!playerCollide) return false;
        for(int scan = 0; scan < board.movings.size(); scan++){
            Moving temp = board.movings.get(scan);
            if (xPosition+x == temp.xPosition&&yPosition+y == temp.yPosition&&temp.playerCollide &&!(temp.name.equals(name))&&elevation==temp.elevation){
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