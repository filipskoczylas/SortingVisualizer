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
    private ArrayList<ArrayList<Integer>> sortingSteps;
    private int arrayLength;
    /**
     * Class constructor. 
     * @param arrayLength length of sorted array. 
     */
    public SortingStepsLibrary(Integer arrayLength){
        sortingSteps= new ArrayList<ArrayList<Integer>>();
        this.arrayLength = arrayLength;
    }
    /**
     * Method used to add sorting step. 
     * @param array array, that represents sorting step
     */
    public void addStep(ArrayList array){
        if(array.size() == arrayLength){
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
    public ArrayList<Integer> getStep(int index){
        ArrayList<Integer> result = null;
        if(index >= 0 && index < sortingSteps.size()){
            result = sortingSteps.get(index);
        }
        return result;
    }
}
