package cartography;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Screen extends JFrame {
    private static String[] log = {" "," "," "," "," "," "," "," "," "," "," "," "," "," "};
    private final static String[] emptyLog = {" "," "," "," "," "," "," "," "," "," "," "," "," "," "};
    private ArrayList<String> buttons= new ArrayList <>();

    public Screen(){
        super("Galadria");
        setSize(1280,720);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        refreshBoard();
        print("you wake up lost, cold and alone.");
    }
    public void refreshBoard(){
        Graphics g = getGraphics();
        super.paint(g);
        g.setColor(Color.gray);
        g.fillRect(0,0,720,720);
        String[] buttons = {"hey","hi","hello","chhhello"};
        makeButtons(buttons);
        drawButtons();
        voidButtons();
    }
    public void makeButtons(String[] buttons){//for making buttons during map play

        for (int scan = 0; scan < buttons.length; scan++){
            this.buttons.add(buttons[scan]);
        }
    }
    public void voidButtons(){
        buttons = new ArrayList<>();
    }
    public void drawButtons(){ //needs to be in the box 720, 500 to 1280, 720 (its 560 by 220)
        Graphics g = getGraphics();
        super.paint(g);
        g.setColor(Color.darkGray);
        if(buttons.size() == 1){
            g.fillRect(725, 505, 580, 240);
            g.setColor(Color.black);
            g.drawString(buttons.get(0), 725 + (int) 540 / 2, 505 + (int) 200 / 2);
            }
        else if(buttons.size() == 2){
            g.fillRect(725, 505, 545, 100);
            g.fillRect(725, 610, 545, 100);
            g.setColor(Color.black);
            g.drawString(buttons.get(0), 725 + (int) 540 / 2, 505 + (int) 100 / 2);
            g.drawString(buttons.get(1), 725 + (int) 540 / 2, 610 + (int) 100 / 2);
        }else if (buttons.size() == 3){
            g.fillRect(725, 505, 545, 65);
            g.fillRect(725, 575, 545, 65);
            g.fillRect(725, 645, 545, 65);
            g.setColor(Color.black);
            g.drawString(buttons.get(0), 725 + (int) 540 / 2, 505 + (int) 65 / 2);
            g.drawString(buttons.get(1), 725 + (int) 540 / 2, 575 + (int) 65 / 2);
            g.drawString(buttons.get(2), 725 + (int) 540 / 2, 645 + (int) 65 / 2);
        }
        else if (buttons.size() == 4){
            g.fillRect(725, 505, 267, 100);
            g.fillRect(725, 610, 267, 100);
            g.fillRect(1000, 505, 267, 100);
            g.fillRect(1000, 610, 267, 100);
            g.setColor(Color.black);
            g.drawString(buttons.get(0), 725 + (int) 535 / 4, 505 + (int) 100 / 2);
            g.drawString(buttons.get(1), 725 + (int) 535 / 4, 610 + (int) 100 / 2);
            g.drawString(buttons.get(2), 725 + (int) 375 , 505 + (int) 100 / 2);
            g.drawString(buttons.get(3), 725 + (int) 375 , 610 + (int) 100 / 2);
        }
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

            g.drawString(log[place],750,(30+place*30));
        }

    }


}
