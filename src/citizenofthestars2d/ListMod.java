/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author MarcR
 */
public class ListMod {

    List<Spieler> list = new LinkedList();
    int pos_x = 5, pos_y = 5, size = 10, worldsize_x = 800, worldsize_y = 900;

    public static void main(String args[]) {
        ListMod myObjectOfListMod = new ListMod();
    }

    public ListMod() {

        int size = list.size();
        for (int i = 0; i < size; i++) {

            list.remove(6);
            System.out.println(list);
        }

        for (Spieler s : list) {
            list.remove(1);
        }
    }
}
