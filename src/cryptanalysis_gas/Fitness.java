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
public class Fitness {
    //{"TH","EN","NG","AT","AL","ED","IT","ND","AS","TO","IS","OR","HA","EA","ET","TI","SE","AR","OU","TE","OF"}
    /*{2.71,1.13,0.89
        HE,2.33,1.12,0.88
        IN,2.03,1.08,0.88
        ER,1.78,1.07,0.87
        AN,1.61,1.07,0.86
        RE,1.41,1.06,0.83
        ES,1.32,1.00,0.76
        ON,1.32,0.99,0.73
        ST,1.25,0.98,0.72
        NT,1.17,0.98,0.71,}*/
String [] Twochar={"TH","EN","NG","HE","AT","AL","IN","ED","IT","ER","ND","AS","AN","TO","IS","RE","OR","HA","ES","EA","ET","ON","TI","SE","ST","AR","OU","NT","TE","OF"};
double [] TwoCharVale={2.71,1.13,0.89,2.33,1.12,0.88,2.03,1.08,0.88,1.78,1.07,0.87,1.61,1.07,0.86,1.41,1.06,0.83,1.32,1.00,0.76,1.32,0.99,0.73,1.25,0.98,0.72,1.17,0.98,0.71};
    //String [] Twochar={"TH","HE","IN","ER","AN","ED","EN","RE","NT","ON","OR"};

 //double [] TwoCharVale={2.71,2.33,2.03,1.78,1.419,1.305,1.141,1.353,1.15,1.82,0.902};
 
 String [] Threechar={"THE","ERE","HES","AND","TIO","VER","ING","TER","HIS","ENT","EST","OFT","ION","ERS","ITH","HER","ATI","FTH","FOR","HAT","STH","THA","ATE","OTH","NTH","ALL","RES","INT","ETH","ONT"};
double [] ThreeCharVale={1.81,0.31,0.24,0.73,0.31,0.24,0.72,0.30,0.24,0.42,0.28,0.22,0.42,0.28,0.21,0.36,0.26,0.21,0.34,0.26,0.21,0.33,0.25,0.21,0.33,0.25,0.21,0.32,0.24,0.20};
 //String [] Threechar={"THE","ING","AND","EEE","ION","FOR","REA","ONE"};
 //double [] ThreeCharVale={2.032,0.747,0.667,0,0.277,0.306,1.189,0.19}; 
 
 int Twocharcount[][];
 int Threecharcount[][];
 double SumTwochar[];
 double SumThreechar[];
 
 int CountOfSubTxTOf2=0;
 int CountOfSubTxTOf3=0;
 double fi[];
 String sub_Of_TwoChars,sub_Of_ThreeChars="";

    public Fitness(String[] Array_Of_PlainText) {
        
        Twocharcount=new int[Array_Of_PlainText.length][Twochar.length];
        Threecharcount=new int[Array_Of_PlainText.length][Threechar.length];
        SumTwochar=new double[Array_Of_PlainText.length];
        SumThreechar=new double[Array_Of_PlainText.length];
        fi=new double[Array_Of_PlainText.length];
        
        FitnessMethod( Array_Of_PlainText);
        fitnessequation(Array_Of_PlainText.length);
        print();
        
         
        
        
    }
    private void FitnessMethod(String[] Array_Of_PlainText) {
        //init 0 to arraies of count Twochars and Threechars
        
        Arrays.fill(Twocharcount,0,0,0);
        Arrays.fill(Threecharcount,0,0,0);
       
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
      Arrays.fill(SumTwochar,0);
      Arrays.fill(SumThreechar,0);
      
      
      for(int i=0;i<Array_Of_PlainTextLength;i++){
        for(int j=0;j<Twochar.length;j++)
                if(Twocharcount[i][j]!=0)
                {
                 d=(double)(Twocharcount[i][j]/CountOfSubTxTOf2);
                 SumTwochar[i]=SumTwochar[i]+TwoCharVale[j]-d;
                 d=(double)(Threecharcount[i][j]/CountOfSubTxTOf3);
                 SumThreechar[i]=SumThreechar[i]+ThreeCharVale[j]-d;
                }
     }
    /* for(int i=0;i<Array_Of_PlainTextLength;i++){
        for(int j=0;j<Threechar.length;j++)
                 if(Threecharcount[i][j]!=0)
                 {
                  d=(double)(Threecharcount[i][j]/CountOfSubTxTOf3);
                  SumThreechar[i]=SumThreechar[i]+ThreeCharVale[j]-d;
                 }
          
     }*/
    for(int i=0;i<fi.length;i++){
       fi[i]=(double)SumTwochar[i]+SumThreechar[i];
    }
        
    }
   public void print(){
        System.out.print("Ti= "); 
        for(int i=0;i<SumTwochar.length;i++)
            System.out.print("("+SumTwochar[i]+") ");
        //diطباعه مفوفه ال
        System.out.print("\nDi= ");
        for(int i=0;i<SumThreechar.length;i++)
            System.out.print("("+SumThreechar[i]+") ");
        System.out.println("\n                                      Fitness=Ti+Di               ");
        System.out.print("Fitness= ");
        //طباعه مصفوفه الفتنس//
        for(int i=0;i<fi.length;i++)
            System.out.print("("+fi[i]+") ");
        System.out.println("");
   } 
 
 
    
}
