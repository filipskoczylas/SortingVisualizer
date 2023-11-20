/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author Filip
 */
public class InsertionSorterTest {
    
    InsertionSorter sorter;
    
    //Initialize sorter
    @BeforeEach
    public void setUp() {
        sorter = new InsertionSorter();
    }
    
    //Tests weather array is being sort by the sorter. 
    //Sorting method doesn't have any incorrect situations. Empty array is one of tested scenarios. 
    @ParameterizedTest
    @MethodSource("generateData")
    public void testSorting(ArrayList<Integer> list){
        SortingStepsLibrary library = sorter.sortArray(list);
        Collections.sort(list);
        assertEquals(library.getStep(library.getAmountOfSteps() - 1), list);
    }
    
    //Generates data used in tests
    private static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of(new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                Arguments.of(new ArrayList<Integer>(Arrays.asList(5, 4, 1))), 
                Arguments.of(new ArrayList<Integer>(Arrays.asList(5, 4, 1, 10, 15, 154))), 
                Arguments.of(new ArrayList<Integer>())
        );
    }
}
