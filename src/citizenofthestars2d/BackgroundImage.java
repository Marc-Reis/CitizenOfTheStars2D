/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author reisma
 */
public class BackgroundImage {

    private float f_posx;
    private float f_posy;
    private float f_scrollSpeed;
    private int resolution = -1;

    private BufferedImage[] bgImages = new BufferedImage[4];
    private Image[] i = new Image[4];

    ;

    public BackgroundImage(float f_scrollSpeed) {

        this.f_scrollSpeed = f_scrollSpeed;
        String url0 = "/gfx/universe.jpg";
        String url1 = "/gfx/universe2.jpg";
        String url2 = "/gfx/universe_hf.jpg";
        String url3 = "/gfx/universe_hf2.jpg";

        try {
            InputStream ios = getClass().getResourceAsStream(url0);
            bgImages[0] = ImageIO.read(ios);
            InputStream ios2 = getClass().getResourceAsStream(url1);
            bgImages[1] = ImageIO.read(ios2);
            InputStream ios3 = getClass().getResourceAsStream(url2);
            bgImages[2] = ImageIO.read(ios3);
            InputStream ios4 = getClass().getResourceAsStream(url3);
            bgImages[3] = ImageIO.read(ios4);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //TODO - fine Tune ;-)
    public void update(float timeSinceLastFrame) {

        f_posx -= f_scrollSpeed * timeSinceLastFrame;
        int width = 0;
        if (resolution > 0) {
            width = resolution;
        } else {
            width = getBufferedImage(0).getWidth();
        }
        if (f_posx < (-width * 2)) {
            f_posx += width;
        }
    }

    public int getX() {
        return (int) f_posx;
    }

    public int getY() {
        return (int) f_posy;
    }

    public BufferedImage getBufferedImage(int i) {
        if (i < bgImages.length) {
            return bgImages[i];
        }
        return bgImages[0];
    }

    public Image getScaledImageAt(int resolution, int pos) {
        if (i[pos] == null && bgImages[pos] != null) {
            i[pos] = bgImages[pos].getScaledInstance(resolution, -1, Image.SCALE_AREA_AVERAGING);
        }
        return i[pos];
    }

    public Image getScaledImage(int resolution) {
        return getScaledImageAt(resolution, 0);
    }

}
