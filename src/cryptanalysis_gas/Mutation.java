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
    
  
    int key[][];
    
    int x=0,y=0;

    public Mutation(String Plain_Text[],int keys[][],int mution_ratio) {
         
        
         key=new int[keys.length][keys[0].length];
         
         Random rand=new Random();  
          
          
           int n1,n2;
       
        for(int i=0;i<keys.length*mution_ratio/100;i++)
        {
            do{
          
                x=1+rand.nextInt(keys[0].length);
                y=1+rand.nextInt(keys[0].length);
            }while (x==y);
           System.out.println("Key("+i+1+") Two random Postions= "+x+" , "+y);
           n1= keys[i][x-1];
           n2= keys[i][y-1];
           keys[i][x-1]=n2;
           keys[i][y-1]=n1;
           
        }
        key=keys;
        
         
         print(key);
        
    }
   
    
    
   public void print(int[][] keyss){
        
        System.out.println();
        System.out.println("Final Table of keyes(New Population)");
        System.out.println("-------------------------------------");
        for(int i=0;i<keyss.length;i++)
        {
            for(int j=0;j<keyss[i].length;j++)
            System.out.print(" "+keyss[i][j]+" ");
            
            System.out.println();
         }  
       
        }
    
   
 }   
    
    
    

