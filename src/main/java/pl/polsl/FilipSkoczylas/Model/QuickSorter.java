/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class impements sorter interface. 
 * Used to perform quick sorting. 
 * @author Filip Skoczylas
 * @since p1
 */
public class QuickSorter implements Sorter{
    // library is class atribute, because quick sorting is an recursive function
    private SortingStepsLibrary library;
     /**
     * Method that sorts given array, and saves sorting steps into library. 
     * @param array integer array that will be sorted
     * @return library containing sorting steps
     */
    @Override
    public SortingStepsLibrary sortArray(ArrayList<Integer> array){
        library = new SortingStepsLibrary(array.size());
        library.addStep((ArrayList<Integer>)array.clone());
        quickSort(array, 0, array.size() - 1);
        return library;
    }
    
    private void quickSort(ArrayList<Integer> array, int begin, int end) {
    if (begin < end) {
        int partitionIndex = generatePartitionIndex(array, begin, end);

        quickSort(array, begin, partitionIndex-1);
        quickSort(array, partitionIndex+1, end);
    }
}

    private int generatePartitionIndex(ArrayList<Integer> array, int begin, int end) {
        int pivot = array.get(end);
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (array.get(j) <= pivot) {
                i++;

                int swapTemp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, swapTemp);
                //if values where cahnged, add step
                if(i!=j){
                    library.addStep((ArrayList)array.clone());
                }
            }
        }

        int swapTemp = array.get(i+1);
        array.set(i+1,  array.get(end));
        array.set(end, swapTemp);
        //if values where cahnged, add step
        if((i+1) != end){
            library.addStep((ArrayList)array.clone());
        }
        return i+1;
    }
}
