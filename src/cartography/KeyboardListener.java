package cartography;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Battle.adventurerework;
public class KeyboardListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        adventurerework.keyPressed = KeyEvent.getKeyText(e.getKeyCode());
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("W")) adventurerework.wPressed = true;
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("A")) adventurerework.aPressed = true;
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("S")) adventurerework.sPressed = true;
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("D")) adventurerework.dPressed = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {

            adventurerework.keyPressed = "";
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("W")) adventurerework.wPressed = false;
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("A")) adventurerework.aPressed = false;
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("S")) adventurerework.sPressed = false;
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("D")) adventurerework.dPressed = false;


    }
}

