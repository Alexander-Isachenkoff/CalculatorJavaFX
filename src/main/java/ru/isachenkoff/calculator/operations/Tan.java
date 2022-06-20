package ru.isachenkoff.calculator.operations;

class Tan extends TrigonometricalFunction {
    
    Tan() {
        super("tan");
    }
    
    @Override
    double applyInternal(double operand) {
        return Math.tan(operand);
    }
    
}
