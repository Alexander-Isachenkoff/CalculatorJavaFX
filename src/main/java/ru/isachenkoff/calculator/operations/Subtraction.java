package ru.isachenkoff.calculator.operations;

public class Subtraction extends BinaryOperation {
    
    @Override
    double apply(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }
    
    @Override
    public String getSign() {
        return "-";
    }
}
