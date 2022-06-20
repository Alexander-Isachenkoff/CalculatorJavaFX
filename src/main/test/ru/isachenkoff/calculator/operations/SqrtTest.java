package ru.isachenkoff.calculator.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SqrtTest {
    
    @Test
    void apply() {
        Sqrt sqrt = new Sqrt();
        sqrt.setOperand(5);
        CalculationResult calculationResult = sqrt.calc();
        assertEquals("√5 = ", calculationResult.getStatement());
        assertEquals(2.23606797749979, calculationResult.getResult());
        assertEquals("√5 = 2,2360679775", calculationResult.toString());
    }
    
    @Test
    void applyNegative() {
        Sqrt sqrt = new Sqrt();
        sqrt.setOperand(-1);
        CalculationResult result = sqrt.calc();
        assertEquals("√-1 = ", result.getStatement());
        assertEquals(Double.NaN, result.getResult());
        assertEquals("√-1 = не число", result.toString());
    }
}