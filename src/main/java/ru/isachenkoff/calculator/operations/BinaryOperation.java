package ru.isachenkoff.calculator.operations;


public abstract class BinaryOperation extends AbstractOperation {
    
    public BinaryOperation(String sign) {
        super(sign);
    }
    
    abstract double apply(double firstOperand, double secondOperand);
    
}
