/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;

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
    public int[] parseArgsIntoArray(String[] args)
            throws IllegalArgumentException, NumberFormatException{
        int[] inputArray = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            try{
                int value = Integer.parseInt(args[i]);
                //Values have to be greater than 0
                if(value < 0){
                    throw new IllegalArgumentException();
                }
                inputArray[i] = value;
            }
            catch (NumberFormatException ex){
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
    public int parseStringToInt(String input)
            throws IllegalArgumentException, NumberFormatException{
        int result = -1;
        try{
            result = Integer.parseInt(input);
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
