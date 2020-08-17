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
public class TranspostionTest {
    Population population;
    Transpostion transpostion;
    public TranspostionTest() {
        population=new Population(12,6);
        transpostion=new Transpostion(population.population,  "ichpreettsxx","ciphertestxx");
        
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
     * Test of check_if_lenNotDivid method, of class Transpostion.
     */
    @Test
    public void testCheck_if_lenNotDivid() {
        System.out.println("check_if_lenNotDivid");
        int keys_length = population.population[0].length;
        int cipherLen = "ciphertest".length();
         
       
         String result = transpostion.check_if_lenNotDivid(keys_length, cipherLen);
         System.out.println(result);
       
    }

    /**
     * Test of change_position method, of class Transpostion.
     */
    @Test
    public void testChange_position() {
        System.out.println("change_position");
        
        int[][] Keys = population.population;
        String cipher = "ciphertestxx";
       
        transpostion.change_position(Keys, cipher);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of print method, of class Transpostion.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        
        transpostion.print();
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
