/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.FilipSkoczylas.Model;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author Filip
 */
public class SortingStepsLibraryTest {
    
    SortingStepsLibrary library;
    
    @BeforeEach
    public void setUp() {
        library = new SortingStepsLibrary(3);
    }
    @Test
    public void testAddStep(){
        
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 6}) 
    public void testGetAmountOfSteps(int length){
        ArrayList<Integer> step = new ArrayList<>();
        step.add(1);
        step.add(2);
        step.add(3);
        for(int i = 0; i < length; i++){
            library.addStep(step);
        }
        assertEquals(length, library.getAmountOfSteps());
    }
    @Test
    public void testGetStep(){
        
    }
    @Test
    public void testWholeModule(){
        
    }
}
