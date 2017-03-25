package cartography;

import java.util.ArrayList;

/**
 * Created by citim on 3/10/2017.
 */
public class Map {
    public static Board currentBoard;
    private static ArrayList<Board> boards = new ArrayList<>();

    private static Board getBoard(String boardName){return BoardDatabase.getBoard(boardName);}
    public static void initializeMaps(){
        System.out.println("Started map initialization!");
        boards.add(BoardDatabase.getBoard("spawn"));
        currentBoard = boards.get(0);
        System.out.println("Ended map initialization!");
    }
}
