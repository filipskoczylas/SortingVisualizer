/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Controller;

import java.util.ArrayList;
import java.util.Arrays;
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
        parseArgsIntoArray(Arrays.copyOfRange(args, 1, args.length));
    }
    public void performSorting(){
        viewMenager.printArray(inputArray);
    }
    
    private boolean determineSortingType(String command){
        boolean result = false;
        switch(command){
            case "-is":
                targetSorting = TargetSorting.InsertionSort;
                result = true;
                break;
            case "-qs":
                targetSorting = TargetSorting.QuickSort;
                result = true;
                break;
            case "-ss":
                targetSorting = TargetSorting.SelectionSort;
                result = true;
                break;
            default:
                result = false;
        }
        return result;
    }
    private void parseArgsIntoArray(String[] args){
        inputArray = new int[args.length];
        for (int i = 1; i < args.length; i++) {
            try{
                int value = Integer.parseInt(args[i]);
                inputArray[i] = value;
            }
            catch (NumberFormatException ex){
                viewMenager.printText("\"" + args[i] + 
                        "\" is not a number, 0 put into array instead. ");               
            }
        }
    }
    private int parseStringToInt(String input){
        int result = -1;
        try{
            result = Integer.parseInt(input);
            if(result < 0){
                viewMenager.printText("Number has to be equal or larger than 0");
                result = -1;
            }
        }
        catch (NumberFormatException ex){
            viewMenager.printText("\"" + input + 
                        "\" is not a number"); 
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
                int integerInput = parseStringToInt(input);
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
