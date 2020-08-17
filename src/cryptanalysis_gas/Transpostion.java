/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptanalysis_gas;

import java.util.Arrays;

/**
 *
 * @author Abdullah_PC
 */
public class Transpostion {
    
    String[] ArrOfPlain;
    boolean flag=false;
    
    public Transpostion(int[][] keys_Array,String cipher,String PlainText) {
         ArrOfPlain=new String[keys_Array.length];
         
         String carr=check_if_lenNotDivid(keys_Array[0].length,cipher.length());
         cipher=cipher+carr;
     //System.out.println("Add the X To cipher text If Do Not Be Divisible By key's length-----> "+cipher);
     change_position(keys_Array, cipher);
     int[] pi={6,8,5,4,3,2,1,7};
     checkifexs(pi,keys_Array);
     print();
     
     
    }
  /*method for checking if the length of cipher is'nt divid on the length of key so, we will add 'x' char to to the length
         of cipher divid on len of key
         */  
 public String check_if_lenNotDivid(int keys_length,int cipherLen){
  int carry=cipherLen%keys_length;
         String carr="";
         if(carry>0){
                for(int i=carry;i< keys_length;i++)
                    carr=carr+"X";
                    }
     return carr;
 }  
 //method to divid cipher text by lenght of key then change their posiotion by keys also
 public void change_position(int[][] Keys,String cipher){
     String cut="";
     for(int k=0;k<Keys.length;k++){
         ArrOfPlain[k]="";
       for(int i=1;i<=cipher.length();i++)
      {
          cut=cut+cipher.charAt(i-1);
          if(i%Keys[0].length==0)
          {
           SortByKey(Keys,cut,k);
           cut="";
          }       
      }
       if(cut!="")
       {
           SortByKey(Keys,cut,k);
           cut ="";
       }
     }
     
 }
 //method using to change the char's position
 private void SortByKey(int a[][],String cut,int k){
      
      char array[]=new char[cut.length()];
      for(int i=0;i<cut.length();i++)
      {
          array[a[k][i]-1]=cut.charAt(i);
          
          
      }
      for(int i=0;i<cut.length();i++){
      ArrOfPlain[k]= ArrOfPlain[k]+array[i];
      }
     }
 public void print(){
     for(int i=0;i<ArrOfPlain.length;i++)
       System.out.println("Plaintexts= "+ArrOfPlain[i]); 
 }

    private void checkifexs( int[]  Key_plain,int [][] keys_Array) {
        /*for(int i=0;i<ArrOfPlain.length;i++){
            if(ArrOfPlain[i].subSequence(0, PlainText.length()).toString().equalsIgnoreCase(PlainText)){
                System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&");
                System.err.print(ArrOfPlain[i]+  "  " +  i);
                flag=true;
               System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
           
            }
            
            
        }*/
        
        for (int[] keys_Array1 : keys_Array) {
            if(Arrays.equals(keys_Array1,Key_plain))
            {
                flag=true;
                break;
            }
        }
        
    }

}
