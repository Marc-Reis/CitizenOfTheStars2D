/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Wir erweitern die JFrame (Fenster) Klasse on Java nach unseren Wünschen.
 * @author reisma
 */
public class Frame extends JFrame {

    private Screen screen; // Unsere "mal fläche" ist eingetlich en JLabel gewesen...

    private boolean key_up = false;     // Wahrheitswerte um zu wissen ob "hoch" gedrückt wurde
    private boolean key_down = false;
    private boolean key_left = false;
    private boolean key_right = false;
    
    private final ArrayList<Spieler> spieler;
    private DisplayMode mode;
    private final BackgroundImage bgi;
    


    public Frame(ArrayList<Spieler> dieSpieler, BackgroundImage bgi, DisplayMode mode) throws HeadlessException { // Konstruktur Methode , die einen Fehler werfen kann!
                        // Headless nennt man ein Programm wenn es keine GUI hat, so wie DOS (also nur Eingeabeaufforderung)
        super("Citizen of the stars 2D");   // Wir Übergeben der JFrame klasse Ihren Text für die titelleiste
        this.mode = null;
        
        this.spieler = dieSpieler;
        for(Spieler sp : spieler){
           sp.setPlayerName(this); 
        }
        
        this.bgi = bgi;
        
        screen = new Screen();              // Wir erstellen nach dem Bauplan einen neune Screen also ein Objekt der Klasse
        screen.setBounds(0, 0, mode.getWidth(), mode.getHeight());  // Wir geben die Größe an, sollte zu den Angaben in der main passen.

        add(screen);                        // wir rufen eine Methode des JFrames auf und bitten darum unseren Screen ins fenster zu legen
        addKeyListener(new KeyHandler());   // und auch noch einen Tastatur Horcher hinzuzufügen.)

    }
    
    /**
     * Wird aufgerufen wenn das Fenster neu gezeichnet wird.
     * Veranlasst das Sich das JLabel auch neu Zeichnet - also unser Screen Objekt
     */
    public void repaintScreen() {
        getScreen().repaint();
    }

    /**
     * Eine "inner Class" 
     * macht man nicht oft, aber man kann eine Klasse in einer Klasse definieren
     * so kann man nur für den Frame gewisse Strukturen vorgeben.
     * Das meiste nehmen wir von der JLabel Klasse der Java leute und fügen nur hinzu
     * das wir ein Rechteck malen wollen.
     */
    private class Screen extends JLabel {

        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Die Elternklasse JLabel soll sich erst mal malen

            // dann fügen wir unser Rechteck hinzu.
            
           
            g.drawImage(bgi.getBufferedImage(), bgi.getX(),  0, null);
            g.drawImage(bgi.getBufferedImage(), 
                    bgi.getX() + bgi.getBufferedImage().getWidth(), 
                    0, null);
            
            g.drawImage(bgi.getBufferedImage(), bgi.getX(),  bgi.getBufferedImage().getHeight(), null);
            g.drawImage(bgi.getBufferedImage(), 
                    bgi.getX() + bgi.getBufferedImage().getWidth(), 
                    bgi.getBufferedImage().getHeight(), null);
            for(Spieler sp : spieler){
           
        
                g.setColor(sp.getColor());
                 g.fillRect( (int) sp.getBoundingBox().x, 
                            (int) sp.getBoundingBox().y, 
                            (int) sp.getBoundingBox().height, 
                            (int) sp.getBoundingBox().width);

                 g.drawString(sp.getPlayerName(),
                         sp.getBoundingBox().x, 
                         sp.getBoundingBox().y);
            }
            
        }

    }

    /**
     * Inner Class Teil 2 - unser eigener Tastatur Handhaber,
     * der die Vorgaben erfüllt die ein Interface KeyListener haben muss.
     * Das ist sowas wie eine Vorgabe Liste an Methoden die man haben muss,
     * allerdings muss das,  was in den Methoden drin passieren soll dann selbst programmieren.
     */
    private class KeyHandler implements KeyListener {

        /**
         * Wir überschreiben was beim drücken einer Taste passiert.
         * hat den nachteil das ohne unser zutun sonst nix mehr passiert
         * z.B. ESC oder ähnliches.
         * @param e 
         */
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
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                System.exit(0);
            }
        }
        /**
         * Gleiches spiel nur für das Loslassen einer Taste
         * @param e 
         */
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

        /** Brauchen wir nicht, müssen ihn aber trotzdem haben
         *  Deswegen rufen wir einfache die keyPressed der Eltnerklasse auf
         * die solls richten!
         * @param e 
         */
        @Override
        public void keyTyped(KeyEvent e) {
            keyPressed(e);
            
        }
    }

    
    // Jetzt kommen jede menge GET und SET Methoden - ein umweg um Werte einer Variable
    // zu erhalten oder zu setzen.
    // Der Umweg macht deswegen sinn, weil wir später mehr kontrolle darüber haben was passiert
    // z.B. das die Auflösung nicht negativ ist oder größer als 8K ...
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

    public void setDisplayMode(DisplayMode mode){
        this.mode = mode;
    }
    public DisplayMode getDisplayMode(){
        return mode;
    }
}