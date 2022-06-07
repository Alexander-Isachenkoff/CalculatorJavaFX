package ru.isachenkoff.calculator.operations;

public class Division extends BinaryOperation {
    
    @Override
    double apply(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }
    
    @Override
    public String getSign() {
        return "÷";
    }
}
