package ru.isachenkoff.calculator.operations;

class Sqrt extends UnaryOperation {
    
    Sqrt() {
        super("√");
    }
    
    @Override
    double apply(double operand) {
        return Math.sqrt(operand);
    }
    
    @Override
    SignPlace getSignPlace() {
        return SignPlace.BEFORE;
    }

}
