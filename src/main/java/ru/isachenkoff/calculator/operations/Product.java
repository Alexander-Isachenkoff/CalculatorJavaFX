package ru.isachenkoff.calculator.operations;

class Product extends BinaryOperation {
    
    Product() {
        super("×");
    }
    
    @Override
    double apply(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }
    
}
