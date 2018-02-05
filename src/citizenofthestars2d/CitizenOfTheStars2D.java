/*
 * GPv3 Licence 
 *  Based upon Brotcrunsher "Spieleentwicklung in Java"
 */
package citizenofthestars2d;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;

/**
 * Hier entsteht unsere Hauptklasse Das wichtigste ist die main Methode, sie
 * ermöglicht es das Programm auszuführen
 *
 * @author reisma
 */
public class CitizenOfTheStars2D {

    /**
     * Die Mainmethode, sie erlaubt es das Programm auszuführen
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Bullet> l_bullets = new LinkedList<Bullet>();
        LinkedList<Spieler> spielerListe = new LinkedList();
        LinkedList<Enemy> enemyListe = new LinkedList();

        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = environment.getDefaultScreenDevice();
        DisplayMode m = device.getDisplayMode();
        Music music = new Music(null);

        Spieler spieler1 = new Spieler(300, 300, 50, m.getWidth(), m.getHeight(), l_bullets, enemyListe);
        Spieler spieler2 = new Spieler(400, 300, 50, m.getWidth(), m.getHeight(), l_bullets, enemyListe, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_CONTROL);
        Enemy e1 = new Enemy(400, 400, l_bullets);

        int speed = 500;

        BackgroundImage bgi = new BackgroundImage(speed);

        if (m == null) {
            m = new DisplayMode(1024, 800, 32, 60);
        }

        spielerListe.add(spieler1);
        spielerListe.add(spieler2);

        enemyListe.add(e1);
        // Der Rahmen für die Fläche in der unser Spiel stattfindet
        Frame f = new Frame(spielerListe, bgi, m, l_bullets, enemyListe);

        // ShowDisplayModes sdm = new ShowDisplayModes(f);       
        // sdm.setVisible(true);
        // Wir geben diesem Fenster einige Eigenschaften mit
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programm beenden, wenn man das Fenster schließt

        if (!f.isUndecorated()) {
            //  f.setUndecorated(true);  // Buggy?
        }

        f.setAlwaysOnTop(true);

        f.setSize(m.getWidth(), m.getHeight());       // Auflösung

        f.setVisible(true);         // Das Fenster wird für uns sichtbar dargestellt, statt nur im Speicher des PCs
        f.setResizable(false);      // Die größe des Fensters darf nicht verändert werden
        f.setLocationRelativeTo(null);

        if (m != null) {
            //Für den Vollbildmodus ssw
            device.setFullScreenWindow(f);
            //device.setDisplayMode(m);
        }

        // Eine variable vom Typ boolean, sie dient dazu den  "Game Loop" ab laufen zu halten
        boolean rungame = true;
        f.makeStrat(); // Buffer Strategie anlegen
        long timeLastFrame = System.currentTimeMillis();    // Zeit erfassen

        // Music Thread
        Thread musicThread = new Thread(
                new Runnable() {
                @Override
                    public void run() {
                        music.play();
                    }
                } );

        musicThread.start(); // Starte Thread

        // Game Loop - eine Endlosschleife in der das Spiel läuft
        while (rungame) {

            if (Keyboard.isKeyDown(KeyEvent.VK_ESCAPE)) {
                System.exit(0);
            }

            long timeThisFrame = System.currentTimeMillis();

            float timeSinceLastFrame
                    = ((float) (timeThisFrame - timeLastFrame)) / 1000.0f;

            timeLastFrame = timeThisFrame;

            bgi.update(timeSinceLastFrame);

            for (Enemy e : enemyListe) {
                e.update(timeSinceLastFrame);
            }

            for (int i = 0; i < l_bullets.size(); i++) {
                l_bullets.get(i).update(timeSinceLastFrame);
            }

            for (Spieler sp : spielerListe) {
                sp.update(timeSinceLastFrame);
            }

            // zeichnen des Frames mit der aktuallisierten Position des Rechtecks
            f.repaintScreen();

            // Damit unser system nicht einfriert, schläft unser programm kurz damti andere sachen auch noch berechnet werden können
            try {
                Thread.sleep(15); // Schlafe 15 millisecunden
            } catch (InterruptedException e) { //  Der Rechner (CPU) kann sich beschweren und verweigern das unser Programm schlaffen geht
                // für diesen fall "fangen" wir diesen fehler und geben Ihne einfach nur aus - unser programm läuft aber weiter.
                e.printStackTrace(); // ohne es abzufange stütrzt unser Programm in diesem Fall ab
            }

        }

    }

}
