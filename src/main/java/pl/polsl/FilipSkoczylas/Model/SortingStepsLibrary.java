/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;
import java.util.ArrayList;

/**
 *
 * @author SuperStudent-PL
 */
public class SortingStepsLibrary {
    private ArrayList<int[]> sortingSteps;
    private int arrayLength;
    public SortingStepsLibrary(int arrayLength){
        sortingSteps= new ArrayList<int[]>();
        this.arrayLength = arrayLength;
    }
    public void addStep(int[] array){
        if(array.length == arrayLength){
        sortingSteps.add(array);
        }
    }
    public int getAmountOfSteps(){
        return sortingSteps.size();
    }
    public int[] getStep(int index){
        if(index >= 0 && index < sortingSteps.size()){
        return sortingSteps.get(index);
        }
        return null;
    }
}
