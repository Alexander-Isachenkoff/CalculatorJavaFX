package ru.isachenkoff.calculator.operations;

class Log10 extends UnaryOperation {
    
    Log10() {
        super("lg", true);
    }
    
    @Override
    double apply(double operand) {
        return Math.log10(operand);
    }
    
    @Override
    SignPlace getSignPlace() {
        return SignPlace.BEFORE;
    }
}
