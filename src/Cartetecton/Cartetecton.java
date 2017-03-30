package Cartetecton;

public class Cartetecton {

    public static Screen window = new Screen();

    public static void main(String args[]){
        KeyboardListener keyboardListener = new KeyboardListener();
        MouseListener mouseListener = new MouseListener();
        window.addMouseListener(mouseListener);
        window.addKeyListener(keyboardListener);

    }
}
