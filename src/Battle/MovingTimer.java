package Battle;

import cartography.Moving;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;

/**
 * Created by citim on 4/9/2017.
 */
public class MovingTimer {
    ArrayList<Moving> movings = new ArrayList<>();
    final int activeTime = 500;
    String board = adventurerework.adam.board.toString(); //used to determine if the board your on is the same board you have been on

    public MovingTimer(){
        for(int scan = 0; scan < adventurerework.adam.board.movings.size(); scan++){
            movings.add(adventurerework.adam.board.movings.get(scan));
        }
    }
    public Moving findNextMove(){
        validateMovings();
        for(int scan = 0; scan < movings.size(); scan++){
            movings.get(scan).tick+=movings.get(scan).speed;
        }
        Moving highestTick = movings.get(0);
        for(int scan = 0; scan < movings.size(); scan++) {
            if (movings.get(scan).tick > highestTick.tick) highestTick = movings.get(scan);

        }
        if(highestTick.tick < activeTime) return findNextMove();
        return highestTick;
    }
    private void validateMovings(){
        if(!adventurerework.adam.board.toString().equals(board)){ //validates if player has moved to a new board
            board =adventurerework.adam.board.toString();
            movings = new ArrayList<>();
            for(int scan = 0; scan < adventurerework.adam.board.movings.size(); scan++ ){
                movings.add(adventurerework.adam.board.movings.get(scan));
            }
        }
        for(int scan = 0; scan < movings.size(); scan++){
            if(movings.get(scan).tick > activeTime) movings.get(scan).tick -= activeTime; //makes sure no one is above 500 for their tick which would eventually cause out of bound errors
        }
        if(movings.size() != adventurerework.adam.board.movings.size()){
            for(int scan = 0; scan < adventurerework.adam.board.movings.size(); scan++){
                if (!movingInList(adventurerework.adam.board.movings.get(scan))) {
                    movings.add(adventurerework.adam.board.movings.get(scan)); //if its not in the list but is on the board, add it to the list!(ez!)
                }
            }
            boolean[] notAccountedFor = new boolean[movings.size()];
            for(int scan = 0; scan < movings.size(); scan++){//if its in the list but not the board, remove from list(not ez...)

                    if(movings.get(scan).board != adventurerework.hell){//always true because its a reference
                        notAccountedFor[scan] = false;

                }
            }
            for(int scan = notAccountedFor.length-1; scan >= 0; scan--){

                if(notAccountedFor[scan]){
                    movings.remove(scan);
                }
            }

        }
    }
    private boolean movingInList(Moving moving){
        for(int scan = 0; scan< movings.size(); scan++){
            if (moving == movings.get(scan)) return true;
        }
        return false;
    }
}