/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Carta;
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
public class CartaDAOTest {

    public CartaDAOTest() {
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
     * Test of getDataCarta method, of class CartaDAO.
     */
    @Test
    public void testGetDataCarta() {
        System.out.println("getDataCarta");
        boolean tieneData = true;
        ResultSet result = CartaDAO.getDataCarta();

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
     * Test of getDataCartaByDescripcion method, of class CartaDAO.
     */
    @Test
    public void testGetDataCartaByDescripcion() {
        System.out.println("getDataCartaByDescripcion");
        String cartaDesc = "Arroz con pollo";
        boolean tieneData = true;
        ResultSet result = CartaDAO.getDataCartaByDescripcion(cartaDesc);
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
     * Test of getCartaByID method, of class CartaDAO.
     */
    @Test
    public void testGetCartaByID() {
        System.out.println("getCartaByID");
        int cartaId = 2;
        Carta result = CartaDAO.getCartaByID(cartaId);
        assertTrue(result != null);
    }

    /**
     * Test of getCartaByNombre method, of class CartaDAO.
     */
    @Test
    public void testGetCartaByNombre() {
        System.out.println("getCartaByNombre");
        String cartaDesc = "Arroz con pollo";
        Carta result = CartaDAO.getCartaByNombre(cartaDesc);
        assertTrue(result != null);

    }

    /**
     * Test of getDataCategoria method, of class CartaDAO.
     */
    @Test
    public void testGetDataCategoria() {
        System.out.println("getDataCategoria");
        ResultSet result = CartaDAO.getDataCategoria();
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
     * Test of getIDcategoriaxDescrpcion method, of class CartaDAO.
     */
    @Test
    public void testGetIDcategoriaxDescrpcion() {
        System.out.println("getIDcategoriaxDescrpcion");
        String categoria = "POSTRES";
        int expResult = 4;
        int result = CartaDAO.getIDcategoriaxDescrpcion(categoria);
        assertEquals(expResult, result);

    }

    /**
     * Test of generarIdCarta method, of class CartaDAO.
     */
    @Test
    public void testGenerarIdCarta() {
        System.out.println("generarIdCarta");
        int expResult = 32;
        int result = CartaDAO.generarIdCarta();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIDCategoriaPorNombre method, of class CartaDAO.
     */
    @Test
    public void testGetIDCategoriaPorNombre() {
        System.out.println("getIDCategoriaPorNombre");
        String categoria = "POSTRES";
        int expResult = 4;
        int result = CartaDAO.getIDCategoriaPorNombre(categoria);
        assertEquals(expResult, result);

    }

    /**
     * Test of getDataCartaDisponible method, of class CartaDAO.
     */
    @Test
    public void testGetDataCartaDisponible() {
        System.out.println("getDataCartaDisponible");
        ResultSet result = CartaDAO.getDataCartaDisponible();
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
     * Test of getDataCartaDisponibleByDescripcion method, of class CartaDAO.
     */
    @Test
    public void testGetDataCartaDisponibleByDescripcion() {
        System.out.println("getDataCartaDisponibleByDescripcion");
        String cartaDesc = "Pollo";
        ResultSet result = CartaDAO.getDataCartaDisponibleByDescripcion(cartaDesc);
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
     * Test of getPlatosByCategoria method, of class CartaDAO.
     */
    @Test
    public void testGetPlatosByCategoria() {
        System.out.println("getPlatosByCategoria");
        String categoria = "POSTRES";
        ResultSet result = CartaDAO.getPlatosByCategoria(categoria);
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
     * Test of getIdCartaByNombre method, of class CartaDAO.
     */
    @Test
    public void testGetIdCartaByNombre() {
        System.out.println("getIdCartaByNombre");
        String cartaNombre = "Pollo a la Brasa";
        int expResult = 2;
        int result = CartaDAO.getIdCartaByNombre(cartaNombre);
        assertEquals(expResult, result);

    }

    /**
     * Test of getPrecioCartaById method, of class CartaDAO.
     */
    @Test
    public void testGetPrecioCartaById() {
        System.out.println("getPrecioCartaById");
        int id = 1;
        double expResult = 45.00;
        double result = CartaDAO.getPrecioCartaById(id);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getNombrePlatoByCategoria method, of class CartaDAO.
     */
    @Test
    public void testGetNombrePlatoByCategoria() {
        System.out.println("getNombrePlatoByCategoria");
        String categoria = "POSTRES";
        ResultSet result = CartaDAO.getNombrePlatoByCategoria(categoria);
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
