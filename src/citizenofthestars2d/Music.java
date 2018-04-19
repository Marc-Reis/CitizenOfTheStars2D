/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javazoom.jl.player.Player;

/**
 * Using http://www.javazoom.net/javalayer/sources.html to play Music (mp3,
 * wav..)
 *
 * @author MarcR
 */
public class Music {

    List<String> mp3s = new ArrayList<String>();
    Player musicPlayer;

    public Music(String[] mp3Paths) {

        mp3s.add(new String("gfx/Privateer_-_Pleasure_Planet.mp3"));
        try {
            musicPlayer = new Player(getClass().getClassLoader().getResourceAsStream(mp3s.get(0)));
            //media = new Media(new File(mp3s.get(0)).toURI().toString());               
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void play() {
        try {
            musicPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            musicPlayer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
