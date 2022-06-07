package ru.isachenkoff.calculator.operations;

public class CalculationResult {
    private final double result;
    private final String statement;
    
    public CalculationResult(double result, String statement) {
        this.result = result;
        this.statement = statement;
    }
    
    public double getResult() {
        return result;
    }
    
    public String getStatement() {
        return statement;
    }
}
