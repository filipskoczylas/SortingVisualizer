/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.View;

/**
 *
 * @author SuperStudent-PL
 */
public class ViewMenager {
    public ViewMenager(){
    }
    public void printText(String text){
        System.out.println(text);
    }
    public void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            if(i != (array.length - 1)){
                System.out.print(array[i]+", ");
            }
            else{
                System.out.print(array[i]);
            }
        }
        System.out.println("");
    }
    
    public void entitleArray(){
        printSeparator();
        printText("Sorting steps: ");
    }
    private void printSeparator(){
        System.out.println("------------------------------------------------------------------------");
    }
}
