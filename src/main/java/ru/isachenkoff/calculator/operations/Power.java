package ru.isachenkoff.calculator.operations;

class Power extends BinaryOperation {
    
    Power() {
        super("^");
    }
    
    @Override
    double apply(double firstOperand, double secondOperand) {
        return Math.pow(firstOperand, secondOperand);
    }
    
}
