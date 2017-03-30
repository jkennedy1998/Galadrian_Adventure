package Cartetecton;
import java.awt.event.MouseEvent;

/**
 * Created by Jared on 3/25/2017.
 */
public class MouseListener implements java.awt.event.MouseListener {
    public void mouseEntered(MouseEvent mouseEvent){

    }
    public void mouseClicked(MouseEvent mouseEvent){

    }
    public void mouseReleased(MouseEvent mouseEvent){

    }
    public void mouseExited(MouseEvent mouseEvent){

    }
    public void mousePressed(MouseEvent mouseEvent){
        Cartetecton.window.xClick = mouseEvent.getX();
        Cartetecton.window.yClick = mouseEvent.getY();

    }
}
