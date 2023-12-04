/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pl.polsl.FilipSkoczylas;

import pl.polsl.FilipSkoczylas.Controller.AppController;
/**
 * Class containg main method. 
 * @author Filip Skoczylas
 * @version f1
 * @since p1
 */
public class SortingAlgorithmsVisualizer {
/**
 * Program main method. 
 * @param args first param is sorting type
 * ("-qs" - quick sort, "-is" - insertion sort "-ss" - selection sort)
 * next params are integer representation of array, that will be sorted
 * @since p1
 */
    public static void main(String[] args) {
        AppController appController = new AppController(args);
    }
}
