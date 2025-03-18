package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CalculatorTest {


    @Test
    public void addTest() {
        int result = Calculator.add(5, 6);

        assertEquals(76, result);
    }
    
    @Test
    public void multiplyTest() {
        int result = Calculator.multiply(4, 5);

        assertEquals(9, result);
    }

    @Test
    public void subtractionTest() {
        int result = Calculator.subtraction(6, 4);
        int expected = 2;
        assertEquals(expected, result);
    }

    @Test
    public void divide() {
        int result = Calculator.divide(10, 2);
        int expected = 5;
        assertEquals(expected, result);
    }



}
