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
public class QuickSorter implements Sorter{
    private SortingStepsLibrary library;
    @Override
    public SortingStepsLibrary sortArray(int[] array){
        library = new SortingStepsLibrary(array.length);
        library.addStep(Arrays.copyOf(array, array.length));
        quickSort(array, 0, array.length - 1);
        return library;
    }
    
    private void quickSort(int array[], int begin, int end) {
    if (begin < end) {
        int partitionIndex = generatePartitionIndex(array, begin, end);

        quickSort(array, begin, partitionIndex-1);
        quickSort(array, partitionIndex+1, end);
    }
}

    private int generatePartitionIndex(int array[], int begin, int end) {
        int pivot = array[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;

                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
                //if values where cahnged, add step
                if(i!=j){
                    library.addStep(Arrays.copyOf(array, array.length));
                }
            }
        }

        int swapTemp = array[i+1];
        array[i+1] = array[end];
        array[end] = swapTemp;
        //if values where cahnged, add step
        if((i+1) != end){
            library.addStep(Arrays.copyOf(array, array.length));
        }
        return i+1;
    }
}
