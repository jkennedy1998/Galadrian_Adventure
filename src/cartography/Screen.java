package cartography;
import javax.swing.*;
import java.awt.*;


public class Screen extends JFrame {
    private static String[] log = {"","","","","","","","","","","","","",""};
    private final static String[] emptyLog = {"","","","","","","","","","","",""};

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
                for (int scan = 0; scan < log.length-1; scan++){
                    log[scan] = log[scan+1];
                }
                log[log.length-1]= singleLine;
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
        g.setColor(Color.darkGray);
        g.fillRect(720,0,560,500);
        g.setColor(Color.black);
        g.setFont(new Font("Serif", Font.BOLD + Font.PLAIN, 20));
        for (int place =0;place < log.length;place++){

            g.drawString(log[place],750,(470-place*30));
            System.out.println(470-place*30);
        }

    }


}
