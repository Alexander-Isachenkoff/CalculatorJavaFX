package ru.isachenkoff.calculator.operations;

class Cos extends TrigonometricalFunction {
    
    Cos() {
        super("cos");
    }
    
    @Override
    double applyInternal(double operand) {
        return Math.cos(operand);
    }
    
}
