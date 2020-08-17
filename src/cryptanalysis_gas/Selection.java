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
    
  int indexofkey[];
  int keywithsort[][];  
  int seleckey[][];
  int seleckey2[][];
  String selecplain[];
  String selecplain2[];
  
  
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
    for(int i=0;i<Key.length;i++)
         {
        System.arraycopy(Key[indexofkey[i]], 0, keywithsort[i], 0, Key[i].length);   
         }
    Selection_Method(PlainText);
    Print(Fitness,PlainText);
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

    private void Selection_Method(String[] PlainText) {
      int k=0;
      for(int i=PlainText.length-1; i>=PlainText.length/2  ;i--)
      {
          for(int j=0;j<seleckey2.length;j++){
              seleckey[k][j]=keywithsort[i][j];
              seleckey2[k][j]=keywithsort[i-seleckey2.length][j];
          }
          selecplain[k]=PlainText[i];
          selecplain2[k]=PlainText[i-seleckey2.length];
          k++;
      }
    }

    private void Print(double[] Fitness, String[] PlainText) {
        System.out.print("\n(Key With sort) (Plain text with sort) (Fitness Array with Sort)\n");     
       for(int i=Fitness.length-1;i>=0;i--){
            for(int j=0;j<6;j++)
            System.out.print(" "+keywithsort[i][j]+" ");
            System.out.print("   "+PlainText[i]+" ");
            System.out.print("           "+Fitness[i]+" ");
            System.out.print("\n");
            }
       System.out.print("\n");
       
       System.out.print("\n *** best half of Population ***\n");
       System.out.print(" ------------------------------------------\n");  
       for(int i=0;i<Fitness.length/2;i++){
            for(int j=0;j<Fitness.length/2;j++)
            System.out.print(" "+seleckey[i][j]+" ");
        
            System.out.print("\n");
             }
       System.out.print("\n");
            
    }
    
    
    
}
