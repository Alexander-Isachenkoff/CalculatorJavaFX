package ru.isachenkoff.calculator.operations;

class Tan extends UnaryOperation {
    
    Tan() {
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
