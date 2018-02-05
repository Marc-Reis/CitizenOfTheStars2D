/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.awt.Image;
import java.awt.image.BufferedImage;
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
public class BackgroundImageTest {
    
    public BackgroundImageTest() {
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
     * Test of update method, of class BackgroundImage.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        float timeSinceLastFrame = 0.0F;
        BackgroundImage instance = null;
        instance.update(timeSinceLastFrame);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class BackgroundImage.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        BackgroundImage instance = null;
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class BackgroundImage.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        BackgroundImage instance = null;
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBufferedImage method, of class BackgroundImage.
     */
    @Test
    public void testGetBufferedImage() {
        System.out.println("getBufferedImage");
        int i = 0;
        BackgroundImage instance = null;
        BufferedImage expResult = null;
        BufferedImage result = instance.getBufferedImage(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScaledImageAt method, of class BackgroundImage.
     */
    @Test
    public void testGetScaledImageAt() {
        System.out.println("getScaledImageAt");
        int resolution = 0;
        int pos = 0;
        BackgroundImage instance = null;
        Image expResult = null;
        Image result = instance.getScaledImageAt(resolution, pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScaledImage method, of class BackgroundImage.
     */
    @Test
    public void testGetScaledImage() {
        System.out.println("getScaledImage");
        int resolution = 0;
        BackgroundImage instance = null;
        Image expResult = null;
        Image result = instance.getScaledImage(resolution);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
