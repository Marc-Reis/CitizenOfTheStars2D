/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author reisma
 */
public class Frame extends JFrame {

    private Screen screen;

    private boolean key_up = false;
    private boolean key_down = false;
    private boolean key_left = false;
    private boolean key_right = false;

    private float player_posx = 300;
    private float player_posy = 400;
    private int player_size = 50;

    public Frame() throws HeadlessException {

        super("Citizen of the stars 2D");

        screen = new Screen();
        screen.setBounds(0, 0, 1024, 800);

        add(screen);
        addKeyListener(new KeyHandler());

    }

    public void repaintScreen() {
        getScreen().repaint();
    }

    private class Screen extends JLabel {

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.RED);
            g.fillRect((int) getPlayer_posx(), (int) getPlayer_posy(), getPlayer_size(), getPlayer_size());
        }

    }

    private class KeyHandler implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_S) {
                setKey_down(true);
            }
            if (e.getKeyCode() == KeyEvent.VK_W) {
                setKey_up(true);
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                setKey_right(true);
            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                setKey_left(true);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_S) {
                setKey_down(false);
            }
            if (e.getKeyCode() == KeyEvent.VK_W) {
                setKey_up(false);
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                setKey_right(false);
            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                setKey_left(false);
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            keyPressed(e);
            
        }
    }

    /**
     * @return the screen
     */
    public Screen getScreen() {
        return screen;
    }

    /**
     * @param screen the screen to set
     */
    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    /**
     * @return the key_up
     */
    public boolean isKey_up() {
        return key_up;
    }

    /**
     * @param key_up the key_up to set
     */
    public void setKey_up(boolean key_up) {
        this.key_up = key_up;
    }

    /**
     * @return the key_down
     */
    public boolean isKey_down() {
        return key_down;
    }

    /**
     * @param key_down the key_down to set
     */
    public void setKey_down(boolean key_down) {
        this.key_down = key_down;
    }

    /**
     * @return the key_left
     */
    public boolean isKey_left() {
        return key_left;
    }

    /**
     * @param key_left the key_left to set
     */
    public void setKey_left(boolean key_left) {
        this.key_left = key_left;
    }

    /**
     * @return the key_right
     */
    public boolean isKey_right() {
        return key_right;
    }

    /**
     * @param key_right the key_right to set
     */
    public void setKey_right(boolean key_right) {
        this.key_right = key_right;
    }

    /**
     * @return the player_posx
     */
    public float getPlayer_posx() {
        return player_posx;
    }

    /**
     * @param player_posx the player_posx to set
     */
    public void setPlayer_posx(float player_posx) {
        this.player_posx = player_posx;
    }

    /**
     * @return the player_posy
     */
    public float getPlayer_posy() {
        return player_posy;
    }

    /**
     * @param player_posy the player_posy to set
     */
    public void setPlayer_posy(float player_posy) {
        this.player_posy = player_posy;
    }

    /**
     * @return the player_size
     */
    public int getPlayer_size() {
        return player_size;
    }

    /**
     * @param player_size the player_size to set
     */
    public void setPlayer_size(int player_size) {
        this.player_size = player_size;
    }

}
