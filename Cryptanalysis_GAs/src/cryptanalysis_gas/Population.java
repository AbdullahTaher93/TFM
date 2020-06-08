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
public class Population {
    int population[][] =new int[12][6];
    int temp;
    Population(){
        
        IF_KEY_EXIST(population,temp);
        check_row(population);
        Printarray(population);
    }
    
   private void IF_KEY_EXIST(int population[][],int temp){ 
   Random d=new Random(); 
      boolean IFEX=false; 
    for(int i=0;i<population.length;i++) 
        for(int j=0;j<population[i].length;) 
        { 
          temp=1+d.nextInt(population[i].length); 
            IFEX=check(population,i,j,temp); 
            if (IFEX==false){ 
             
            population[i][j]=temp; 
            j++; 
            }  
            
        } 
      
}
   private boolean check(int population[][],int iold,int jold,int temp){ 
  boolean ife=false; 
       for(int j=0;j<=jold;j++) 
           if(population[iold][j]==temp) 
           { 
              ife=true; 
              break; 
           }           
    return ife; 
} 
  
 

 
    
}
