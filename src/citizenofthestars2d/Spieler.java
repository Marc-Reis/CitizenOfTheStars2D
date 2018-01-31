/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author reisma
 */
public class Spieler {
    
    private Rectangle  boundingbox;
    private float f_posx;
    private float f_posy;
    private String name;
    
    int worldsize_x;
    int worldsize_y ;
            
    private int speed = 300;
    private Color color = Color.RED;
    
    static int counter;
    
    
    private BufferedImage look;

    
    public Spieler ( int pos_x, int pos_y, int size, int worldsize_x, int worldsize_y )  {
        try{
            look = ImageIO.read( getClass().getClassLoader().getResourceAsStream("gfx/raumschiffchen.png") );
        }catch(Exception e){e.printStackTrace();}
        
        boundingbox = new Rectangle(pos_x,pos_y, size, size);
       
       f_posx = pos_x;
       f_posy = pos_y;
       
       this.worldsize_x = worldsize_x;
       this.worldsize_y = worldsize_y;
       
       counter++;
       name = "UnknownPlayer_"+counter;
       
    }
    
    public void update(float timeSinceLastFrame, boolean up, boolean down, boolean left, boolean right){
        // Tastatur Eingabe verarbeiten, wenn hoch gedrückt wrude dann...
            
        float velocity = speed * timeSinceLastFrame;
            
            if (up) {
                f_posy -= velocity;
            }
            if (down) {
                f_posy += velocity;
            }
            if (left) {
                f_posx -= velocity;
            }
            if (right) {
                f_posx += velocity;
            }
            // Kein Übertreten!
            if( f_posx < 0 ) f_posx = 0; // Links
            if( f_posy < 0 ) f_posy = 0; // Oben
            if( f_posx > worldsize_x - boundingbox.width ) {
                f_posx = worldsize_x - boundingbox.width;
            } // Rechts
            if( f_posy > worldsize_y - boundingbox.height ) {
                f_posy = worldsize_y - boundingbox.height;
            } // Unten
            
            // Neue Position für unsere bounding box, in der der Spieler steckt
            boundingbox.x = (int) f_posx;
            boundingbox.y = (int) f_posy;
            
            //System.out.println( f_posy +" "+ f_posx+" "+  velocity);
    }
    
    public Rectangle getBoundingBox(){
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
    
    public void setPlayerName(JFrame frame){
         name = JOptionPane.showInputDialog(frame, "What's your name?");
    }
    
    public String getPlayerName(){
        return name;
    }
  
    public BufferedImage getLook(){
        return look;
    }
    
}
