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
        fitnessequation(Array_Of_PlainText.length);
       //print();
        
         
        
        
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
           checktwoChars(sub_Of_TwoChars,k);
        }
    
        for(int i=0;i<Array_Of_PlainText[k].length()-2;i++)
        {
            if(k==0)
                CountOfSubTxTOf3++;
            sub_Of_ThreeChars="";
            sub_Of_ThreeChars=sub_Of_ThreeChars+Array_Of_PlainText[k].charAt(i)+Array_Of_PlainText[k].charAt(i+1)+Array_Of_PlainText[k].charAt(i+2);
            checkthreeChars(sub_Of_ThreeChars,k);
        }
    }
       
       
    } 
    
    
    private void checktwoChars(String ts,int k){
        boolean flage=false;
        int index=0;
        for(int i=0;i<Twochar.length;i++){
                if(ts.equalsIgnoreCase(Twochar[i]))
                {
                    flage=true;
                    index=i;

                    break;
                }
               }
               if(flage==true)
               {
                   Twocharcount[k][index]=Twocharcount[k][index]+1;
               }   
     }
    private void  checkthreeChars(String ths,int k){
        boolean flage=false;
        int index=0;
         for(int i=0;i<Threechar.length;i++){
                if(ths.equalsIgnoreCase(Threechar[i]))
                {
                    flage=true;
                    index=i;
                    break;
                }
               }
               if(flage==true)
               {
                   Threecharcount[k][index]=Threecharcount[k][index]+1;
               }

 }

    
    public void fitnessequation(int Array_Of_PlainTextLength){
      double d=0;
      for(int i=0;i<SumTwochar.length;i++)
               SumTwochar[i]=0;
      for(int i=0;i<SumThreechar.length;i++)
          SumThreechar[i]=0;
      
      for(int i=0;i<Array_Of_PlainTextLength;i++){
        for(int j=0;j<Twochar.length;j++)
                if(Twocharcount[i][j]!=0)
                {
                 d=(double)(Twocharcount[i][j]/CountOfSubTxTOf2);
                 SumTwochar[i]=SumTwochar[i]+TwoCharVale[j]-d;
                }
     }
     for(int i=0;i<Array_Of_PlainTextLength;i++){
        for(int j=0;j<Threechar.length;j++)
                 if(Threecharcount[i][j]!=0)
                 {
                  d=(double)(Threecharcount[i][j]/CountOfSubTxTOf3);
                  SumThreechar[i]=SumThreechar[i]+ThreeCharVale[j]-d;
                 }
          
     }
    for(int i=0;i<SumTwochar.length;i++){
       fi[i]=(double)SumTwochar[i]+SumThreechar[i];
    }
        
    }
   
 
 
    
}
