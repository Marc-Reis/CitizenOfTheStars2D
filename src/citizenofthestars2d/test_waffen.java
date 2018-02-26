/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author reisma
 */
public class test_waffen {

    public static void main(String args[]) {

        Random r = new Random();
        int anzahlWaffen = 100;
        String name = "Sword of Death";
        String beschreibung = "Deadly";
        float gewicht = 0;
        float schaden = 0;
        LinkedList<Weapon> l_weapons =  new LinkedList();

        for (int i = 0; i < anzahlWaffen; i++) {
            name += i;
            gewicht = r.nextFloat() * 100;
            schaden = r.nextFloat() * 400;

            Weapon w = new Weapon(name, beschreibung, gewicht, schaden);
            
            l_weapons.add(w);
            
        }
        
        for( Weapon w2 : l_weapons){
            System.out.println(w2);
        }
    }

}
