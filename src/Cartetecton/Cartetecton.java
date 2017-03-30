package Cartetecton;

import javax.swing.*;

public class Cartetecton {

    public static Screen window;
    public static Board board;

    public static void main(String args[]){
        int width = Integer.parseInt(JOptionPane.showInputDialog("please enter a width"));
        int height = Integer.parseInt(JOptionPane.showInputDialog("please enter a height"));
        window = new Screen(width,height);
        KeyboardListener keyboardListener = new KeyboardListener();
        MouseListener mouseListener = new MouseListener();
        window.addMouseListener(mouseListener);
        window.addKeyListener(keyboardListener);
        run();
        board = new Board(width,height);
        board.walls.get(0).addWall(0,0);

    }
    public static void run(){
        while (true){
            board.printBoard();
            if(window.xClick != -1){

            }
        }
    }
}
