package ru.isachenkoff.calculator.operations;

public class Sqrt extends UnaryOperation {
    
    @Override
    double apply(double operand) {
        return Math.sqrt(operand);
    }
    
    @Override
    SignPlace getSignPlace() {
        return SignPlace.BEFORE;
    }
    
    @Override
    public String getSign() {
        return "√";
    }
}
