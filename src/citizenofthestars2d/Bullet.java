/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author MarcR
 */
public class Bullet {

    List<Bullet> bullets = new LinkedList<Bullet>();
    private static BufferedImage look;
    private Rectangle bounding;

    private float f_posx;
    private float f_posy;
    private float f_speedx;
    private float f_speedy;

    private float timeAlive;
    private final float TIMETOLIVE = 5;

    static {
        try {
            look = ImageIO.read(Bullet.class.getClassLoader().getResourceAsStream("gfx/schuss.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bullet(float x, float y, float speedx, float speedy, List<Bullet> bullets) {
        this.f_posx = x;
        this.f_posy = y;
        this.f_speedx = speedx;
        this.f_speedy = speedy;
        this.bullets = bullets;

        bounding = new Rectangle((int) f_posx, (int) f_posy, look.getWidth(), look.getWidth());
    }

    public void update(float timeSinceLastFrame) {
        timeAlive += timeSinceLastFrame;

        if (timeAlive > TIMETOLIVE) {
            bullets.remove(this);
        }

        f_posx += f_speedx * timeSinceLastFrame;
        f_posy += f_speedy * timeSinceLastFrame;

        bounding.x = (int) f_posx;
        bounding.y = (int) f_posy;
    }

    public Rectangle getBounding() {
        return bounding;
    }

    public static BufferedImage getLook() {
        return look;
    }

}
