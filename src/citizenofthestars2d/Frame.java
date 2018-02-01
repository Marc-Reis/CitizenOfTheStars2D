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
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Wir erweitern die JFrame (Fenster) Klasse on Java nach unseren Wünschen.
 *
 * @author reisma
 */
public class Frame extends JFrame {

    private List<Bullet> bullets;
    private List<Enemy> enemys;
    private final List<Spieler> spieler;
    private DisplayMode mode;
    private final BackgroundImage bgi;

    private BufferStrategy strat;

    public Frame(List<Spieler> dieSpieler, BackgroundImage bgi, DisplayMode mode, List<Bullet> bullets, List<Enemy> enemys) throws HeadlessException { // Konstruktur Methode , die einen Fehler werfen kann!
        // Headless nennt man ein Programm wenn es keine GUI hat, so wie DOS (also nur Eingeabeaufforderung)
        super("Citizen of the stars 2D");   // Wir Übergeben der JFrame klasse Ihren Text für die titelleiste
        this.mode = null;

        this.spieler = dieSpieler;
        for (Spieler sp : spieler) {
            sp.setPlayerName(this);
        }

        this.bgi = bgi;
        this.bullets = bullets;
        this.enemys = enemys;
        addKeyListener(new Keyboard());   // und auch noch einen Tastatur Horcher hinzuzufügen.)
    }

    public void makeStrat() {
        createBufferStrategy(2);
        strat = getBufferStrategy();
    }

    /**
     * Wird aufgerufen wenn das Fenster neu gezeichnet wird. Veranlasst das Sich
     * mittel Grapics und Buffer das Bild neu Zeichnet
     */
    public void repaintScreen() {
        Graphics g = strat.getDrawGraphics();
        draw(g);
        g.dispose();
        strat.show();
    }

    private void draw(Graphics g) {
        g.drawImage(bgi.getBufferedImage(), bgi.getX(), 0, null);
        g.drawImage(bgi.getBufferedImage(),
                bgi.getX() + bgi.getBufferedImage().getWidth(),
                0, null);

        g.drawImage(bgi.getBufferedImage(), bgi.getX(), bgi.getBufferedImage().getHeight(), null);
        g.drawImage(bgi.getBufferedImage(),
                bgi.getX() + bgi.getBufferedImage().getWidth(),
                bgi.getBufferedImage().getHeight(), null);

        for (int i = 0; i < enemys.size(); i++) {
            Enemy e = enemys.get(i);
            g.drawImage(e.getLook(), e.getBounding().x, e.getBounding().y, e.getBounding().width, e.getBounding().height, null);

        }

        for (int i = 0; i < bullets.size(); i++) {
            Bullet b = bullets.get(i);
            g.drawImage(Bullet.getLook(), b.getBounding().x, b.getBounding().y, b.getBounding().width, b.getBounding().height, null);

        }

        for (Spieler sp : spieler) {
            g.setColor(sp.getColor());
            g.drawImage(sp.getLook(), sp.getBoundingBox().x, sp.getBoundingBox().y, null);
//                 g.fillRect( (int) sp.getBoundingBox().x, 
//                            (int) sp.getBoundingBox().y, 
//                            (int) sp.getBoundingBox().height, 
//                            (int) sp.getBoundingBox().width);

            g.drawString(sp.getPlayerName(),
                    sp.getBoundingBox().x,
                    sp.getBoundingBox().y);
        }
    }

    public void setDisplayMode(DisplayMode mode) {
        this.mode = mode;
    }

    public DisplayMode getDisplayMode() {
        return mode;
    }
}
