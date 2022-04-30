/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kccalloc
 */
public class UtileriaTest {
    
    public UtileriaTest() {
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
     * Test of getDateUtil method, of class Utileria.
     */
    @Test
    public void testGetDateUtil() {
        System.out.println("getDateUtil");
        String cadFecha = "30-4-2022";
        Date expResult = new Date();
        expResult.setHours(0);
        expResult.setMinutes(0);
        expResult.setSeconds(0);
        Date result = Utileria.getDateUtil(cadFecha);
        assertTrue("Los resultados no soon iguales", (expResult.getTime() - result.getTime()) < 1000);
    }

    /**
     * Test of getFechaActualToString method, of class Utileria.
     */
    @Test
    public void testGetFechaActualToString() {
        System.out.println("getFechaActualToString");
        String expResult = "30-4-2022";
        String result = Utileria.getFechaActualToString();
        assertEquals(expResult, result);

    }
  
}
