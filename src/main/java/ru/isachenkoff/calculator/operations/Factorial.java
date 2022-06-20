package ru.isachenkoff.calculator.operations;

class Factorial extends UnaryOperation {
    
    Factorial() {
        super("!");
    }
    
    @Override
    double apply(double operand) {
        return getFactorial(operand);
    }
    
    @Override
    SignPlace getSignPlace() {
        return SignPlace.AFTER;
    }
    
    private static double getFactorial(double value) {
        if ((int) value != value) {
            return Double.NaN;
        }
        double result = 1;
        for (int i = 1; i <= value; i++) {
            result = result * i;
        }
        return result;
    }
    
}
