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
        currentBoard = boards.get(1);
        boards.add(getBoard("yaun-ti cave"));
        boards.get(1).findNonWall(10,0,0).link = boards.get(2).findNonWall(3,9,0);
        boards.get(2).findNonWall(3,9,0).link = boards.get(1).findNonWall(10,0,0);
        boards.add(getBoard("yaun-ti cave t"));
        boards.get(2).findNonWall(4,0,0).link = boards.get(2).findNonWall(13,11,0);
        boards.get(3).findNonWall(13,11,0).link = boards.get(1).findNonWall(4,0,0);
        System.out.println("Ended map initialization!");
    }
}
