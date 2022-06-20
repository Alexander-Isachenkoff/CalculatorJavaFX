package ru.isachenkoff.calculator.operations;


class Addition extends BinaryOperation {
    
    Addition() {
        super("+");
    }
    
    @Override
    double apply(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }
    
}
