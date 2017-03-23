package cartography;import java.util.ArrayList;

public class BoardDatabase {

    public static Board getBoard(String name){
        if (name.equalsIgnoreCase("spawn")) return spawn();



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

    public static Board spawn(){ //20x20 square
        Board board = new Board(15,15);
        {
            board.walls.get(0).addSquare(0,0,15,15);
            board.walls.get(0).addSquare(5,7,5,5);
            board.walls.get(0).deleteWall(5,9);
            NonWalls door = NonWallsDatabase.makeNonWall(5,9,0,"closed door");
            NonWalls pressurePlate = NonWallsDatabase.makeNonWall(8,8,0,"pressure plate");
            pressurePlate.link = door;
            board.addNonWall(door);
            board.addNonWall(pressurePlate);

        }
        return board;
    }

}
