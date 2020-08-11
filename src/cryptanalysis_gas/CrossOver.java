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

public class CrossOver {

    public CrossOver() {
    }
    
    int  corssover[][];
    String Array_Of_PlainTest[];

    int newpopulionKey[][];
    String newpopulionPlaint[]=new String[12];

    int temp[]=new int[3];

    public CrossOver(int SelectedKey[][],String SelectedPlainText[]) {
        
        corssover=new int[SelectedKey.length][SelectedKey[0].length];
        Array_Of_PlainTest=new String[SelectedKey.length];

        newpopulionKey=new int[SelectedKey.length*2][SelectedKey[0].length];
        newpopulionPlaint=new String[SelectedKey.length*2];

         temp=new int[SelectedKey[0].length/2];
         crossing(SelectedKey);
         for(int i=0;i<SelectedKey.length;i++) 
                {
                Array_Of_PlainTest[i]="";
                transpostion2(SelectedPlainText[i],i,corssover);
                }
         
        marriage_keys(corssover,SelectedKey);
        marriage_PlainText(Array_Of_PlainTest,SelectedPlainText);
        print(SelectedPlainText); 

        }   

    private void crossing(int[][] SelectedKey) {
    
        for(int i=0;i<SelectedKey.length;i++)
             {
            for(int j=0;j<SelectedKey[0].length/2;j++)
                corssover[i][j]=SelectedKey[i][j];
            for(int j=SelectedKey[0].length/2,k=0;j<SelectedKey.length;j++,k++)
                temp[k]=SelectedKey[i][j];
            exch(); 
            for(int j=0,k=SelectedKey[0].length/2;j<temp.length;j++,k++)
                 corssover[i][k]=temp[j];

         }
    }

    private void exch() {
    for(int i=1;i<temp.length;i++)
       {
          for(int j=i;j>0&&less(temp[j],temp[j-1]);j--)
          es(j,j-1);
       }    
    }

    private boolean less(Comparable v,Comparable w){return v.compareTo(w)<0;}
    private void es(int i,int j){int t=temp[i];temp[i]=temp[j];temp[j]=t;}

    

   
    
    private void transpostion2(String selected_plain,int count,int corssover[][]){
    String cut=""; 
    for(int i=1;i<=selected_plain.length();i++)
      {
          cut=cut+selected_plain.charAt(i-1);
          if(i%corssover[0].length==0)
            {
            SortByKey(cut,count,corssover);
            cut="";

            } 
    }
}

    private void SortByKey(String cut, int count, int[][] corssover) {
        
      String sbk="";
      for(int i=0;i<cut.length();i++)
                sbk=sbk+cut.charAt(corssover[count][i]-1);
             
             Array_Of_PlainTest[count]=Array_Of_PlainTest[count]+sbk;
                }

    private void marriage_keys(int[][] corssover, int[][] SelectedKey) {
    for(int i=0;i<SelectedKey.length;i++){
             {
                 for(int j=0;j<SelectedKey[0].length;j++)
                 {
                     newpopulionKey[i][j]=SelectedKey[i][j];
                     newpopulionKey[i+SelectedKey.length][j]=corssover[i][j];
                 }

             }
        }   
    }

    private void marriage_PlainText(String[] Array_Of_PlainTest, String[] SelectedPlainText) {
       for(int i=0;i<SelectedPlainText.length;i++){
             {
                 for(int j=0;j<SelectedPlainText.length;j++)
                 {
                     newpopulionPlaint[i]=SelectedPlainText[i];
                     
            
                     newpopulionPlaint[i+SelectedPlainText.length]=Array_Of_PlainTest[i];
                 }
                 
             }
         }
    }

    public void print(String selecplain[]){
        for(int i=0;i<corssover.length;i++)
            {
            for(int j=0;j<corssover[i].length;j++)
            System.out.print(" "+corssover[i][j]+" ");
            System.out.println();
            }
        System.out.println();
        System.out.println("Final Table of keyes(New Population)");
        System.out.println("-------------------------------------");
        for(int i=0;i<newpopulionKey.length;i++)
        {
            for(int j=0;j<newpopulionKey[i].length;j++)
            System.out.print(" "+newpopulionKey[i][j]+" ");
            
            System.out.println();
         }  
       
        }
}
   



