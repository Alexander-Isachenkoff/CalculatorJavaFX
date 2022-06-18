package ru.isachenkoff.calculator.operations;

public class Ln extends UnaryOperation {
    
    public Ln() {
        super("ln", true);
    }
    
    @Override
    double apply(double operand) {
        return Math.log(operand);
    }
    
    @Override
    SignPlace getSignPlace() {
        return SignPlace.BEFORE;
    }
}
