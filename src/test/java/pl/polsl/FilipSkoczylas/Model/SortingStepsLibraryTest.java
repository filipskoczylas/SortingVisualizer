/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author Filip
 */
public class SortingStepsLibraryTest {
    
    SortingStepsLibrary library;
    ArrayList<Integer> step;
    
    //Initializes baisic objects used in tests
    @BeforeEach
    public void setUp() {
        library = new SortingStepsLibrary(3);
        step = new ArrayList<Integer>();
        step.add(1);
        step.add(2);
        step.add(3);
    }
    
    //Tests if library can hold multiple instances of same list
    @ParameterizedTest
    @MethodSource("generateCorrectData")
    public void testAddStep(ArrayList<Integer> list){
        library = new SortingStepsLibrary(list.size());
        library.addStep(list);
        library.addStep(list);
        library.addStep(list);
        assertEquals(list, library.getStep(0));
        assertEquals(list, library.getStep(1));
        assertEquals(list, library.getStep(2));
    }
    
    //Tests if library returns valid number of steps, that are inside
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 4, 6}) 
    public void testGetAmountOfSteps(int length){
        for(int i = 0; i < length; i++){
            library.addStep(step);
        }
        assertEquals(length, library.getAmountOfSteps());
    }
    
    //Test if method returns same list
    @ParameterizedTest
    @MethodSource("generateCorrectData")
    public void testGetStep(ArrayList<Integer> list){
        int size = list.size();
        library = new SortingStepsLibrary(size);
        step = new ArrayList<Integer>();
        for(int i = 0; i < size; i++){
            step.add(i);
        }
        library.addStep(list);
        library.addStep(step);
        library.addStep(list);
        library.addStep(step);
        library.addStep(list);
        library.addStep(list);
        assertEquals(list, library.getStep(0));
        assertEquals(list, library.getStep(2));
        assertEquals(list, library.getStep(4));
        assertEquals(list, library.getStep(5));
    }
    
    //Tests what happens when wrong data size is given to function
    @ParameterizedTest
    @MethodSource("generateWrongData")
    public void testIncorrectInputValues(ArrayList<Integer> list){
        int size = list.size() + 1;
        library = new SortingStepsLibrary(size);
        library.addStep(list);
        assertEquals(null, library.getStep(0));
    }
    
    //Tests what happens when get function is used to acce non-existent step
    @ParameterizedTest
    @MethodSource("generateWrongData")
    public void testIncorrectOutputValues(ArrayList<Integer> list){
        int size = list.size() + 1;
        library = new SortingStepsLibrary(size);
        library.addStep(list);
        assertEquals(null, library.getStep(1));
        assertEquals(null, library.getStep(-1));
        assertEquals(null, library.getStep(100));
        assertEquals(null, library.getStep(256));
    }
    
    //Generates data used in correct value tests
    private static Stream<Arguments> generateCorrectData(){
        return Stream.of(
                Arguments.of(new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                Arguments.of(new ArrayList<Integer>(Arrays.asList(5, 4, 1))), 
                Arguments.of(new ArrayList<Integer>(Arrays.asList(5, 4, 1, 10, 15, 154))), 
                Arguments.of(new ArrayList<Integer>())
        );
    }
    
    //Generates data used in incorrect value tests
    private static Stream<Arguments> generateWrongData(){
        return Stream.of(
                Arguments.of(new ArrayList<Integer>(Arrays.asList(55))),
                Arguments.of(new ArrayList<Integer>(Arrays.asList(5, 12))), 
                Arguments.of(new ArrayList<Integer>(Arrays.asList(5, 4, 1, 10, 15, 154))), 
                Arguments.of(new ArrayList<Integer>())
        );
    }

}
