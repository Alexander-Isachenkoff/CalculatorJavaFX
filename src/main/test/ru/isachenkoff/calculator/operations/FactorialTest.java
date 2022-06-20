package ru.isachenkoff.calculator.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    
    @Test
    void apply() {
        Factorial factorial = new Factorial();
        factorial.setOperand(3);
        
        CalculationResult result = factorial.calc();
        
        assertEquals("3! = ", result.getStatement());
        assertEquals(6, result.getResult());
    }
}