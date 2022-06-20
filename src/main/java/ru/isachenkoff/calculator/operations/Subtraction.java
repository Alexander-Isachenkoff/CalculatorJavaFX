package ru.isachenkoff.calculator.operations;

class Subtraction extends BinaryOperation {
    
    Subtraction() {
        super("-");
    }
    
    @Override
    double apply(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }
    
}
