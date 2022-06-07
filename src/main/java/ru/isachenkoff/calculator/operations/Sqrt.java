package ru.isachenkoff.calculator.operations;

public class Sqrt extends UnaryOperation {
    
    public Sqrt(double operand) {
        super("√", operand);
    }
    
    @Override
    double apply(double operand) {
        return Math.sqrt(operand);
    }
    
}
