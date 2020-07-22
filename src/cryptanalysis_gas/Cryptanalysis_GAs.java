/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptanalysis_gas;

/**
 *
 * @author Abdullah_PC
 */
public class Cryptanalysis_GAs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Population population=new Population(16,8);
        Transpostion transpostion=new Transpostion(population.population, "ciphertest");
        Fitness fitness=new Fitness(transpostion.ArrOfPlain, population.population);
        Selection selection=new Selection(fitness.fi, transpostion.ArrOfPlain, population.population);
        CrossOver crossOver=new CrossOver(selection.seleckey, selection.selecplain);
        Mutation mutation=new Mutation(crossOver.newpopulionPlaint, crossOver.newpopulionKey);
    }
    
}
