package Cartetecton;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    public static int xClick = -1; int yClick = -1;
    public static String keyPressed = "";
    int buttonClicked = 0; //0 is left, 1 is mid, 2 is right

    public Screen(int width, int height){
        super("Galadria");
        setSize(width*25,height*25);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        refreshBoard();
        Graphics g = getGraphics();
        super.paint(g);
        g.setColor(Color.black);
        g.drawString("oh shit!",60,60);

    }
    public void drawCharacter(int xPosition, int yPosition, String name){
        System.out.println(name);
        Graphics g = getGraphics();
        super.paint(g);
        g.setFont(new Font("Serif", Font.BOLD + Font.PLAIN, 20));
        g.drawString(name, (xPosition * 25) + 30, (yPosition * 25) + 100);
    }
    public void refreshBoard(){
        Graphics g = getGraphics();
        super.paint(g);
        g.setColor(Color.gray);
        g.fillRect(0,0,60,60);
    }
}
