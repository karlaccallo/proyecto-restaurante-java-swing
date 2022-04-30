/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
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
public class UsuarioDAOTest {

    public UsuarioDAOTest() {
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
     * Test of inlogin method, of class UsuarioDAO.
     */
    @Test
    public void testInlogin() {
        System.out.println("inlogin");
        Usuario ou=new Usuario();
        ou.setUsuario("lchoquehuanca");
        ou.setPassword("123456");
        int expResult = 1;
        int result = UsuarioDAO.inlogin(ou);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataUsuario method, of class UsuarioDAO.
     */
    @Test
    public void testGetDataUsuario() {
        System.out.println("getDataUsuario");
        ResultSet result = UsuarioDAO.getDataUsuario();
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
     * Test of generarCodUsuario method, of class UsuarioDAO.
     */
    @Test
    public void testGenerarCodUsuario() {
        System.out.println("generarCodUsuario");
        int expResult = 6;
        int result = UsuarioDAO.generarCodUsuario();
        assertEquals(expResult, result);

    }

    /**
     * Test of getUsuarioByID method, of class UsuarioDAO.
     */
    @Test
    public void testGetUsuarioByID() {
        System.out.println("getUsuarioByID");
        int codusuario = 1;
        Usuario result = UsuarioDAO.getUsuarioByID(codusuario);
        assertTrue(result!=null);

    }

    /**
     * Test of getUsuarioByNomUsu method, of class UsuarioDAO.
     */
    @Test
    public void testGetUsuarioByNomUsu() {
        System.out.println("getUsuarioByNomUsu");
        String codusuario = "";
        Usuario result = UsuarioDAO.getUsuarioByNomUsu(codusuario);
        assertTrue(result!=null);

    }

   
    /**
     * Test of getDataEmpleado method, of class UsuarioDAO.
     */
    @Test
    public void testGetDataEmpleado() {
        System.out.println("getDataEmpleado");
        ResultSet result = UsuarioDAO.getDataEmpleado();
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
     * Test of getIDempleadoxNombre method, of class UsuarioDAO.
     */
    @Test
    public void testGetIDempleadoxNombre() {
        System.out.println("getIDempleadoxNombre");
        String empleado = "Karla Ccallo Choque";
        int expResult = 1;
        int result = UsuarioDAO.getIDempleadoxNombre(empleado);
        assertEquals(expResult, result);

    }

    /**
     * Test of getNombreCamareroByNombreUsuario method, of class UsuarioDAO.
     */
    @Test
    public void testGetNombreCamareroByNombreUsuario() {
        System.out.println("getNombreCamareroByNombreUsuario");
        String usuario = "Lchoquehuanca";
        String expResult = "Luis Choquehuanca Arteta";
        String result = UsuarioDAO.getNombreCamareroByNombreUsuario(usuario);
        assertEquals(expResult, result);

    }

}
