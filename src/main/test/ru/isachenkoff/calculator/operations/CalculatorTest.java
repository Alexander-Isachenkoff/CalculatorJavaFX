package ru.isachenkoff.calculator.operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    
    private Calculator calculator;
    private OperandBuilder operandBuilder;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        operandBuilder = calculator.getOperandBuilder();
    }
    
    @Test
    void test_simpleBinary() {
        operandBuilder.addNumber("5");
        calculator.setOperation(OperationType.ADDITION);
        operandBuilder.addNumber("1");
        calculator.evaluate();
        
        assertEquals("5 + 1 = ", calculator.getCurrentStatementString());
        assertEquals("6", calculator.getCurrentOperandValue());
    }
    
    @Test
    void test_simpleUnary() {
        operandBuilder.addNumber("5");
        calculator.setOperation(OperationType.SQUARE);
        
        assertEquals("5² = ", calculator.getCurrentStatementString());
        assertEquals("25", calculator.getCurrentOperandValue());
    }
    
    @Test
    void test_addOperation() {
        operandBuilder.addNumber("5");
        calculator.setOperation(OperationType.SUBTRACTION);
        
        assertEquals("5 - ", calculator.getCurrentStatementString());
        assertEquals("5", calculator.getCurrentOperandValue());
        
        operandBuilder.addNumber("1");
        operandBuilder.addNumber("2");
    
        assertEquals("12", calculator.getCurrentOperandValue());
    
        calculator.setOperation(OperationType.PRODUCT);
    
        assertEquals("-7 × ", calculator.getCurrentStatementString());
        assertEquals("-7", calculator.getCurrentOperandValue());
    }
    
    @Test
    void test_changeOperation_clear() {
        operandBuilder.addNumber("5");
        calculator.setOperation(OperationType.DIVISION);
        
        assertEquals("5 ÷ ", calculator.getCurrentStatementString());
        assertEquals("5", calculator.getCurrentOperandValue());
        
        calculator.setOperation(OperationType.POWER);
        
        assertEquals("5 ^ ", calculator.getCurrentStatementString());
        assertEquals("5", calculator.getCurrentOperandValue());
        
        calculator.evaluate();
        
        assertEquals("5 ^ 5 = ", calculator.getCurrentStatementString());
        assertEquals("3125", calculator.getCurrentOperandValue());
        
        calculator.clear();
        assertEquals("", calculator.getCurrentStatementString());
        assertEquals("0", calculator.getCurrentOperandValue());
    }
    
    @Test
    void test_changeOperationOnUnary() {
        operandBuilder.addNumber("2");
        operandBuilder.addNumber("5");
        calculator.setOperation(OperationType.SUBTRACTION);
        
        assertEquals("25 - ", calculator.getCurrentStatementString());
        assertEquals("25", calculator.getCurrentOperandValue());
        
        calculator.setOperation(OperationType.SQRT);
        
        assertEquals("√25 = ", calculator.getCurrentStatementString());
        assertEquals("5", calculator.getCurrentOperandValue());
    }
}