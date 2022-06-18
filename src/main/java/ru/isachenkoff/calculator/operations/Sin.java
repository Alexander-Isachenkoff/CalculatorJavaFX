package ru.isachenkoff.calculator.operations;

public class Sin extends UnaryOperation {
    
    public Sin() {
        super("sin", true);
    }
    
    @Override
    double apply(double operand) {
        return Math.sin(operand);
    }
    
    @Override
    SignPlace getSignPlace() {
        return SignPlace.BEFORE;
    }
    
}
