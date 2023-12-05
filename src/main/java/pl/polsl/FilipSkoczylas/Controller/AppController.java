/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import javax.swing.JFrame;
import pl.polsl.FilipSkoczylas.Model.InsertionSorter;
import pl.polsl.FilipSkoczylas.Model.QuickSorter;
import pl.polsl.FilipSkoczylas.Model.SelectionSorter;
import pl.polsl.FilipSkoczylas.Model.Sorter;
import pl.polsl.FilipSkoczylas.Model.SortingStepsLibrary;
import pl.polsl.FilipSkoczylas.View.MainPanel;
import pl.polsl.FilipSkoczylas.View.MessageBox;
import pl.polsl.FilipSkoczylas.View.TablePanel;

/**
 * Controller class, menages data, and sends orders to view and model classes. 
 * @author Filip Skoczylas
 * @version f1
 * @since p1
 */
public class AppController {
    private ArrayList<Integer> inputArray;
    private Sorter sorter;
    private ArgsParser argsParser;
    private MainPanel mainPanel;
    private TablePanel tablePanel;
    private JFrame frame;
    private enum FrameType{
        Main, 
        Table
    }
    
    /**
     * Controller constructor. 
     * @param args Controller initialization args args
     * ("-qs" - quick sort, "-is" - insertion sort "-ss" - selection sort)
     * next params are integer representation of array, that will be sorted
     * @since p1
     */
    public AppController(String[] args){
        //Initialize view objects
        argsParser = new ArgsParser();
        tablePanel = new TablePanel(this);
        parseArguments(args);
    }
    /**
     * Method parses input parameters into application options, 
     * and if they are wrong asks for new input parameters
     * @param args Controller initialization args
     */
    public void parseArguments(String[] args){
    //no parameters given, or too little parameters, ask for parameters
        if(args == null || args.length < 3){
            MessageBox.show("Input array too short", "Error");
            createGUIFrame(FrameType.Table);
            return;
        }
        //Wrong sorting type given, ask for sorting type
        if(determineSortingType(args[0]) == false){
            MessageBox.show("Invalid sorting type", "Error");
            createGUIFrame(FrameType.Table);
            return;
        }

        //try parsing integer array        
        try{
            inputArray = argsParser.parseArgsIntoArray(Arrays.copyOfRange(args, 1, args.length));
        }
        //Inform user about wrong data, and ask for integer array if neccesary
        catch(NumberFormatException ex){
            MessageBox.show("Not all array elements are integers", "Error");
            createGUIFrame(FrameType.Table);
            return;
        }
        catch(IllegalArgumentException ex){
            MessageBox.show("Array values out of range (0 - 500)", "Error");
            createGUIFrame(FrameType.Table);
            return;
        }
        if(frame != null){
            frame.setVisible(false);
            frame.dispose();
        }
        mainPanel = new MainPanel(inputArray.size(), 
                inputArray.stream().mapToInt(v->v).max().orElseThrow(NoSuchElementException::new));
        createGUIFrame(FrameType.Main);
    }
    /**
     * Method prepares sorting steps of given sorting type, and prints them to terminal
     * @since p1
     */
    public void performSorting(){
        //prepare sorting steps
        SortingStepsLibrary steps = sorter.sortArray(inputArray);
        //print sorting steps
        for (int i = 0; i < steps.getAmountOfSteps(); i++) {
            //viewMenager.printArray(steps.getStep(i));
            mainPanel.setArray(steps.getStep(i));
            try{
                Thread.sleep(200);
            }
            catch (InterruptedException e){}
        }    
    }
    /**
     * Method creates new JFrame in another thread
     * @param type type of created JFrame 
     */
    private void createGUIFrame(FrameType type){
        new Thread() {
            @Override
            public void run() {
                if(type == FrameType.Table){
                    createAndShowTableGUI();
                }
                else {
                    createAndShowMainGUI();
                }
            }
        }.start();
        //Invoke later method caued bugs, thread used instead
        /*
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if(type == FrameType.Table){
                    createAndShowTableGUI();
                }
                else {
                    createAndShowMainGUI();
                }
            }
        });*/
    }
    /**
     * Method creates and shows JFrame containing array sorting presentation
     */
    private void createAndShowMainGUI() { 
	//utworzenie i przygotowanie okna
        frame = new JFrame("SortingAlgorithmsVisualiser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel widoczny
        mainPanel.setOpaque(true); 
        frame.setContentPane(mainPanel);

        //wyswietlenie okna
        frame.pack();
        frame.setVisible(true);
        //mathod has to be put isnide thread to work properly, otherwise sorted array is displayed
        performSorting();
    }
    
    /**
     * Mehtod creates and shows JFrame containing GUI used to determine sorting type and array values
     */
    private void createAndShowTableGUI() {        
	//utworzenie i przygotowanie okna
        frame = new JFrame("SortingAlgorithmsVisualiser");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //panel widoczny
        tablePanel.setOpaque(true); 
        frame.setContentPane(tablePanel);

        //wyswietlenie okna
        frame.pack();
        frame.setVisible(true);
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
                sorter = new InsertionSorter();
                result = true;
                break;
            case "-qs":
                sorter = new QuickSorter();
                result = true;
                break;
            case "-ss":
                sorter = new SelectionSorter();
                result = true;
                break;
            default:
                result = false;
        }
        return result;
    }
}
