/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.View;

/**
 * Class used to display data in console. 
 * @author Filip Skoczylas
 * @since f1
 */
public class ViewMenager {
    /**
     * Class base constructor. 
     */
    public ViewMenager(){ }
    
    /**
     * Method used to print text in console. 
     * @param text text that will be printed
     */
    public void printText(String text){
        System.out.println(text);
    }
    
    /**
     * Method used to print array. 
     * @param array array that will be printed
     */
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
    
    /**
     * Method used to indicate, that array will be printed. 
     */
    public void entitleArray(){
        printSeparator();
        printText("Sorting steps: ");
    }
    /**
     * Method used to print separator consisting of '-' chars. 
     */
    private void printSeparator(){
        System.out.println("------------------------------------------------------------------------");
    }
}
