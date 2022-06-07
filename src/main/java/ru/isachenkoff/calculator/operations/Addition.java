package ru.isachenkoff.calculator.operations;

public class Addition extends BinaryOperation {
    
    public Addition(Double firstOperand, Double secondOperand) {
        super("+", firstOperand, secondOperand);
    }
    
    @Override
    double apply(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }
    
}
