package com.example.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("com.example.calculator.CalculatorTest");
    }

    @Test
    public void testEmptyString() {
        assertEquals(0,StringCalculator.add(""));
    }

    @Test
    public void testOneNumber() {
        assertEquals(1,StringCalculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(5,StringCalculator.add("2,3"));
    }

    @Test
    public void testThreeNumbers() {
        assertEquals(9,StringCalculator.add("2,3,4"));
    }

    @Test
    public void testNewLine() {
        assertEquals(8,StringCalculator.add("1\n3,4"));
    }

    @Test
    public void testOverThousand() {
        assertEquals(3,StringCalculator.add("1000,3"));
    }

    @Test
    public void testOtherDelimiter() {
        assertEquals(6,StringCalculator.add("//;\n2;4"));
    }

    @Test
    public void testNegativeNumber() {
        try {
            StringCalculator.add("-1,2");
        }catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(),"negatives not allowed");
        }

        try {
            StringCalculator.add("1,-2,3,-4");
        }catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(),"negatives not allowed");
        }
    }
}
