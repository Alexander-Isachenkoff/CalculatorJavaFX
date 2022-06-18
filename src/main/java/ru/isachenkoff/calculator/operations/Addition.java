package ru.isachenkoff.calculator.operations;

public class Addition extends BinaryOperation {
    
    public Addition() {
        super("+");
    }
    
    @Override
    double apply(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }
    
    @Override
    public String getSign() {
        return "+";
    }
}
