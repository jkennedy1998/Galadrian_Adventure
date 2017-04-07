package Cartetecton;

import javax.swing.*;

public class Cartetecton {

    public static Screen window;
    public static Board board;

    public static void main(String args[]){
        int width = Integer.parseInt(JOptionPane.showInputDialog("please enter a width"));
        int height = Integer.parseInt(JOptionPane.showInputDialog("please enter a height"));
        board = new Board(width,height);
        window = new Screen(width,height);
        window.addMouseListener(new MouseListener());
        window.addKeyListener(new KeyboardListener());


    }
    public static void run(){
        while (true){
            board.printBoard();
            while(true){

            }
        }
    }
}
