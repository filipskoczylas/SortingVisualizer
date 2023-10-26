/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pl.polsl.FilipSkoczylas;

import pl.polsl.FilipSkoczylas.Controller.AppController;
/**
 *
 * @author Filip Skoczylas
 */
public class Lab1 {
/**
 * @param args first param is sorting type
 * ("-qs" - quick sort, "-is" - insertion sort "-ss" - selection sort)
 * next params are integer representation of array, that will be sorted
 */
    public static void main(String[] args) {
        AppController appController = new AppController(args);
        appController.performSorting();
    }
}
