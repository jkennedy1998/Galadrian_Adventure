package cartography;public class Moving {
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

//    public void shiftHorizontally(int horizontalShift) {
//        xPosition += horizontalShift;
//    }
//
//    public void shiftVertically(int verticalShift) {
//        yPosition = verticalShift;
//    }

    public void questionNonWalls(){
        for (int scan = 0; scan < board.nonWalls.size(); scan++){
            NonWalls temp = board.nonWalls.get(scan);
            temp.interact(this);
        }
    }
    public void moveUp() {
        if (!board.questionCollision(xPosition, yPosition - 1, elevation)&& wallCollide &&!questionPlayerCollision(0,-1))
            yPosition--;
        questionNonWalls();
    }

    public void moveDown() {
        if (!board.questionCollision(xPosition, yPosition + 1, elevation)&& wallCollide &&!questionPlayerCollision(0,1))
            yPosition++;
        questionNonWalls();
    }

    public void moveLeft() {
        if (!board.questionCollision(xPosition - 1, yPosition, elevation)&& wallCollide &&!questionPlayerCollision(-1,0))
            xPosition--;
        questionNonWalls();
    }

    public void moveRight() {
        if (!board.questionCollision(xPosition + 1, yPosition,elevation)&& wallCollide &&!questionPlayerCollision(1,0))
            xPosition++;
        questionNonWalls();
    }

    public boolean questionPlayerCollision(int x, int y){ //up down left right in respective order starting at 0
        if (!playerCollide) return false;
        for(int scan = 0; scan < CollisionProject.movings.size(); scan++){
            Moving temp = CollisionProject.movings.get(scan);
            if (xPosition+x == temp.xPosition&&yPosition+y == temp.yPosition&&temp.playerCollide &&!(temp.name.equals(name))){
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