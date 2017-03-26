package cartography;
import Battle.adventurerework;

import java.awt.event.MouseEvent;

/**
 * Created by Jared on 3/25/2017.
 */
public class MouseListener implements java.awt.event.MouseListener {
    public int xPosition = 0, yPosition = 0;
    public void mouseEntered(MouseEvent mouseEvent){

    }
    public void mouseClicked(MouseEvent mouseEvent){
        adventurerework.clicked = true;
        xPosition = mouseEvent.getX();
        yPosition = mouseEvent.getY();
    }
    public void mouseReleased(MouseEvent mouseEvent){

    }
    public void mouseExited(MouseEvent mouseEvent){

    }
    public void mousePressed(MouseEvent mouseEvent){

    }
}
