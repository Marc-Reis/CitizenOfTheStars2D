/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author MarcR
 */
public class Keyboard implements KeyListener {

    private static boolean[] keys = new boolean[1024];

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode >= 0 && keyCode < keys.length) {
            keys[keyCode] = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode >= 0 && keyCode < keys.length) {
            keys[keyCode] = false;
        }
    }

    public static boolean isKeyDown(int keycode) {
        if (keycode >= 0 && keycode < keys.length) {
            return keys[keycode];
        }
        return false;
    }

}
