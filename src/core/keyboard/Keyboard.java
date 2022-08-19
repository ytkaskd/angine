package core.keyboard;

import core.AngineApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//You can use this class for implements keyboard capture
public class Keyboard implements KeyListener {

    //Keep last pressed key
    public int lastKey;

    //Also, you can use angineApp.addListenerToMainWindow(Keyboard); in your game
    public void keyboardAdd(AngineApp angineApp){
        angineApp.addListenerToMainWindow(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        lastKey = e.getKeyCode();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        lastKey = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        lastKey = e.getKeyCode();
    }
}
