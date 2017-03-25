package cartography;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Created by Jared on 3/25/2017.
 */
public class KeyboardListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        CollisionProject.keyPressed = KeyEvent.getKeyText(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

