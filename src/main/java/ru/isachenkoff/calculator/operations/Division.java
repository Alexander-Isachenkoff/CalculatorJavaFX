package ru.isachenkoff.calculator.operations;

public class Division extends BinaryOperation {
    
    Division() {
        super("÷");
    }
    
    @Override
    double apply(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }
    
}
