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
public class FitnessTest {
    Fitness fitness;
    Transpostion transpostion;
    public FitnessTest() {
        Population population=new Population(12,6);
         transpostion=new Transpostion(population.population, "ciphertest");
         fitness=new Fitness(transpostion.ArrOfPlain, population.population);
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
     * Test of fitnessequation method, of class Fitness.
     */
    @Test
    public void testFitnessequation() {
        System.out.println("fitnessequation");
        int Array_Of_PlainTextLength = transpostion.ArrOfPlain.length;
        
        fitness.fitnessequation(Array_Of_PlainTextLength);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of print method, of class Fitness.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        
        fitness.print();
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
