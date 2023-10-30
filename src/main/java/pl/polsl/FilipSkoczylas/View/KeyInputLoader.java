/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.View;
import java.util.Scanner;
/**
 * Class used to scan for user input. 
 * @author Filip
 * @since f1
 */
public class KeyInputLoader {
    Scanner scanner;
    /**
     * Class constructor. Innitializes scanner. 
     */
    public KeyInputLoader(){
        scanner = new Scanner(System.in);
    }
    /**
     * Wrapper method for getLine(), used to get sorting type. 
     * @return sorting type parameter
     */
    public String getSortingType(){
        return getLine();
    }
    /**
     * Wrapper method for getLine(), used to get array element. 
     * @return array element as String
     */
    public String getArrayElement(){
        return getLine();
    }
    /**
     * Method used to get user input. 
     * @return user input as String
     */
    private String getLine(){
        String result;
        result = scanner.nextLine();
        return result;
    }
}
