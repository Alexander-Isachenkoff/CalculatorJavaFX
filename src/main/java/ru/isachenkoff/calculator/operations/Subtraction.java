package ru.isachenkoff.calculator.operations;

class Subtraction extends BinaryOperation implements Percentage {
    
    Subtraction() {
        super("-");
    }
    
    @Override
    double apply(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }
    
    @Override
    public double toPercentage(double first, double second) {
        return first * (second / 100);
    }
    
}
