/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.MesaCamarero;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Utileria;

/**
 *
 * @author kccalloc
 */
public class MesaCamareroDAOTest {

    public MesaCamareroDAOTest() {
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
     * Test of getDataNumeroMesas method, of class MesaCamareroDAO.
     */
    @Test
    public void testGetDataNumeroMesas() {
        System.out.println("getDataNumeroMesas");
        ResultSet result = MesaCamareroDAO.getDataNumeroMesas();
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
     * Test of getDataMesaCamarero method, of class MesaCamareroDAO.
     */
    @Test
    public void testGetDataMesaCamarero() {
        System.out.println("getDataMesaCamarero");
        ResultSet result = MesaCamareroDAO.getDataMesaCamarero();
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
     * Test of getDataMesaCamareroByInicioFin method, of class MesaCamareroDAO.
     */
    @Test
    public void testGetDataMesaCamareroByInicioFin() {
        System.out.println("getDataMesaCamareroByInicioFin");
        String cadFechaInicio = "01-4-2022";
        String cadFechaFin = "01-5-2022";
        Date inicio = Utileria.getDateUtil(cadFechaInicio);
        Date fin = Utileria.getDateUtil(cadFechaFin);
        ResultSet result = MesaCamareroDAO.getDataMesaCamareroByInicioFin(inicio, fin);
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
