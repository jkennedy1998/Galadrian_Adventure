package cartography;import java.util.ArrayList;

public class BoardDatabase {

    public static Board getBoard(String name){
        if (name.equalsIgnoreCase("square")) return square();
        if (name.equalsIgnoreCase("squareMultifloored")) return squareMultifloored();
        if (name.equalsIgnoreCase("hallway1")) return hallway1();
        if (name.equalsIgnoreCase("hallway2")) return hallway2();



        return null;
    }
    //how to display complex nonWall objects:
    //board door:
    //{
    //NonWalls door = NonwallsDatabase.makeNonWall(x,y,elevation,"board door");
    //door.board = board;
    //board.addNonWall(door)
    //}
    //  then you must set their links in the Map class.

    public static Board square(){ //20x20 square
        int[] wallX = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] wallY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        Walls walls = new Walls(wallX, wallY);
        return new Board(20,20,walls);
    }
    public static Board hallway1(){
        int[] wallX = {0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,0,0,9,9,9,0};
        int[] wallY = {0,0,0,0,0,0,0,0,0,0,5,5,5,5,5,5,5,5,5,5,1,2,4,1,3,4,3};
        Walls walls = new Walls(wallX,wallY);
        Board board = new Board(10,6,walls);
        {
            NonWalls door = NonWallsDatabase.makeNonWall(9,2,0,"board door");
            board.addNonWall(door);
            door.board = board;
        }
        {
            NonWalls door = NonWallsDatabase.makeNonWall(5,3,0,"closed door");
            board.addNonWall(door);
        }
        {
            NonWalls dartTrap = NonWallsDatabase.makeNonWall(1,3,0,"dart trap");
            dartTrap.facing = 1;
            board.addNonWall(dartTrap);
        }
        return board;
    }
    public static Board hallway2(){
        int[] wallX = {0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,0,0,9,9,9,9};
        int[] wallY = {0,0,0,0,0,0,0,0,0,0,5,5,5,5,5,5,5,5,5,5,1,2,4,1,2,3,4};
        Walls walls = new Walls(wallX,wallY);
        Board board = new Board(10,6,walls);
        {
            NonWalls door = NonWallsDatabase.makeNonWall(0,3,0,"board door");
            board.addNonWall(door);
            door.board = board;
        }

        {
            NonWalls pressurePlate = NonWallsDatabase.makeNonWall(4,3,0,"pressure plate");
            board.addNonWall(pressurePlate);
        }
        {
            NonWalls door = NonWallsDatabase.makeNonWall(6,3,0,"closed door");
            board.addNonWall(door);
        }

        return board;
    }
    public static Board squareMultifloored() { //20x20 square with 20x20 square on top
        ArrayList walls = new ArrayList();
        {
            int[] wallX = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] wallY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
            Walls wall = new Walls(wallX, wallY);
            wall.elevation = 0;
            walls.add(wall);
        }

        {
            int[] wallX = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] wallY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
            Walls wall = new Walls(wallX, wallY);
            wall.elevation = 1;
            walls.add(wall);
        }

        Board board = new Board(20, 20, walls);
        board.addNonWall(NonWallsDatabase.makeNonWall(5, 6, 0, "stairs up"));
        board.addNonWall(NonWallsDatabase.makeNonWall(5, 5, 1, "stairs down"));
        {
        NonWalls nonWallObject = NonWallsDatabase.makeNonWall(4, 6, 0, "sign");
        nonWallObject.description = "These stairs go up!";
        board.addNonWall(nonWallObject);
        }
        {NonWalls nonWallObject = NonWallsDatabase.makeNonWall(4, 5, 1, "sign");
        nonWallObject.description = "These stairs go down!";
        board.addNonWall(nonWallObject);
        }
        {NonWalls nonWallObject = NonWallsDatabase.makeNonWall(2, 2, 1, "chest");
            nonWallObject.description = "This is a chest";
            board.addNonWall(nonWallObject);
        }
        {
            Moving eve = new Moving(3,8,board,"eve", false);
            board.movings.add(eve);
        }

        return board;
    }
}
