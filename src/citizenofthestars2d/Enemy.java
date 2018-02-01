/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author MarcR
 */
public class Enemy {

    private static BufferedImage[] looks = new BufferedImage[4];
    private static BufferedImage lookdead;
    private static float NEEDEDANITIME = 1;
    private float aniTime = 0;
    private float posx;
    private float posy;
    private Rectangle bounding;
    private List<Bullet> bullets;
    private boolean alive = true;

    static {
        try {

            looks[0] = ImageIO.read(Bullet.class.getClassLoader().getResourceAsStream("gfx/enemy1.png"));
            looks[1] = ImageIO.read(Bullet.class.getClassLoader().getResourceAsStream("gfx/enemy2.png"));
            looks[2] = ImageIO.read(Bullet.class.getClassLoader().getResourceAsStream("gfx/enemy3.png"));
            looks[3] = looks[1];
            lookdead = ImageIO.read(Bullet.class.getClassLoader().getResourceAsStream("gfx/enemy_kaputt.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Enemy(float x, float y, List<Bullet> bullets) {
        this.posx = x;
        this.posx = y;
        this.bullets = bullets;
        bounding = new Rectangle((int) x, (int) y, looks[0].getWidth(), looks[0].getHeight());

    }

    public void update(float timeSinceLastFrame) {
        aniTime += timeSinceLastFrame;
        if (aniTime > NEEDEDANITIME) {
            aniTime = 0;
        }

        for (int i = 0; i < bullets.size(); i++) {
            Bullet b = bullets.get(i);
            if (bounding.intersects((b.getBounding()))) {
                alive = false;
            }
        }

    }

    public Rectangle getBounding() {
        return bounding;
    }

    public BufferedImage getLook() {
        if (looks.length == 0) {
            return null;
        }
        if (!alive) {
            return lookdead;
        }
        for (int i = 0; i < looks.length; i++) {
            if (aniTime < (float) NEEDEDANITIME / looks.length * (i + 1)) {
                return looks[i];
            }
        }
        return looks[looks.length - 1];
    }

    public boolean isAlive() {
        return alive;
    }
}
