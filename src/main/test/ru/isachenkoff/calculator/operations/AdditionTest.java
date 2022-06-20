package ru.isachenkoff.calculator.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTest {
    
    @Test
    void apply() {
        Addition addition = new Addition();
        double result = addition.apply(3.0, 1.5);
        assertEquals(4.5, result);
    }
    
    //    @Test
    //    void calc() {
    //        Addition addition = new Addition();
    //        addition.setFirstOperand(5.0);
    //        addition.setSecondOperand(10.0);
    //        CalculationResult calc = addition.calc();
    //        assertEquals("5 + 10 = ", calc.getStatement());
    //        assertEquals(15, calc.getResult());
    //    }
    //
    //    @Test
    //    void calc_2() {
    //        Addition addition = new Addition();
    //        addition.setFirstOperand(5.5);
    //        addition.setSecondOperand(6.5);
    //        CalculationResult calc = addition.calc();
    //        assertEquals("5,5 + 6,5 = ", calc.getStatement());
    //        assertEquals(12, calc.getResult());
    //    }
    
}