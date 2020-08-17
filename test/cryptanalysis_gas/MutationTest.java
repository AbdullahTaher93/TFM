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
public class MutationTest {
    
    public MutationTest() {
        Population population=new Population(12,6);
        Transpostion transpostion=new Transpostion(population.population, "ciphertest","");
         Fitness fitness=new Fitness(transpostion.ArrOfPlain);
         Selection s=new Selection(fitness.fi, transpostion.ArrOfPlain, population.population);
         CrossOver crossOver=new CrossOver(s.seleckey, s.selecplain,0,true);
         Mutation m=new Mutation(crossOver.newpopulionPlaint, crossOver.newpopulionKey,70);
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
     * Test of Print method, of class Mutation.
     */
    @Test
    public void testPrint() {
        System.out.println("Print");
        
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
