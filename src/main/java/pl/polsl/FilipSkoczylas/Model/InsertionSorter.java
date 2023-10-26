/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;

/**
 *
 * @author SuperStudent-PL
 */
public class InsertionSorter implements Sorter {
    @Override
    public SortingStepsLibrary sortArray(int[] array){
        SortingStepsLibrary library = new SortingStepsLibrary(array.length);
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++){
                
            }
            //todo after every sstepadd array to library. then print the library in controller
        }
        return library;
    }
}
