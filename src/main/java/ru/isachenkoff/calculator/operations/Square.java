package ru.isachenkoff.calculator.operations;

class Square extends UnaryOperation {
    
    Square() {
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
