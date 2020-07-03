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
public class Transpostion {
    
    String[] ArrOfPlain;
    public Transpostion(int[][] keys_Array,String cipher) {
         ArrOfPlain=new String[keys_Array.length];
         
         String carr=check_if_lenNotDivid(keys_Array[0].length,cipher.length());
         cipher=cipher+carr;
     System.out.println("Add the X To cipher text If Do Not Be Divisible By key's length-----> "+cipher);
     
     
    }
  /*method for checking if the length of cipher is'nt divid on the length of key so, we will add 'x' char to to the length
         of cipher divid on len of key
         */  
 public String check_if_lenNotDivid(int keys_length,int cipherLen){
  int carry=cipherLen%keys_length;
         String carr="";
         if(carry>0){
                for(int i=carry;i< keys_length;i++)
                    carr=carr+"x";
                    }
     return carr;
 }  
 
 

}
