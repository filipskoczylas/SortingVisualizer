/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;

import java.util.Arrays;

/**
 * Class impements sorter interface. 
 * Used to perform insertion sorting. 
 * @author Filip Skoczylas
 * @since p1
 */
public class InsertionSorter implements Sorter {
    /**
     * Method that sorts given array, and saves sorting steps into library. 
     * @param array integer array that will be sorted
     * @return library containing sorting steps
     */
    @Override
    public SortingStepsLibrary sortArray(int[] array){
        SortingStepsLibrary library = new SortingStepsLibrary(array.length);
        library.addStep(Arrays.copyOf(array, array.length));
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            for(int j = i - 1; j >=0; j--){
                if(array[j] > key){
                    array[j+1] = array[j];
                    array[j] = key;
                    library.addStep(Arrays.copyOf(array, array.length));
                }
                else{
                    break;
                }
            }
        }
        return library;
    }
}
