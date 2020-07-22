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
         cross=new CrossOver();
         Random rand=new Random();  
          do{
          
                x=1+rand.nextInt(keys[0].length);
                y=1+rand.nextInt(keys[0].length);
            }while (x==y);
          
           int n1,n2;
        System.out.println("The First Number="+x+"\nThe Second Number="+y);
        for(int i=0;i<keys.length;i++)
        {
           n1= keys[i][x-1];
           n2= keys[i][y-1];
           keys[i][x-1]=n2;
           keys[i][y-1]=n1;
           
        }
        
         for(int i=0;i<keys.length;i++) 
           {
             Array_Of_Plain[i]="";
             trans2(Plain_Text[i],i,keys);
           }
         
        
        
    }
    private void trans2(String selecplain,int count,int corssover[][]){
    String cut=""; 
    for(int i=1;i<=selecplain.length();i++)
      {
          cut=cut+selecplain.charAt(i-1);
          if(i%corssover[0].length==0)
          {
              
          SortByKey(cut,count,corssover);
          
          cut="";
          
          } 
          
      }
    }
    
    private void SortByKey(String cut,int count,int corssover[][]){
     String sbk="";      
     for(int i=0;i<cut.length();i++)
     {
         
         sbk=sbk+cut.charAt(corssover[count][i]-1);
     }
     Array_Of_Plain[count]=Array_Of_Plain[count]+sbk;
       
    }
    
   
 }   
    
    
    

