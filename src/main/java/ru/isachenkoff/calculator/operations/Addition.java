package ru.isachenkoff.calculator.operations;


public class Addition extends BinaryOperation {
    
    public Addition() {
        super("+");
    }
    
    @Override
    public double apply(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }
    
}
