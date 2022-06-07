package ru.isachenkoff.calculator.operations;

public class Power extends BinaryOperation {
    
    @Override
    double apply(double firstOperand, double secondOperand) {
        return Math.pow(firstOperand, secondOperand);
    }
    
    @Override
    public String getSign() {
        return "^";
    }
    
}
