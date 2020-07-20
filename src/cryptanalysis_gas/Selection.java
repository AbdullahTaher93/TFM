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
    indexofkey=new int[Key.length];
    keywithsort=new int[Key.length][Key[0].length];  
    seleckey=new int[Key.length/2][Key[0].length];
    seleckey2=new int[Key.length/2][Key[0].length];
    selecplain=new String[PlainText.length/2];
    selecplain2=new String[PlainText.length/2];
    for(int i=Key.length-1;i>=0;i--)
        indexofkey[i]=i; 
    
    Shell_Sort(Fitness,PlainText);
    
  }

    private void Shell_Sort(double[] Fitness, String[] PlainText) {
        int h=Fitness.length/2,z;
        double x;
        String y;
        for(int i=h;i>=0;i--)
    {
        for(int j=0;i+j<Fitness.length;j++)
        if(Fitness[j]>Fitness[j+i])
        {
            x=Fitness[j];
            Fitness[j]=Fitness[j+i];
            Fitness[i+j]=x;
            
            y=PlainText[j];
            PlainText[j]=PlainText[j+i];
            PlainText[i+j]=y;
            
            
            z=indexofkey[j];
            indexofkey[j]=indexofkey[j+i];
            indexofkey[i+j]=z;
            
            
        }
      
   }
    }
    
    
    
}
