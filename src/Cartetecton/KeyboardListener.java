package Cartetecton;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Screen.keyPressed = KeyEvent.getKeyText(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

