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
    private String url;
    
    private BufferedImage bgImage;
    private Image i;
    
    
    public BackgroundImage(float f_scrollSpeed){
        
        this.f_scrollSpeed = f_scrollSpeed;
        url = "/gfx/universe.jpg";
      
        try{
            InputStream ios = getClass().getResourceAsStream(url);
            bgImage = ImageIO.read( ios );
            
        }catch(Exception e){
            e.printStackTrace();
        }
                
    }
    
    public void update(float timeSinceLastFrame){
        
        f_posx -= f_scrollSpeed * timeSinceLastFrame;
        if(f_posx < - getBufferedImage().getWidth()){
         f_posx += getBufferedImage().getWidth();   
        }
    }
    
    public int getX(){
        return (int) f_posx;
    }
    
    public int getY(){
        return (int) f_posy;
    }
    
    public BufferedImage getBufferedImage(){
        return bgImage;
    }
    
    public Image  getScaledImage(){
        i = bgImage.getScaledInstance(3440, -1, Image.SCALE_AREA_AVERAGING);
        return i;
    }
    
}
