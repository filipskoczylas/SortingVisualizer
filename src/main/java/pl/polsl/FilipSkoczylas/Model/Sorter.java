/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;

import java.util.ArrayList;

/**
 * Interface for sorters, that will be used to srot arrays. 
 * @author Filip Skoczylas
 * @since p1
 */
public interface Sorter {
    /**
     * Method that sorts given array, and saves sorting steps into library. 
     * @param array integer array that will be sorted
     * @return library containing sorting steps
     */
    public SortingStepsLibrary sortArray(ArrayList<Integer> array);
}
