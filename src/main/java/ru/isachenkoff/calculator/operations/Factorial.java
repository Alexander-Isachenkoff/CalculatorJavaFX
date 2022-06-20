package ru.isachenkoff.calculator.operations;

public class Factorial extends UnaryOperation {
    
    public Factorial() {
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
        double result = 1;
        for (int i = 1; i <= value; i++) {
            result = result * i;
        }
        return result;
    }
    
}
