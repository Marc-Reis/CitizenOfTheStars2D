/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author reisma
 */
public class Spieler {

    static int counter;

    private List<Bullet> l_bullets;
    private List<Enemy> l_enemys;
    private float timeSinceLastShoot = 0f;
    private final float SHOOTTIMEDELTA = 0.1f;
    private Rectangle boundingbox;
    private float f_posx;
    private float f_posy;
    private String name;

    private int up = KeyEvent.VK_W;
    private int down = KeyEvent.VK_S;
    private int left = KeyEvent.VK_A;
    private int right = KeyEvent.VK_D;
    private int shot = KeyEvent.VK_SPACE;

    int worldsize_x;
    int worldsize_y;

    private int speed = 300;
    private Color color = Color.RED;

    private BufferedImage look;
    private BufferedImage lookdead;

    private boolean alive = true;

    public Spieler(int pos_x, int pos_y, int size, int worldsize_x, int worldsize_y, List<Bullet> bullets, List<Enemy> enemys, int up, int down, int left, int right, int shot) {
        this(pos_x, pos_y, size, worldsize_x, worldsize_y, bullets, enemys);
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.shot = shot;
    }

    public Spieler(int pos_x, int pos_y, int size, int worldsize_x, int worldsize_y, List<Bullet> bullets, List<Enemy> enemys) {
        try {
            look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/raumschiffchen.png"));
            lookdead = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/raumschiff_kaputt.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        boundingbox = new Rectangle(pos_x, pos_y, size, size);

        f_posx = pos_x;
        f_posy = pos_y;

        this.worldsize_x = worldsize_x;
        this.worldsize_y = worldsize_y;

        counter++;
        name = "UnknownPlayer_" + counter;

        l_bullets = bullets;
        l_enemys = enemys;

    }

    public void update(float timeSinceLastFrame) {
        // Tastatur Eingabe verarbeiten, wenn hoch gedrückt wrude dann...

        if (!alive) {
            return;
        }

        timeSinceLastShoot += timeSinceLastFrame;

        float velocity = speed * timeSinceLastFrame;

        if (Keyboard.isKeyDown(up)) {
            f_posy -= velocity;
        }
        if (Keyboard.isKeyDown(down)) {
            f_posy += velocity;
        }
        if (Keyboard.isKeyDown(left)) {
            f_posx -= velocity;
        }
        if (Keyboard.isKeyDown(right)) {
            f_posx += velocity;
        }
        // Kein Übertreten!
        if (f_posx < 0) {
            f_posx = 0; // Links
        }
        if (f_posy < 0) {
            f_posy = 0; // Oben
        }
        if (f_posx > worldsize_x - boundingbox.width) {
            f_posx = worldsize_x - boundingbox.width;
        } // Rechts
        if (f_posy > worldsize_y - boundingbox.height) {
            f_posy = worldsize_y - boundingbox.height;
        } // Unten

        if (timeSinceLastShoot > SHOOTTIMEDELTA && Keyboard.isKeyDown(shot)) {
            timeSinceLastShoot = 0;
            float bposx = f_posx + look.getWidth() / 2 - Bullet.getLook().getWidth() / 2;
            float bposy = f_posy + look.getHeight() / 2 - Bullet.getLook().getHeight() / 2;
            l_bullets.add(new Bullet(bposx, bposy, 500f, 0, l_bullets));
        }
        // Neue Position für unsere bounding box, in der der Spieler steckt
        boundingbox.x = (int) f_posx;
        boundingbox.y = (int) f_posy;

        //System.out.println( f_posy +" "+ f_posx+" "+  velocity);
        for (Enemy e : l_enemys) {
            if (boundingbox.intersects(e.getBounding()) && e.isAlive()) {
                alive = false;
            }
        }
    }

    public Rectangle getBoundingBox() {
        return boundingbox;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    public void setPlayerName(JFrame frame) {
        name = JOptionPane.showInputDialog(frame, "What's your name?");
    }

    public String getPlayerName() {
        if (name == null) {
            name = "";
        }
        return name;
    }

    public BufferedImage getLook() {
        if (alive) {
            return look;
        } else {
            return lookdead;
        }
    }

}
