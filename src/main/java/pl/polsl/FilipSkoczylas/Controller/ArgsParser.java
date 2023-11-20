/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Controller;

import java.util.ArrayList;

/**
 * Class used to parse arguments from sting to other types. 
 * @author Filip Skoczylas
 * @since f1
 */
public class ArgsParser {
    /**
     * Class base constructor. 
     */
    public ArgsParser(){}
    /**
     * Method used to convert string representations of integers, into integer array. 
     * @param args string array, that should be filled with integers
     * @return integer array
     * @throws IllegalArgumentException when integers are smaller than 0
     * @throws NumberFormatException when arguments are not integers
     */
    public ArrayList<Integer> parseArgsIntoArray(String[] args)
            throws IllegalArgumentException, NumberFormatException{
        ArrayList<Integer> inputArray = new ArrayList<>();
        // foreach loop - university requirement
        for (String arg : args) {
            try {
                int value = Integer.parseInt(arg);
                //Values have to be greater than 0
                if(value < 0){
                    throw new IllegalArgumentException();
                }
                //New Integer is used, because array printing is performed by stream
                //It is impossible not to print ", " at the end of array without using this  method
                inputArray.add(new Integer(value));
            }catch (NumberFormatException ex){
                throw ex;
            }
        }
        return inputArray;
    }
    /**
     * Method used to convert string into integer
     * @param input string, that will be converted
     * @return integer representation of string
     * @throws IllegalArgumentException when integer is smaller than 0
     * @throws NumberFormatException when string is not an integer
     */
    public Integer parseStringToInt(String input)
            throws IllegalArgumentException, NumberFormatException{
        //New Integer is used, because array printing is performed by stream
        //It is impossible not to print ", " at the end of array without using this  method
        Integer result = new Integer (-1);
        try{
            result = new Integer(Integer.parseInt(input));
            if(result < 0){
               throw new IllegalArgumentException();
            }
        }
        catch (NumberFormatException ex){
            throw ex;
        }
        return result;
    }
}
