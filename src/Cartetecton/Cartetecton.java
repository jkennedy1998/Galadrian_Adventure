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
        board = new Board(width,height);
        board.walls.get(0).addWall(2,2);
        run();

    }
    public static void run(){
        while (true){
            board.printBoard();
            while(true){

            }
        }
    }
}
