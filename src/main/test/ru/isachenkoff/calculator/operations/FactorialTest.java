package ru.isachenkoff.calculator.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    
    @Test
    void apply() {
        Factorial factorial = new Factorial();
        double result = factorial.apply(5);
        
        assertEquals(120, result);
    }
    
    @Test
    void apply_decimal() {
        Factorial factorial = new Factorial();
        double result = factorial.apply(2.5);
        
        assertEquals(Double.NaN, result);
    }
    
}