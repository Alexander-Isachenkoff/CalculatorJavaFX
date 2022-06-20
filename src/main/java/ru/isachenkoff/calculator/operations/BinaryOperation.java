package ru.isachenkoff.calculator.operations;


abstract class BinaryOperation extends AbstractOperation {
    
    BinaryOperation(String sign) {
        super(sign);
    }
    
    abstract double apply(double firstOperand, double secondOperand);
    
}
