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
    String newpopulionPlaint[];

    int temp[];
    int[][] child;
    String Crossover_Operator="";
    public CrossOver(int SelectedKey[][],String SelectedPlainText[],int type_of_crossover,boolean keeps_parents) {
        
        corssover=new int[SelectedKey.length][SelectedKey[0].length];
        Array_Of_PlainTest=new String[SelectedKey.length];
        child=new int[SelectedKey.length][SelectedKey[0].length];
        newpopulionKey=new int[SelectedKey.length*2][SelectedKey[0].length];
        newpopulionPlaint=new String[SelectedKey.length*2];

         temp=new int[SelectedKey[0].length/2];
         
         
        
        
        
      
       switch(type_of_crossover){
           case 0:  
               crossing(SelectedKey);
               if(keeps_parents==true){
                   marriage_keys(corssover,SelectedKey);
                    Crossover_Operator="My CrossOver Operator";}
               
               else{
                    for(int i=0;i<SelectedKey.length;i=i+2)
        {
           onePoint(SelectedKey, i, i+1);
          /// Davis_Order(SelectedKey,i,i+1);
            
        } marriage_keys(corssover,child);
           Crossover_Operator="My CrossOver Operator with One Point Operator ";
               }
               
               break;
           case 1: 
               Crossover_Operator="One Point Operator ";
                for(int i=0;i<SelectedKey.length;i=i+2)
                    {
                      onePoint(SelectedKey, i, i+1);
                        /// Davis_Order(SelectedKey,i,i+1);
            
                     }
               if(keeps_parents==true)
                   marriage_keys(child,SelectedKey);
               else{
                    crossing(SelectedKey);
                    marriage_keys(corssover,child);
                    Crossover_Operator="One Point Operator with my CrossOver Operator ";
               }
               
               break;
           case 2:  
               Crossover_Operator="Davis_Order Operator with my CrossOver Operator ";
               for(int i=0;i<SelectedKey.length;i=i+2)
                    {
                     // onePoint(SelectedKey, i, i+1);
                        Davis_Order(SelectedKey,i,i+1);
            
                     }
               if(keeps_parents==true)
                   marriage_keys(child,SelectedKey);
               else{
                    crossing(SelectedKey);
                    Crossover_Operator="Davis_Order Operator with my CrossOver Operator ";
                    marriage_keys(corssover,child);
               }
               break;
       }
        
        
        
        print(SelectedPlainText,child); 

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

   
    private void onePoint(int[][] keys,int parent1, int parent2 ){
       int index1= keys.length/2;
       int index2=keys.length/2;
        for(int i=0;i<keys[parent1].length/2;i++){
            child[parent1][i]=keys[parent1][i];
            child[parent2][i]=keys[parent2][i];
            
        }
        
        for(int i=0;i<keys[parent2].length;i++){
            
                if(!ChechBit(parent1,keys[parent2][i])){
                    
                   child[parent1][index1]=keys[parent2][i];
                   index1++;
                }
                if(!ChechBit(parent2,keys[parent1][i])){
                   child[parent2][index2]=keys[parent1][i];
                   index2++;
                }
            
        }
  
    }
  
    private void Davis_Order(int[][] keys,int parent1, int parent2 ){
        int numbers_of_point=keys[0].length/3;
        int index1=0;
        int index2=0;
        for(int i=0;i<numbers_of_point;i++){
            if(i%2==0){
               
                
            }else{
                for(int j=numbers_of_point;j<numbers_of_point*2;j++){
                    child[parent1][j]=keys[parent1][j];
                    child[parent2][j]=keys[parent2][j];
                    index1=index1+numbers_of_point;
                    index2=index2+numbers_of_point;
                    
                }
            }
        }
       
                
              
               for(int i=0;i<keys[parent2].length;i++){
            
                if(!ChechBit(parent1,keys[parent2][i])){
                    for(int j=0;j<child[parent1].length;j++){
                        if(child[parent1][j]==0){
                        child[parent1][j]=keys[parent2][i];
                                break;
                        }
                    }
                   
                   
                }
                if(!ChechBit(parent2,keys[parent1][i])){
                    
                        for(int j=0;j<child[parent2].length;j++){
                        if(child[parent2][j]==0){
                        child[parent2][j]=keys[parent1][i];
                                break;
                        }
                    }
                   
                  
                }
            
        }
                
            
            
        
       
        
        
    }
    
    
    

    public void print(String selecplain[],int[][] AnewClidren){
        for(int i=0;i<AnewClidren.length;i++)
            {
            for(int j=0;j<AnewClidren[i].length;j++)
            System.out.print(" "+AnewClidren[i][j]+" ");
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

    private boolean ChechBit(int parent, int i) {
        boolean flag =false;
        for(int index=0;index<child[0].length;index++){
           if(child[parent][index]==i)
           {
               flag=true;
               break;
           }
       }
    return flag;
    }

    
}
   



