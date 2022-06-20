package ru.isachenkoff.calculator.operations;

class Division extends BinaryOperation implements Percentage {
    
    Division() {
        super("÷");
    }
    
    @Override
    double apply(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }
    
    @Override
    public double toPercentage(double first, double second) {
        return second / 100;
    }
    
}
