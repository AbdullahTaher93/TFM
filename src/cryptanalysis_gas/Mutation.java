/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptanalysis_gas;

import java.util.Random;

/**
 *
 * @author Abdullah_PC
 */
public class Mutation {
    
    String  Array_Of_Plain[];
    int key[][];
    CrossOver cross;
    int x=0,y=0;

    public Mutation(String Plain_Text[],int keys[][]) {
         Array_Of_Plain=new String[Plain_Text.length];
         key=new int[keys.length][keys[0].length];
         
        
    }
   
 }   
    
    
    

