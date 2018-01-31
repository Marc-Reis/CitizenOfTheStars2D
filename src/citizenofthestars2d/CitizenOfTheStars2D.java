/*
 * GPv3 Licence 
 *  Based upon Brotcrunsher "Spieleentwicklung in Java"
 */
package citizenofthestars2d;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *Hier entsteht unsere Hauptklasse
 * Das wichtigste ist die main Methode, sie ermöglicht es das Programm auszuführen
 * @author reisma
 */
public class CitizenOfTheStars2D {

    /**
     * Die Mainmethode, sie erlaubt es das Programm auszuführen
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int resolution_x = 1024;
        int resolution_y = 800;
        int speed = 500;
        
        DisplayMode m = new DisplayMode(800, 600, 32, 60);
        // Der Rahmen für die Fläche in der unser Spiel stattfindet
        
        ArrayList<Spieler> spielerListe = new ArrayList();
        
        Spieler spieler1 = new Spieler(300, 300, 50, m.getWidth(), m.getHeight());
        spielerListe.add(spieler1);
        
        Spieler spieler2 = new Spieler(300, 300, 50, m.getWidth(), m.getHeight());
        spielerListe.add(spieler2);
        
        BackgroundImage bgi;
        bgi = new BackgroundImage(speed);
        
        Frame f = new Frame(spielerListe, bgi, m );
        
        
        ShowDisplayModes sdm = new ShowDisplayModes(f);
        
        sdm.setVisible(true);
       
        // Wir geben diesem Fenster einige Eigenschaften mit
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Programm beenden, wenn man das Fenster schließt
        
        if(f.getDisplayMode() !=null){
            f.setUndecorated(true);
            f.setVisible(true);
        }
        
        f.setSize(resolution_x, resolution_y);       // Auflösung
  
        f.setVisible(true);         // Das Fenster wird für uns sichtbar dargestellt, statt nur im Speicher des PCs
        f.setResizable(false);      // Die größe des Fensters darf nicht verändert werden
        f.setLocationRelativeTo(null);
        
      

        // Eine variable vom Typ boolean, sie dient dazu den  "Game Loop" ab laufen zu halten
        boolean rungame = true;

        // Game Loop - eine Endlosschleife in der das Spiel läuft
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = environment.getDefaultScreenDevice();
        
        
        //m = f.getDisplayMode();
        
            
        if(m != null){
                System.out.println("Somethings there" + m);
                
                //Für den Vollbildmodus 
           //    device.setFullScreenWindow(f);
            //    device.setDisplayMode(m);
            }
        long timeLastFrame = System.currentTimeMillis();
        
        while (rungame) {
           
            long timeThisFrame = System.currentTimeMillis();
            
            float timeSinceLastFrame = 
                    ((float)(timeThisFrame - timeLastFrame)) / 1000.0f;
            
            timeLastFrame = timeThisFrame;
            
            spieler1.update( timeSinceLastFrame, f.isKey_up(), f.isKey_down(), 
                                f.isKey_left(), f.isKey_right());
            bgi.update(timeSinceLastFrame);
            
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
