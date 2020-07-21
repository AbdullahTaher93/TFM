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

        }   


}
