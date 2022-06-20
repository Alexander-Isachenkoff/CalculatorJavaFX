package ru.isachenkoff.calculator.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LnTest {
    
    @Test
    void apply() {
        double result = new Ln().apply(5);
        assertEquals(1.6094379124341003, result);
    }
    
    @Test
    void apply_negative() {
        double result = new Ln().apply(-5);
        assertEquals(Double.NaN, result);
    }
    
}