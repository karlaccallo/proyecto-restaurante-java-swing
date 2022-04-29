/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
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
        ResultSet expResult = null;
        ResultSet result = CartaDAO.getDataCarta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataCartaByDescripcion method, of class CartaDAO.
     */
    @Test
    public void testGetDataCartaByDescripcion() {
        System.out.println("getDataCartaByDescripcion");
        String cartaDesc = "";
        ResultSet expResult = null;
        ResultSet result = CartaDAO.getDataCartaByDescripcion(cartaDesc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCartaByID method, of class CartaDAO.
     */
    @Test
    public void testGetCartaByID() {
        System.out.println("getCartaByID");
        int cartaId = 0;
        Carta expResult = null;
        Carta result = CartaDAO.getCartaByID(cartaId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCartaByNombre method, of class CartaDAO.
     */
    @Test
    public void testGetCartaByNombre() {
        System.out.println("getCartaByNombre");
        String cartaDesc = "";
        Carta expResult = null;
        Carta result = CartaDAO.getCartaByNombre(cartaDesc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataCategoria method, of class CartaDAO.
     */
    @Test
    public void testGetDataCategoria() {
        System.out.println("getDataCategoria");
        ResultSet expResult = null;
        ResultSet result = CartaDAO.getDataCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIDcategoriaxDescrpcion method, of class CartaDAO.
     */
    @Test
    public void testGetIDcategoriaxDescrpcion() {
        System.out.println("getIDcategoriaxDescrpcion");
        String categoria = "";
        int expResult = 0;
        int result = CartaDAO.getIDcategoriaxDescrpcion(categoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newCarta method, of class CartaDAO.
     */
    @Test
    public void testNewCarta() {
        System.out.println("newCarta");
        Carta obj = null;
        boolean expResult = false;
        boolean result = CartaDAO.newCarta(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarCarta method, of class CartaDAO.
     */
    @Test
    public void testActualizarCarta() {
        System.out.println("actualizarCarta");
        Carta obj = null;
        boolean expResult = false;
        boolean result = CartaDAO.actualizarCarta(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarIdCarta method, of class CartaDAO.
     */
    @Test
    public void testGenerarIdCarta() {
        System.out.println("generarIdCarta");
        int expResult = 0;
        int result = CartaDAO.generarIdCarta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIDCategoriaPorNombre method, of class CartaDAO.
     */
    @Test
    public void testGetIDCategoriaPorNombre() {
        System.out.println("getIDCategoriaPorNombre");
        String categoria = "";
        int expResult = 0;
        int result = CartaDAO.getIDCategoriaPorNombre(categoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCarta method, of class CartaDAO.
     */
    @Test
    public void testDeleteCarta() {
        System.out.println("deleteCarta");
        int cod = 0;
        boolean expResult = false;
        boolean result = CartaDAO.deleteCarta(cod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataCartaDisponible method, of class CartaDAO.
     */
    @Test
    public void testGetDataCartaDisponible() {
        System.out.println("getDataCartaDisponible");
        ResultSet expResult = null;
        ResultSet result = CartaDAO.getDataCartaDisponible();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataCartaDisponibleByDescripcion method, of class CartaDAO.
     */
    @Test
    public void testGetDataCartaDisponibleByDescripcion() {
        System.out.println("getDataCartaDisponibleByDescripcion");
        String cartaDesc = "";
        ResultSet expResult = null;
        ResultSet result = CartaDAO.getDataCartaDisponibleByDescripcion(cartaDesc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlatosByCategoria method, of class CartaDAO.
     */
    @Test
    public void testGetPlatosByCategoria() {
        System.out.println("getPlatosByCategoria");
        String categoria = "";
        ResultSet expResult = null;
        ResultSet result = CartaDAO.getPlatosByCategoria(categoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdCartaByNombre method, of class CartaDAO.
     */
    @Test
    public void testGetIdCartaByNombre() {
        System.out.println("getIdCartaByNombre");
        String cartaNombre = "";
        int expResult = 0;
        int result = CartaDAO.getIdCartaByNombre(cartaNombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioCartaById method, of class CartaDAO.
     */
    @Test
    public void testGetPrecioCartaById() {
        System.out.println("getPrecioCartaById");
        int id = 0;
        double expResult = 0.0;
        double result = CartaDAO.getPrecioCartaById(id);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombrePlatoByCategoria method, of class CartaDAO.
     */
    @Test
    public void testGetNombrePlatoByCategoria() {
        System.out.println("getNombrePlatoByCategoria");
        String categoria = "";
        ResultSet expResult = null;
        ResultSet result = CartaDAO.getNombrePlatoByCategoria(categoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
