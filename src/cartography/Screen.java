package cartography;
import javax.swing.*;
import java.awt.*;


public class Screen extends JFrame {
    private static String[] log = {"","","","","","",""};
    final static String[] emptyLog = {"","","","","","",""};

    public Screen(){
        super("Galadria");
        setSize(1280,720);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        refreshBoard();
    }
    public void refreshBoard(){
        Graphics g = getGraphics();
        super.paint(g);
        g.setColor(Color.gray);
        g.fillRect(0,0,720,720);
        g.setColor(Color.BLACK);
        g.fillRect(720,500,560,220);
        g.setColor(Color.cyan);
        g.fillRect(720,0,560,500);
    }
    public void drawCharacter(int xPosition, int yPosition, String name){
        Graphics g = getGraphics();
        super.paint(g);
        g.setFont(new Font("Serif", Font.BOLD + Font.PLAIN, 20));
        g.drawString(name, (xPosition * 30) + 30, (yPosition * 30) + 70);
}
    public  void voidLines(){log = emptyLog;}
    public  void print(String singleLine){
        boolean printed = false;
        int place =0;
        while (!printed){
            if (log[place].equals("")) { //prints to first line that is open. (counting from top)
                log[place] = singleLine;
                printed = true;
            }
            if (place==6){ //prints to last line as no others are open. moves all other lines up one and line 0 is reassigned.
                log[0] = log[1];
                log[1] = log[2];
                log[2] = log[3];
                log[3] = log[4];
                log[4] = log[5];
                log[5] = log[6];
                log[6]= singleLine;
                printed=true;
            }else {
                place++;
            }
        }
        refreshLog();
    }
    public void print (String[] multipleLines) { //sends a String array with null for no lines printed.
    for(int scan = 0; scan < multipleLines.length; scan++){
        print(multipleLines[scan]);
    }
    }

    private void refreshLog(){
        Graphics g = getGraphics();
        super.paint(g);
        g.setColor(Color.cyan);
        g.fillRect(720,0,560,500);
        g.setColor(Color.black);
        g.setFont(new Font("Serif", Font.BOLD + Font.PLAIN, 20));
        for (int place =0;place!=7;place++){
            g.drawString(log[place],750,70+place*30);
        }

    }//make this refresh screen by printing Strings


}
