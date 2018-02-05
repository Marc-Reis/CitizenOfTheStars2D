/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

import java.awt.DisplayMode;
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
public class FrameTest {
    
    public FrameTest() {
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
     * Test of makeStrat method, of class Frame.
     */
    @Test
    public void testMakeStrat() {
        System.out.println("makeStrat");
        Frame instance = null;
        instance.makeStrat();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of repaintScreen method, of class Frame.
     */
    @Test
    public void testRepaintScreen() {
        System.out.println("repaintScreen");
        Frame instance = null;
        instance.repaintScreen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDisplayMode method, of class Frame.
     */
    @Test
    public void testSetDisplayMode() {
        System.out.println("setDisplayMode");
        DisplayMode mode = null;
        Frame instance = null;
        instance.setDisplayMode(mode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of h method, of class Frame.
     */
    @Test
    public void testH() {
        System.out.println("h");
        Frame instance = null;
        DisplayMode expResult = null;
        DisplayMode result = instance.h();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
