package Cartetecton;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    public static int xClick = -1; int yClick = -1;
    public static String keyPressed = "";
    public static int buttonClicked = 0; //1 is left, 2 is mid?, 3 is right

    public Screen(int width, int height){
        super("Galadria");
        setSize(width*25,height*25);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Graphics g = getGraphics();
        super.paint(g);
        g.setColor(Color.black);
        g.setFont(new Font("Serif", Font.BOLD + Font.PLAIN, 60));
        g.drawString("this should print!",getX()/2,getY()/2);
        System.out.println(g);


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
