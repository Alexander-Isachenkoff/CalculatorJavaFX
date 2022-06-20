package ru.isachenkoff.calculator.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdditionTest {
    
    @Test
    void toPercentage() {
        double result = new Addition().toPercentage(10, 50);
        assertEquals(5, result);
    }
}