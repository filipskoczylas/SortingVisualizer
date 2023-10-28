/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import pl.polsl.FilipSkoczylas.Model.ArgsParser;
import pl.polsl.FilipSkoczylas.Model.InsertionSorter;
import pl.polsl.FilipSkoczylas.Model.QuickSorter;
import pl.polsl.FilipSkoczylas.Model.SelectionSorter;
import pl.polsl.FilipSkoczylas.Model.Sorter;
import pl.polsl.FilipSkoczylas.Model.SortingStepsLibrary;
import pl.polsl.FilipSkoczylas.View.ViewMenager;
import pl.polsl.FilipSkoczylas.View.KeyInputLoader;

/**
 *
 * @author SuperStudent-PL
 */
public class AppController {
    private int[] inputArray;
    private ViewMenager viewMenager;
    private KeyInputLoader keyInputLoader;
    private Sorter sorter;
    private ArgsParser argsParser;
    private enum TargetSorting{
       InsertionSort, 
       QuickSort, 
       SelectionSort
    }
    private TargetSorting targetSorting;
    
    public AppController(String[] args){
        //initialize view objects
        viewMenager = new ViewMenager();
        keyInputLoader = new KeyInputLoader();
        argsParser = new ArgsParser();
        //no parameters given
        if(args == null || args.length == 0){
            askForInputParameters();
            return;
        }
        //return if no sorting type is determined, or wrong sorting type is given
        if(determineSortingType(args[0]) == false){
            //viewMenager.printText("\"" + args[0] + "\" is not valid sorting type, view documentation to get more information. ");
            askForSortingType();
        }
        if(args.length < 3){
            //viewMenager.printText("Array have to consist of at least 2 integer numbers");
            askForInputArray();
            return;
        }
        try{
            inputArray = argsParser.parseArgsIntoArray(Arrays.copyOfRange(args, 1, args.length));
        }
        catch(NumberFormatException ex){
            viewMenager.printText("Values different than integers in input array"
                    + "\nPlease insert new array");
            askForInputArray();
        }
        catch(IllegalArgumentException ex){
            viewMenager.printText("Values in input array must be greater or equal 0. "
                    + "\nPlease insert new array");
        }
    }
    public void performSorting(){
        SortingStepsLibrary steps = sorter.sortArray(inputArray);
        viewMenager.entitleArray();
        for (int i = 0; i < steps.getAmountOfSteps(); i++) {
            viewMenager.printArray(steps.getStep(i));
        }    
    }
    
    private boolean determineSortingType(String command){
        boolean result = false;
        switch(command){
            case "-is":
                //This sorter is implemented
                targetSorting = TargetSorting.InsertionSort;
                sorter = new InsertionSorter();
                result = true;
                break;
            case "-qs":
                targetSorting = TargetSorting.QuickSort;
                sorter = new QuickSorter();
                result = true;
                break;
            case "-ss":
                targetSorting = TargetSorting.SelectionSort;
                sorter = new SelectionSorter();
                result = true;
                break;
            default:
                result = false;
        }
        return result;
    }

    private void askForInputParameters(){
        viewMenager.printText("No input arguments. ");
        askForSortingType();
        askForInputArray();
    }
    private void askForSortingType(){
        do{
            viewMenager.printText("Please type sorting type (-is, -qs, -ss)");
        }while (determineSortingType(keyInputLoader.getSortingType()) == false);        
    }
    private void askForInputArray(){
        viewMenager.printText("Please type numbers, which you want to include in array. "
                + "\nNumbers have to be 0 or larger. "
                + "\nType \"end\" to end inputing array");
        ArrayList<Integer> inputArrayList = new ArrayList<Integer>();
        while(true){
            String input = keyInputLoader.getArrayElement();
            if (input.equals("end")){
                if (inputArrayList.size() < 2){
                    viewMenager.printText("Array have to consist of at least 2 elements");
                }
                else{
                    break;
                }  
            }
            else{
                int integerInput = -1;
                //Try parsing input
                try{
                integerInput = argsParser.parseStringToInt(input);
                }
                catch(NumberFormatException ex){
                    viewMenager.printText("Error! Value must be an integer greater or equal 0");
                }
                catch(IllegalArgumentException ex){
                    viewMenager.printText("Error! Value must be greater or equal 0");
                }
                
                if(integerInput >= 0){
                    inputArrayList.add(integerInput);
                }
            }
        }
        inputArray = new int[inputArrayList.size()];
        for (int i = 0; i < inputArrayList.size(); i++) {
            inputArray[i] = inputArrayList.get(i);
        }
    }
}
