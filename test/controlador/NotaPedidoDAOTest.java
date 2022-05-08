/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class NotaPedidoDAOTest {

    public NotaPedidoDAOTest() {
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
     * Test of getNumeroPedidoRegistrado method, of class NotaPedidoDAO.
     */
    @Test
    public void testGetNumeroPedidoRegistrado() {
        System.out.println("getNumeroPedidoRegistrado");
        int expResult = 11;
        int result = NotaPedidoDAO.getNumeroPedidoRegistrado();
        assertEquals(expResult, result);

    }

    /**
     * Test of getNumeroMesaByNombreCamarero method, of class NotaPedidoDAO.
     */
    @Test
    public void testGetNumeroMesaByNombreCamarero() {
        System.out.println("getNumeroMesaByNombreCamarero");
        String camarero = "Luis Choquehuanca Arteta";
        ResultSet result = NotaPedidoDAO.getNumeroMesaByNombreCamarero(camarero);

        boolean tieneData = true;

        try {
            if (!result.next()) {
                tieneData = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartaDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(tieneData);
    }

    /**
     * Test of getTotalValorNotaPedidoByNumPedido method, of class
     * NotaPedidoDAO.
     */
    @Test
    public void testGetTotalValorNotaPedidoByNumPedido() {
        System.out.println("getTotalValorNotaPedidoByNumPedido");
        int nroPedido = 1;
        double expResult = 103.0;
        double result = NotaPedidoDAO.getTotalValorNotaPedidoByNumPedido(nroPedido);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getPedidosPendientesByCamarero method, of class NotaPedidoDAO.
     */
    @Test
    public void testGetPedidosPendientesByCamarero() {
        System.out.println("getPedidosPendientesByCamarero");
        int EmpleadoId = 4;
        ResultSet result = NotaPedidoDAO.getPedidosPendientesByCamarero(EmpleadoId);
        boolean tieneData = true;

        try {
            if (!result.next()) {
                tieneData = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartaDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(tieneData);
    }

}
