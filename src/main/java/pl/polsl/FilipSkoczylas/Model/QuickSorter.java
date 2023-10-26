/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;

/**
 *
 * @author SuperStudent-PL
 */
public class QuickSorter implements Sorter{
    @Override
    public SortingStepsLibrary sortArray(int[] array){
        SortingStepsLibrary library = new SortingStepsLibrary(array.length);
        return library;
    }
}
