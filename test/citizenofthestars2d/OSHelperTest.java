/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenofthestars2d;

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
public class OSHelperTest {
    
    public OSHelperTest() {
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
     * Test of getOsName method, of class OSHelper.
     */
    @Test
    public void testGetOsName() {
        System.out.println("getOsName");
        String expResult = "";
        String result = OSHelper.getOsName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isWindows method, of class OSHelper.
     */
    @Test
    public void testIsWindows() {
        System.out.println("isWindows");
        boolean expResult = false;
        boolean result = OSHelper.isWindows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOSX method, of class OSHelper.
     */
    @Test
    public void testIsOSX() {
        System.out.println("isOSX");
        boolean expResult = false;
        boolean result = OSHelper.isOSX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
