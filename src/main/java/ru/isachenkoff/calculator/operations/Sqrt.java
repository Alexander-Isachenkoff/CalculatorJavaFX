package ru.isachenkoff.calculator.operations;

public class Sqrt extends UnaryOperation {
    
    public Sqrt() {
        super("√");
    }
    
    @Override
    double apply(double operand) {
        return Math.sqrt(operand);
    }
    
}
