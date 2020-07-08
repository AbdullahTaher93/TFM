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

    public Fitness(String[] Array_Of_PlainTest,int key[][]) {
        
        Twocharcount=new int[Array_Of_PlainTest.length][Threechar.length];
        Threecharcount=new int[Array_Of_PlainTest.length][Threechar.length];
        SumTwochar=new double[Array_Of_PlainTest.length];
        SumThreechar=new double[Array_Of_PlainTest.length];
    }

    
    
 
 
    
}
