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
public class EnemyTest {
    
    public EnemyTest() {
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
     * Test of update method, of class Enemy.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        float timeSinceLastFrame = 0.0F;
        Enemy instance = null;
        instance.update(timeSinceLastFrame);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBounding method, of class Enemy.
     */
    @Test
    public void testGetBounding() {
        System.out.println("getBounding");
        Enemy instance = null;
        Rectangle expResult = null;
        Rectangle result = instance.getBounding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLook method, of class Enemy.
     */
    @Test
    public void testGetLook() {
        System.out.println("getLook");
        Enemy instance = null;
        BufferedImage expResult = null;
        BufferedImage result = instance.getLook();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAlive method, of class Enemy.
     */
    @Test
    public void testIsAlive() {
        System.out.println("isAlive");
        Enemy instance = null;
        boolean expResult = false;
        boolean result = instance.isAlive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
