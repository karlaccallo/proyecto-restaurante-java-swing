/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DetallePedido;
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
public class DetallePedidoDAOTest {

    public DetallePedidoDAOTest() {
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
     * Test of getDataDetallePedidoSolicitadoCocina method, of class
     * DetallePedidoDAO.
     */
    @Test
    public void testGetDataDetallePedidoSolicitadoCocina() {
        System.out.println("getDataDetallePedidoSolicitadoCocina");
        ResultSet result = DetallePedidoDAO.getDataDetallePedidoSolicitadoCocina();
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
     * Test of getDataEstadoDetallePedido method, of class DetallePedidoDAO.
     */
    @Test
    public void testGetDataEstadoDetallePedido() {
        System.out.println("getDataEstadoDetallePedido");
        ResultSet result = DetallePedidoDAO.getDataEstadoDetallePedido();
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
     * Test of getIDEstadoPorNombre method, of class DetallePedidoDAO.
     */
    @Test
    public void testGetIDEstadoPorNombre() {
        System.out.println("getIDEstadoPorNombre");
        String estado = "iniciado";
        int expResult = 1;
        int result = DetallePedidoDAO.getIDEstadoPorNombre(estado);
        assertEquals(expResult, result);

    }

    /**
     * Test of getDataDetallePedidoByCartaAndPedido method, of class
     * DetallePedidoDAO.
     */
    @Test
    public void testGetDataDetallePedidoByCartaAndPedido() {
        System.out.println("getDataDetallePedidoByCartaAndPedido");
        int idcarta = 0;
        int numPedido = 0;
        DetallePedido expResult = null;
        DetallePedido result = DetallePedidoDAO.getDataDetallePedidoByCartaAndPedido(idcarta, numPedido);
        assertTrue(result != null);

    }

    /**
     * Test of getDetallePedidoByNumeroPedido method, of class DetallePedidoDAO.
     */
    @Test
    public void testGetDetallePedidoByNumeroPedido() {
        System.out.println("getDetallePedidoByNumeroPedido");
        int numero = 1;
        ResultSet result = DetallePedidoDAO.getDetallePedidoByNumeroPedido(numero);
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
     * Test of getDetallePedidoEmitidoByNumeroPedido method, of class
     * DetallePedidoDAO.
     */
    @Test
    public void testGetDetallePedidoEmitidoByNumeroPedido() {
        System.out.println("getDetallePedidoEmitidoByNumeroPedido");
        int numero = 5;
        ResultSet result = DetallePedidoDAO.getDetallePedidoEmitidoByNumeroPedido(numero);
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
