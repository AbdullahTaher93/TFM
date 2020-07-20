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
public class Selection {
    
  int indexofkey[]=new int[12];
  int keywithsort[][]=new int[12][6];  
  int seleckey[][]=new int[6][6];
  int seleckey2[][]=new int[6][6];
  String selecplain[]=new String[6];
  String selecplain2[]=new String[6];
  public Selection(double[] Fitness,String[] PlainText,int[][] Key) {
     indexofkey=new int[Fitness.length];
   keywithsort=new int[Key.length][Key[0].length];  
   seleckey=new int[Key.length/2][Key[0].length];
   seleckey2=new int[Key.length/2][Key[0].length];
   selecplain=new String[PlainText.length/2];
   selecplain2=new String[PlainText.length/2];
  }
    
    
    
}
