package cartography;
import javax.swing.*;
import java.awt.*;


public class Screen extends JFrame {
    private static String[] log = {"","","","","","",""};
    final static String[] emptyLog = {"","","","","","",""};

    public Screen(){
        super("Galadria");
        setBackground(Color.BLACK);
        setSize(1280,720);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void refreshBoard(){
        Graphics g = getGraphics();
        super.paint(g);
        g.setColor(Color.GRAY);

        g.fillRect(0,0,530,530);
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
    public void print (String[] multipleLines){ //sends a String array with null for no lines printed.
        boolean printed = false;
        int linesToPrint = 6; //0 is one line to print
        if (multipleLines[0] == null) linesToPrint--;
        if (multipleLines[1] == null) linesToPrint--;
        if (multipleLines[2] == null) linesToPrint--;
        if (multipleLines[3] == null) linesToPrint--;
        if (multipleLines[4] == null) linesToPrint--;
        if (multipleLines[5] == null) linesToPrint--;
        if (multipleLines[6] == null) linesToPrint--;
        int place =0;
        while (!printed){

            if (log[place].equals("")&&log[place+linesToPrint].equals("")) { //prints to first line that is open. (counting from top) that also has adequate space to print beneath it
                log[place] = multipleLines[0];
                if (linesToPrint >= 1) log[place + 1] = multipleLines[1];
                if (linesToPrint >= 2) log[place + 2] = multipleLines[2];
                if (linesToPrint >= 3) log[place + 3] = multipleLines[3];
                if (linesToPrint >= 4) log[place + 4] = multipleLines[4];
                if (linesToPrint >= 5) log[place + 5] = multipleLines[5];
                if (linesToPrint >= 6) log[place + 6] = multipleLines[6];
                printed = true;
            }
            if (place==6){ //moves all lines up one and line 6 becomes blank.
                log[0] = log[1];
                log[1] = log[2];
                log[2] = log[3];
                log[3] = log[4];
                log[4] = log[5];
                log[5] = log[6];
                log[6]= "";
            }else  place++;
        }
        refreshLog();
    }
    private void refreshLog(){
        for (int place =0;place!=7;place++){
            System.out.println(log[place]);
        }

    }//make this refresh screen by printing Strings


}
