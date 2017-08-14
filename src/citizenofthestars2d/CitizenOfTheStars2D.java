/*
 * GPv3 Licence 
 *  Based upon Brotcrunsher "Spieleentwicklung in Java"
 */
package citizenofthestars2d;

import javax.swing.JFrame;

/**
 *
 * @author reisma
 */
public class CitizenOfTheStars2D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //initialisieren();
        Frame f = new Frame();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1024, 800);
        f.setVisible(true);
        f.setResizable(false);

        boolean rungame = true;

        while (rungame) {

            //berechnen();
            int speed = 5;

            if (f.isKey_up()) {
                f.setPlayer_posy(f.getPlayer_posy() - speed);
            }
            if (f.isKey_down()) {
                f.setPlayer_posy(f.getPlayer_posy() + speed);
            }
            if (f.isKey_left()) {
                f.setPlayer_posx(f.getPlayer_posx() - speed);
            }
            if (f.isKey_right()) {
                f.setPlayer_posx(f.getPlayer_posx() + speed);
            }

            //draw();
            f.repaintScreen();

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
