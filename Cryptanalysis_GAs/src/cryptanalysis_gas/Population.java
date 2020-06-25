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
    int population[][] ;
    int temp;
    Population(int No_OF_keys,int length_OF_key){
        population=new int[No_OF_keys][length_OF_key];
        IF_KEY_EXIST(population,temp);
        check_row(population);
        Printarray();
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
  
 private void check_row(int population[][]){ 
    String[] num=new String[population.length]; 
    for(int i=0;i<population.length;i++) 
    { 
        num[i]=""; 
        for (int j=0;j<population[i].length;j++) 
             
           num[i]=num[i]+population[i][j]; 
        for(int inew=0;inew<population.length;inew++) 
            if(num[inew]==num[i]) 
            { 
                if(inew!=i) 
               IF_KEY_EXIST(population,temp); 
                else 
                    inew++; 
               break; 
            } 
   
    }  
}



 public void Printarray()
{ 
  for(int i=0;i<population.length;i++) 
  { 
        for(int j=0;j<population[i].length;j++) 
        System.out.print(population[i][j]+" "); 
        System.out.print("\n");   
   
  } 
}
    
}
