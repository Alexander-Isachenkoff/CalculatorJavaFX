package ru.isachenkoff.calculator.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperandBuilderTest {
    
    @Test
    void test() {
        OperandBuilder operandBuilder = new OperandBuilder();
        operandBuilder.addNumber("1");
        operandBuilder.addNumber("2");
        operandBuilder.addPoint();
        operandBuilder.addNumber("3");
        operandBuilder.addPoint();
        operandBuilder.deleteLastChar();
        operandBuilder.addNumber("4");
        
        assertEquals("12,4", operandBuilder.getOperand().getValue());
        assertEquals(12.4, operandBuilder.getOperandDouble());
    }
    
}