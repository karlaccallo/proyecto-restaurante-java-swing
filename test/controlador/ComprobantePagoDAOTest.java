/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luis Antonio
 */
public class ComprobantePagoDAOTest {

    public ComprobantePagoDAOTest() {
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
     * Test of getNumeroPedidoRegistrado method, of class ComprobantePagoDAO.
     */
    @Test
    public void testGetNumeroPedidoRegistrado() {
        System.out.println("getNumeroPedidoRegistrado");
        int expResult = 11;
        int result = ComprobantePagoDAO.getNumeroPedidoRegistrado();
        assertEquals(expResult, result);

    }

    /**
     * Test of getNombresClienteByDNI method, of class ComprobantePagoDAO.
     */
    @Test
    public void testGetNombresClienteByDNI() {
        System.out.println("getNombresClienteByDNI");
        String dni = "45454545";
        String expResult = "Francisco Castro";
        String result = ComprobantePagoDAO.getNombresClienteByDNI(dni);
        assertEquals(expResult.trim(), result.trim());

    }

    /**
     * Test of getIdClienteByDNI method, of class ComprobantePagoDAO.
     */
    @Test
    public void testGetIdClienteByDNI() {
        System.out.println("getIdClienteByDNI");
        String dni = "00000000";
        int expResult = 1;
        int result = ComprobantePagoDAO.getIdClienteByDNI(dni);
        assertEquals(expResult, result);
    }

    /**
     * Test of generarNumeroComprobante method, of class ComprobantePagoDAO.
     */
    @Test
    public void testGenerarNumeroComprobante() {
        System.out.println("generarNumeroComprobante");
        int expResult = 8;
        int result = ComprobantePagoDAO.generarNumeroComprobante();
        assertEquals(expResult, result);

    }

    /**
     * Test of existePedidoGrabado method, of class ComprobantePagoDAO.
     */
    @Test
    public void testExistePedidoGrabado() {
        System.out.println("existePedidoGrabado");
        int numPedido = 1;
        boolean expResult = true;
        boolean result = ComprobantePagoDAO.existePedidoGrabado(numPedido);
        assertEquals(expResult, result);

    }

}
