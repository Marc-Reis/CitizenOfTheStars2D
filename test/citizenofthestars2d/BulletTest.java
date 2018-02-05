/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.awt.Rectangle;
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
public class BulletTest {
    
    public BulletTest() {
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
     * Test of update method, of class Bullet.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        float timeSinceLastFrame = 0.0F;
        Bullet instance = null;
        instance.update(timeSinceLastFrame);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBounding method, of class Bullet.
     */
    @Test
    public void testGetBounding() {
        System.out.println("getBounding");
        Bullet instance = null;
        Rectangle expResult = null;
        Rectangle result = instance.getBounding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLook method, of class Bullet.
     */
    @Test
    public void testGetLook() {
        System.out.println("getLook");
        BufferedImage expResult = null;
        BufferedImage result = Bullet.getLook();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
