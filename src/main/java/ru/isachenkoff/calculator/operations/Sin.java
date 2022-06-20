package ru.isachenkoff.calculator.operations;

class Sin extends UnaryOperation {
    
    Sin() {
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
