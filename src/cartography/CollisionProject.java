package cartography;import javax.swing.*;
import java.util.ArrayList;

public class CollisionProject {
    public static Board testBoard;
    public static ArrayList<Moving> movings = new ArrayList<>();
    public ArrayList emptyTime = new ArrayList();
    public ArrayList time = new ArrayList();
    public static void main(String args[]){

        testBoard = new Board(BoardDatabase.getBoard("squareMultifloored"));
        Moving adam = new Moving(3,5,testBoard,"player", true);
        movings.add(adam);
        Moving eve = new Moving(3,8,testBoard,"eve", false);
        movings.add(eve);
        Moving steve = new Moving(4,8,testBoard,"steve", false);
        movings.add(steve);
        run();
    }
    public static void run(){
        boolean done = false;
        while(!done){
        for (int scan = 0; scan < movings.size(); scan++){
            strive(movings.get(scan));
        }
        }
    }
    public static void strive(Moving piece){

        if (piece.behavior.equals("player")) {
            String[] buttons = {"up", "down", "left", "right", "skip"};
            int answer = JOptionPane.showOptionDialog(null, testBoard.printBoard(movings), "board",
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

