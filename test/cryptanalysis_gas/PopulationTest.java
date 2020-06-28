/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptanalysis_gas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Abdullah_PC
 */
public class PopulationTest {
     Population poptest;
    public PopulationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        poptest=new Population(12,6);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Printarray method, of class Population.
     */
    @Test
    public void testPrintarray() {
        System.out.println("Print Array of Keys, Number of keys= 12, length of each key= 6, ");

        
    }
    
}
