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
public class SelectionTest {
    Fitness fitness;
    Transpostion transpostion;
    public SelectionTest() {
        Population population=new Population(12,6);
         transpostion=new Transpostion(population.population, "ciphertest");
         fitness=new Fitness(transpostion.ArrOfPlain, population.population);
         Selection s=new Selection(fitness.fi, transpostion.ArrOfPlain, population.population);
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
