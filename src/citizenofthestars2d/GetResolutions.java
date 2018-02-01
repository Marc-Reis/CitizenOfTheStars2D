/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;

/**
 *
 * @author reisma
 */
public class GetResolutions {

    public static void main(String args[]) {
        DisplayMode[] possibleModes = null;

        GraphicsEnvironment environment
                = GraphicsEnvironment.getLocalGraphicsEnvironment();

        possibleModes = environment.getDefaultScreenDevice().getDisplayModes();

        for (DisplayMode mode : possibleModes) {
            System.out.println(
                    mode.getWidth() + " x; " + mode.getHeight() + " y; "
                    + mode.getBitDepth() + " Bit; " + mode.getRefreshRate() + " Hz");
        }
    }

}
