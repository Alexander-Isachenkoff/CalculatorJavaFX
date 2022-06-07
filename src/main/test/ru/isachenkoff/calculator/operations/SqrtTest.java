package ru.isachenkoff.calculator.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SqrtTest {
    
    @Test
    void apply() {
        Sqrt sqrt = new Sqrt(5);
        CalculationResult calculationResult = sqrt.calc();
        assertEquals("√5", calculationResult.getStatement());
        assertEquals(2.23606797749979, calculationResult.getResult());
    }
}