package cartography;import javax.swing.*;
import java.util.ArrayList;

public class CollisionProject {
    public ArrayList emptyTime = new ArrayList();
    public ArrayList time = new ArrayList();
    public static Moving adam;

    public static void main(String args[]){

        adam = new Moving(3,5,Map.currentBoard,"player", true);
        Map.currentBoard.movings.add(adam);

        run();
    }
    public static void run(){
        boolean done = false;
        while(!done){

        for (int scan = 0; scan < adam.board.movings.size(); scan++){
            strive(adam.board.movings.get(scan));
        }
        }
    }
    public static void strive(Moving piece){

        if (piece.behavior.equals("player")) {
            String[] buttons = {"up", "down", "left", "right", "skip"};
            int answer = JOptionPane.showOptionDialog(null,adam.board.printBoard(), "board",
                    JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
            if (answer == 0) piece.moveUp();
            if (answer == 1) piece.moveDown();
            if (answer == 2) piece.moveLeft();
            if (answer == 3) piece.moveRight();
            if (answer == 4) {}
        }else{
            int temp = (int)Math.round(Math.random());
            int[] answer = BehaviorDatabase.respond(piece);
            if (answer[0] == 1 && (temp ==1 || answer[1] == 0) ) piece.moveRight();
            if (answer[0] == -1 && (temp ==1 || answer[1] == 0) ) piece.moveLeft();
            if (answer[1] == -1 && (temp == 0 || answer[0] == 0) ) piece.moveUp();
            if (answer[1] == 1 && (temp == 0 || answer[0] == 0) ) piece.moveDown();
        }
        }

    }

