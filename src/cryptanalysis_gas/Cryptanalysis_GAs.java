/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptanalysis_gas;

import java.util.Scanner;

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
        System.out.println("Enter The Round Number=");
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=1;i<=n;i++){
                    if(n>0){
                        System.out.println("The Round="+i);
                        System.out.println("***Step First From Genetics Algorithm Initialise Population*** ");
                        System.out.println("---------New Keys or  New populion-----------");
                        mutation.Print(crossOver.newpopulionKey);
                        System.out.println("***Fixed Period d With a Permutation Function Transposition Cipher***");
                        Transpostion Tr=new Transpostion(mutation.key,"ciphertest");
                        System.out.println("***Step Two From Genetics Algorithm Evaluation Fitness***");
                        Fitness fit=new Fitness(Tr.ArrOfPlain,mutation.key);
                        System.out.print("***Step Three From Genetic Algorithm Selection Operation Top 6***\n");
                        System.out.println("***Sorted Plaintext And key And Fitness From High To Low By High Fitness***");
                        Selection ss=new Selection(fit.fi,Tr.ArrOfPlain,mutation.key);
                        System.out.println("***Step Foure From Genetics Algorithm Recombination (Crossover) Operation ***");
                        CrossOver cross=new CrossOver(ss.seleckey,ss.selecplain);
                        System.out.println("***Step Five From Genetics Algorithm Mutation Operation***");
                        Mutation mm=new Mutation(crossOver.newpopulionPlaint,mutation.key);
                          }
                    else{
                         System.out.print("Enter number of loop greater than zero");
            }
           }
    }
    
}
