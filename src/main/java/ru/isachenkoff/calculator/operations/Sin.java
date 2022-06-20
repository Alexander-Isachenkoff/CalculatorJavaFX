package ru.isachenkoff.calculator.operations;

class Sin extends TrigonometricalFunction {
    
    Sin() {
        super("sin");
    }
    
    @Override
    double applyInternal(double operand) {
        return Math.sin(operand);
    }
    
}
