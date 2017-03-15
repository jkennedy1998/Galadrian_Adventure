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
        boards.add(getBoard("hallway1"));//0
        boards.add(getBoard("hallway2"));//1
        boards.get(0).findNonWall(9,2,0).link = (boards.get(1).findNonWall(0,3,0));
        boards.get(1).findNonWall(0,3,0).link = (boards.get(0).findNonWall(9,2,0));
        boards.get(1).findNonWall(4,3,0).link = boards.get(1).findNonWall(6,3,0);
        System.out.println("Ended map initialization!");
        currentBoard = boards.get(0);
    }
}
