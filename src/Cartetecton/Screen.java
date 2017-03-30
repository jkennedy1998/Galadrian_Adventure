package Cartetecton;

import javax.swing.*;

/**
 * Created by citim on 3/27/2017.
 */
public class Screen extends JFrame {
    int xClick = -1; int yClick = -1;
    int buttonClicked = 0;

    public Screen(){
        super("Galadria");
        setSize(1280,720);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
