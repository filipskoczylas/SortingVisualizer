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
 * Controller class, menages data, and sends orders to view and model classes. 
 * @author Filip Skoczylas
 * @version %I%, %G%
 * @since p1
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
    
    /**
     * Controller constructor. 
     * @param args Controller initialization args args
     * ("-qs" - quick sort, "-is" - insertion sort "-ss" - selection sort)
     * next params are integer representation of array, that will be sorted
     * @since p1
     */
    public AppController(String[] args){
        //Initialize view objects
        viewMenager = new ViewMenager();
        keyInputLoader = new KeyInputLoader();
        argsParser = new ArgsParser();
        //no parameters given, ask for parameters
        if(args == null || args.length == 0){
            askForInputParameters();
            return;
        }
        //Wrong sorting type given, ask for sorting type
        if(determineSortingType(args[0]) == false){
            askForSortingType();
        }
        //Integer array too short, ask for integer array
        if(args.length < 3){
            askForInputArray();
            return;
        }
        //try parsing integer array        
        try{
            inputArray = argsParser.parseArgsIntoArray(Arrays.copyOfRange(args, 1, args.length));
        }
        //Inform user about wrong data, and ask for integer array if neccesary
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
    /**
     * Method prepares sorting steps of given sorting type, and prints them to terminal
     * @since p1
     */
    public void performSorting(){
        //prepare sorting steps
        SortingStepsLibrary steps = sorter.sortArray(inputArray);
        viewMenager.entitleArray();
        //print sorting steps
        //in future steps should be displayed in GUI
        for (int i = 0; i < steps.getAmountOfSteps(); i++) {
            viewMenager.printArray(steps.getStep(i));
        }    
    }
    /**
     * Method validates weather given parameter is valid sorting type, and initializes sorter interface
     * @param command parameter, determining sorting type
     * @return true if command is valid, else false
     */
    private boolean determineSortingType(String command){
        boolean result = false;
        //Function structure makes it easy to implement new sorting types
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

    /**
     * Method asks user for input parameters, that should be put as command line arguments. 
     */
    private void askForInputParameters(){
        viewMenager.printText("No input arguments. ");
        askForSortingType();
        askForInputArray();
    }
    /**
     * Method asks user for sorting type. 
     */
    private void askForSortingType(){
        do{
            viewMenager.printText("Please type sorting type (-is, -qs, -ss)");
        }while (determineSortingType(keyInputLoader.getSortingType()) == false);        
    }
    /**
     * Method asks user for input integer array, that will be sorted. 
     */
    private void askForInputArray(){
        viewMenager.printText("Please type numbers, which you want to include in array. "
                + "\nNumbers have to be 0 or larger. "
                + "\nType \"end\" to end inputing array");
        ArrayList<Integer> inputArrayList = new ArrayList<Integer>();
        askForArrayElements(inputArrayList);
        
        //Convert array list into array
        inputArray = new int[inputArrayList.size()];
        for (int i = 0; i < inputArrayList.size(); i++) {
            inputArray[i] = inputArrayList.get(i);
        }
    }
    /**
     * Method asks user for input integer array and puts user input into input integer array. 
     * @param inputArrayList array list, in which integers will be put
     */
    private void askForArrayElements(ArrayList<Integer> inputArrayList){
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
    }
}
