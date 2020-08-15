/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptanalysis_gas;

import jdk.nashorn.internal.ir.BreakNode;


/**
 *
 * @author Abdullah_PC
 */
public class Cryptanalysis_GAs {

    /**
     * @param args the command line arguments
     */static int [][] keys;
     //0= My crossOver
     //1= onepoint Crossover
     //2= Davis_Order
     static int type_of_crossOver=1;
     //true= keeps best half parents into next generation
    static  boolean keeps_parents=false;
     //ratio of matution from 100
    static  int mutation_ratio=70;
    static String Crossover_Operator="";
    
    public static void main(String[] args) {
        // TODO code application logic here
        int itrations=0;
        int no_of_population=0;
        
        Population population=new Population(16,8);
        keys=new int[population.population.length][population.population[0].length];
        keys=population.population;
        String cipherText="nm yame ailsbdu  leatahh'rn m iImfooatirnnX g.XE";
        String PlainText="my name is abdullah";
        boolean flag=false;
        itrations++;
        
        no_of_population=itrations*population.population.length;
        Transpostion transpostion;
        Fitness fitness;
        Selection selection;
        CrossOver crossOver;
        Mutation mutation;
        transpostion=new Transpostion(keys, cipherText,PlainText);
        flag=transpostion.flag;
        if(flag!=true){
         fitness=new Fitness(transpostion.ArrOfPlain, keys);
         selection=new Selection(fitness.fi, transpostion.ArrOfPlain, keys);
        
        crossOver=new CrossOver(selection.seleckey, selection.selecplain,type_of_crossOver, keeps_parents);
        mutation=new Mutation(crossOver.newpopulionPlaint, crossOver.newpopulionKey,mutation_ratio);
        keys=mutation.key;
       
        
       
       do{
                    
                        
                        
                        System.out.println("***Fixed Period d With a Permutation Function Transposition Cipher***");
                        Transpostion Tr=new Transpostion(keys,cipherText,PlainText);
                        itrations++;
                        no_of_population=itrations*population.population.length;
                        flag=Tr.flag;
                        if(flag!=true){
                        System.out.println("***Step Two From Genetics Algorithm Evaluation Fitness***");
                        Fitness fit=new Fitness(Tr.ArrOfPlain,keys);
                        System.out.print("***Step Three From Genetic Algorithm Selection Operation Top 6***\n");
                        System.out.println("***Sorted Plaintext And key And Fitness From High To Low By High Fitness***");
                        Selection ss=new Selection(fit.fi,Tr.ArrOfPlain,keys);
                        System.out.println("***Step Foure From Genetics Algorithm Recombination (Crossover) Operation ***");
                        CrossOver cross=new CrossOver(ss.seleckey,ss.selecplain,type_of_crossOver, keeps_parents);
                        
                        System.out.println("***Step Five From Genetics Algorithm Mutation Operation***");
                        Mutation mm=new Mutation(cross.newpopulionPlaint,cross.newpopulionKey,mutation_ratio);
                        keys=mm.key;
                        //crossOver.newpopulionKey=cross.newpopulionKey;
                        // mm.Print(cross.newpopulionKey);
                        
                        Crossover_Operator=crossOver.Crossover_Operator;
                        }
                        
                        else{
                            System.out.println();
                           System.out.println("itrations= "+itrations+"\nno of the population= "+no_of_population+"\nCrossover Operator: "+Crossover_Operator+"\nKeeps best parent to next Population: "+keeps_parents+"\nMutation Ratio: "+mutation_ratio+"%"); 
                        }
                          
                   
           }while(flag==false);
            }else{
           System.out.println();
           
           System.out.println("itrations= "+itrations+"\nno of the population= "+no_of_population+"\nCrossover Operator: "+Crossover_Operator+"\nKeeps best parent to next Population: "+keeps_parents+"\nMutation Ratio: "+mutation_ratio+"%"); 
        }
    }
    
    
}
