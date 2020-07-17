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
public class Fitness {
 String [] Twochar={"TH","HE","IN","ER","AN","ED","EN","RE","NT","ON","OR"};
 double [] TwoCharVale={3.015,0.027,1.872,1.86,1.419,1.305,1.141,1.353,1.15,1.82,0.902};
 String [] Threechar={"THE","ING","AND","EEE","ION","FOR","REA","ONE"};
 double [] ThreeCharVale={2.032,0.747,0.667,0,0.277,0.306,1.189,0.19}; 
 
 int Twocharcount[][];
 int Threecharcount[][];
 double SumTwochar[];
 double SumThreechar[];
 
 int CountOfSubTxTOf2=0;
 int CountOfSubTxTOf3=0;
 double fi[];
 String sub_Of_TwoChars,sub_Of_ThreeChars="";

    public Fitness(String[] Array_Of_PlainText,int key[][]) {
        
        Twocharcount=new int[Array_Of_PlainText.length][Twochar.length];
        Threecharcount=new int[Array_Of_PlainText.length][Threechar.length];
        SumTwochar=new double[Array_Of_PlainText.length];
        SumThreechar=new double[Array_Of_PlainText.length];
        fi=new double[Array_Of_PlainText.length];
        
        FitnessMethod( Array_Of_PlainText, key);
        //fitnessequation(Array_Of_PlainText.length);
       // print();
        
         
        
        
    }
    private void FitnessMethod(String[] Array_Of_PlainText, int[][] key) {
        //init 0 to arraies of count Twochars and Threechars
        for(int i=0;i<Array_Of_PlainText.length;i++){
        
            for(int j=0;j<Twocharcount[i].length;j++)
                   Twocharcount[i][j]=0;
            for(int j=0;j<Threecharcount[i].length;j++)
                      Threecharcount[i][j]=0;
        
    }
      for(int k=0;k<Array_Of_PlainText.length;k++){
        for(int i=0;i<Array_Of_PlainText[k].length()-1;i++)
        {
            if(k==0)
                CountOfSubTxTOf2++;
           sub_Of_TwoChars="";
           sub_Of_TwoChars=sub_Of_TwoChars+Array_Of_PlainText[k].charAt(i)+Array_Of_PlainText[k].charAt(i+1);
           //checktwoChars(sub_Of_TwoChars,k);
        }
    
        for(int i=0;i<Array_Of_PlainText[k].length()-2;i++)
        {
            if(k==0)
                CountOfSubTxTOf3++;
            sub_Of_ThreeChars="";
            sub_Of_ThreeChars=sub_Of_ThreeChars+Array_Of_PlainText[k].charAt(i)+Array_Of_PlainText[k].charAt(i+1)+Array_Of_PlainText[k].charAt(i+2);
            //checkthreeChars(sub_Of_ThreeChars,k);
        }
    }
       
       
    } 
    
    
   
 
 
    
}
