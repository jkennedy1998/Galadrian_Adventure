package cartography;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Battle.adventurerework;
public class KeyboardListener implements KeyListener {
    public static boolean wPressed = false, aPressed = false, sPressed = false, dPressed = false, ePressed = false;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("W")) wPressed = true;
        else if(KeyEvent.getKeyText(e.getKeyCode()).equals("A")) aPressed = true;
        else if(KeyEvent.getKeyText(e.getKeyCode()).equals("S")) sPressed = true;
        else if(KeyEvent.getKeyText(e.getKeyCode()).equals("D")) dPressed = true;
        else if(KeyEvent.getKeyText(e.getKeyCode()).equals("E")) ePressed = true;


    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("W")) wPressed = false;
        else if(KeyEvent.getKeyText(e.getKeyCode()).equals("A")) aPressed = false;
        else if(KeyEvent.getKeyText(e.getKeyCode()).equals("S")) sPressed = false;
        else if(KeyEvent.getKeyText(e.getKeyCode()).equals("D")) dPressed = false;
        else if(KeyEvent.getKeyText(e.getKeyCode()).equals("E")) ePressed = false;


    }
}

