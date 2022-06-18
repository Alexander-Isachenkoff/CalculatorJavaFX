package ru.isachenkoff.calculator.operations;

public class Tan extends UnaryOperation {
    
    public Tan() {
        super("tan", true);
    }
    
    @Override
    double apply(double operand) {
        return Math.tan(operand);
    }
    
    @Override
    SignPlace getSignPlace() {
        return SignPlace.BEFORE;
    }
}
