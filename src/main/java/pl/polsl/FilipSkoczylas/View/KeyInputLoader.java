/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.View;
import java.util.Scanner;
/**
 *
 * @author Filip
 */
public class KeyInputLoader {
    Scanner scanner;
    public KeyInputLoader(){}
    public String getSortingType(){
        return getLine();
    }
            
    private String getLine(){
        String result;
        scanner = new Scanner(System.in);
        result = scanner.nextLine();
        return result;
    }
}
