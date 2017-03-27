package cartography;
import java.util.ArrayList;
public class Map {
    public static Board currentBoard;
    private static ArrayList<Board> boards = new ArrayList<>();

    private static Board getBoard(String boardName){return BoardDatabase.getBoard(boardName);}
    public static void initializeMaps(){
        System.out.println("Started map initialization!");
        boards.add(getBoard("spawn"));
        boards.add(getBoard("yaun-ti cave entrance"));
        boards.add(getBoard("yaun-ti cave"));
        boards.get(1).findNonWall(10,0,0).link = boards.get(2).findNonWall(3,9,0);
        boards.get(2).findNonWall(3,9,0).link = boards.get(1).findNonWall(10,0,0);
        currentBoard = boards.get(1);
        System.out.println("Ended map initialization!");
    }
}
