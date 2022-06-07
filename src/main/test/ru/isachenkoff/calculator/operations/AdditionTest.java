package ru.isachenkoff.calculator.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTest {
    
    @Test
    void prepareStatement() {
    
    }
    
    @Test
    void calc() {
        Addition addition = new Addition(5, 10);
        CalculationResult calc = addition.calc();
        assertEquals("5+10=", calc.getStatement());
        assertEquals(15, calc.getResult());
    }
    
    @Test
    void calc_2() {
        Addition addition = new Addition(5.5, 6.5);
        CalculationResult calc = addition.calc();
        assertEquals("5,5+6,5=", calc.getStatement());
        assertEquals(12, calc.getResult());
    }
    
}