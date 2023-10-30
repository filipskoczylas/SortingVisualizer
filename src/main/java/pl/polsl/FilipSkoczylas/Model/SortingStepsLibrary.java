/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;
import java.util.ArrayList;

/**
 *  Class represends library of steps needed to sort an array. 
 * @author Filip Skoczylas
 * @since p1
 */
public class SortingStepsLibrary {
    private ArrayList<int[]> sortingSteps;
    private int arrayLength;
    /**
     * Class constructor. 
     * @param arrayLength length of sorted array. 
     */
    public SortingStepsLibrary(int arrayLength){
        sortingSteps= new ArrayList<int[]>();
        this.arrayLength = arrayLength;
    }
    /**
     * Method used to add sorting step. 
     * @param array array, that represents sorting step
     */
    public void addStep(int[] array){
        if(array.length == arrayLength){
        sortingSteps.add(array);
        }
    }
    /**
     * Method used to get amoint of steps needed to sort an array. 
     * @return amount of steps needed to sort an array. 
     */
    public int getAmountOfSteps(){
        return sortingSteps.size();
    }
    /**
     * Method used to get sorting step. 
     * @param index index of step
     * @return array representing sorting step
     */
    public int[] getStep(int index){
        int[] result = null;
        if(index >= 0 && index < sortingSteps.size()){
        result = sortingSteps.get(index);
        }
        return result;
    }
}
