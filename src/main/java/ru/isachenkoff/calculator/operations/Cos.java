package ru.isachenkoff.calculator.operations;

class Cos extends UnaryOperation {
    
    Cos() {
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
