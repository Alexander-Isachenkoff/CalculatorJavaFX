package ru.isachenkoff.calculator.operations;

public class Square extends UnaryOperation {
    
    public Square() {
        super("²");
    }
    
    @Override
    double apply(double operand) {
        return operand * operand;
    }
    
    @Override
    SignPlace getSignPlace() {
        return SignPlace.AFTER;
    }
    
}
