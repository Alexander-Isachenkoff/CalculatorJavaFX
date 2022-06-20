package ru.isachenkoff.calculator.operations;

public class Subtraction extends BinaryOperation {
    
    Subtraction() {
        super("-");
    }
    
    @Override
    public double apply(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }
    
}
