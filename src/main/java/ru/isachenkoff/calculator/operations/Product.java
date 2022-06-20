package ru.isachenkoff.calculator.operations;

public class Product extends BinaryOperation {
    
    Product() {
        super("×");
    }
    
    @Override
    public double apply(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }
    
}
