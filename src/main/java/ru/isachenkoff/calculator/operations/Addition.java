package ru.isachenkoff.calculator.operations;

public class Addition extends BinaryOperation {
    
    public Addition(double firstOperand, double secondOperand) {
        super("+", firstOperand, secondOperand);
    }
    
    @Override
    double apply(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }
    
}
