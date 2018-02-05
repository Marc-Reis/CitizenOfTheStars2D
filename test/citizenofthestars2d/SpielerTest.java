/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MarcR
 */
public class SpielerTest {
    
    public SpielerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Spieler.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        float timeSinceLastFrame = 0.0F;
        Spieler instance = null;
        instance.update(timeSinceLastFrame);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoundingBox method, of class Spieler.
     */
    @Test
    public void testGetBoundingBox() {
        System.out.println("getBoundingBox");
        Spieler instance = null;
        Rectangle expResult = null;
        Rectangle result = instance.getBoundingBox();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class Spieler.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Spieler instance = null;
        Color expResult = null;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class Spieler.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        Color color = null;
        Spieler instance = null;
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayerName method, of class Spieler.
     */
    @Test
    public void testSetPlayerName() {
        System.out.println("setPlayerName");
        JFrame frame = null;
        Spieler instance = null;
        instance.setPlayerName(frame);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerName method, of class Spieler.
     */
    @Test
    public void testGetPlayerName() {
        System.out.println("getPlayerName");
        Spieler instance = null;
        String expResult = "";
        String result = instance.getPlayerName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLook method, of class Spieler.
     */
    @Test
    public void testGetLook() {
        System.out.println("getLook");
        Spieler instance = null;
        BufferedImage expResult = null;
        BufferedImage result = instance.getLook();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
