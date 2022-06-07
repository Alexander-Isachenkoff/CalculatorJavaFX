package ru.isachenkoff.calculator.operations;

public class Square extends UnaryOperation {
    
    @Override
    public String getSign() {
        return "²";
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
