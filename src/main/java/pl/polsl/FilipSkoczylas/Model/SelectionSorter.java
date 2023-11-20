/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;

import java.util.ArrayList;

/**
 * Class impements sorter interface. 
 * Used to perform selection sorting. 
 * @author Filip Skoczylas
 * @since p1
 */
public class SelectionSorter implements Sorter {
     /**
     * Method that sorts given array, and saves sorting steps into library. 
     * @param array integer array that will be sorted
     * @return library containing sorting steps
     */
    @Override
    public SortingStepsLibrary sortArray(ArrayList<Integer> array){
        SortingStepsLibrary library = new SortingStepsLibrary(array.size());
        library.addStep((ArrayList)array.clone());
        for (int i = 0; i < array.size(); i++) {
            int minIdx = i;
            for(int j = i + 1; j < array.size(); j++){
                if(array.get(j) < array.get(minIdx)){
                    minIdx = j;
                }
            }
            //Swap values if array[i] isn't minimal value
            if(minIdx != i){
                int swapTemp = array.get(minIdx);
                array.set(minIdx, array.get(i));
                array.set(i, swapTemp);
            }
            library.addStep((ArrayList)array.clone());
        }
        return library;
    }
}
