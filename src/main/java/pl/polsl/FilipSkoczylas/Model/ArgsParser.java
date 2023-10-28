/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;

/**
 *
 * @author Filip
 */
public class ArgsParser {
    public ArgsParser(){}
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
