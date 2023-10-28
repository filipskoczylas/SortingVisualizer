/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;

import java.util.Arrays;

/**
 *
 * @author SuperStudent-PL
 */
public class SelectionSorter implements Sorter {
    @Override
    public SortingStepsLibrary sortArray(int[] array){
        SortingStepsLibrary library = new SortingStepsLibrary(array.length);
        library.addStep(Arrays.copyOf(array, array.length));
        for (int i = 0; i < array.length; i++) {
            int minIdx = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[minIdx]){
                    minIdx = j;
                }
            }
            //Swap values if array[i] isn't minimal value
            if(minIdx != i){
                int swapTemp = array[minIdx];
                array[minIdx] = array[i];
                array[i] = swapTemp;
            }
            library.addStep(Arrays.copyOf(array, array.length));
        }
        return library;
    }
}
