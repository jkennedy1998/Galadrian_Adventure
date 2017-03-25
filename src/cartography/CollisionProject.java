package cartography;
import javax.swing.*;

public class CollisionProject {
    public static Moving adam;
    static Screen window = new Screen();
    public static String keyPressed = "P";


    public static void main(String args[]) {

        KeyboardListener keyboardListener = new KeyboardListener();
        window.addKeyListener(keyboardListener);
        Map.initializeMaps();
        adam = new Moving(3, 3, Map.currentBoard, "player", true);
        Map.currentBoard.movings.add(adam); //essential code to start maps and add a movable player!
        run();


    }

    public static void run() {
        while (true) {
            for (int scan = 0; scan < adam.board.movings.size(); scan++) {
                strive(adam.board.movings.get(scan));
            }

        }
    }

    public static void strive(Moving piece) {
        if (piece.behavior.equals("player")) {

            adam.board.printBoard();
            boolean boundKey = false;
            while(!boundKey){
                System.out.print("");
                if (keyPressed.equals("W") || keyPressed.equals("A") || keyPressed.equals("S")|| keyPressed.equals("D") || keyPressed.equals("Space")){
                    boundKey = true;
                }
            }
            if (keyPressed.equals("W")) piece.moveUp();
            else if (keyPressed.equals("S")) piece.moveDown();
            else if (keyPressed.equals("A")) piece.moveLeft();
            else if (keyPressed.equals("D")) piece.moveRight();
            else if (keyPressed.equals(" ")) {
            }
            keyPressed = "";
        } else {
            int temp = (int) Math.round(Math.random());
            int[] answer = BehaviorDatabase.respond(piece);
            if (answer[0] == 1 && (temp == 1 || answer[1] == 0)) piece.moveRight();
            if (answer[0] == -1 && (temp == 1 || answer[1] == 0)) piece.moveLeft();
            if (answer[1] == -1 && (temp == 0 || answer[0] == 0)) piece.moveUp();
            if (answer[1] == 1 && (temp == 0 || answer[0] == 0)) piece.moveDown();
        }
    }
}
