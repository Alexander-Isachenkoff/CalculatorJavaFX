package ru.isachenkoff.calculator.operations;

public class Cos extends UnaryOperation {
    
    public Cos() {
        super("cos", true);
    }
    
    @Override
    double apply(double operand) {
        return Math.cos(operand);
    }
    
    @Override
    SignPlace getSignPlace() {
        return SignPlace.BEFORE;
    }
}
