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
    }

    @Override
    public void keyReleased(KeyEvent e) {

            adventurerework.keyPressed = "";

    }
}

