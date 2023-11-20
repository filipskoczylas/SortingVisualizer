/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;

import java.util.ArrayList;

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
    public SortingStepsLibrary sortArray(ArrayList<Integer> array){
        SortingStepsLibrary library = new SortingStepsLibrary(array.size());
        library.addStep((ArrayList)array.clone());
        for (int i = 1; i < array.size(); i++) {
            int key = array.get(i);
            for(int j = i - 1; j >=0; j--){
                if(array.get(j).intValue() > key){
                    //New Integer is used, because array printing is performed by stream
                    //It is impossible not to print ", " at the end of array without using this  method
                    array.set(j+1, new Integer(array.get(j)));
                    array.set(j, new Integer(key));
                    library.addStep((ArrayList)array.clone());
                }
                else{
                    break;
                }
            }
        }
        return library;
    }
}
