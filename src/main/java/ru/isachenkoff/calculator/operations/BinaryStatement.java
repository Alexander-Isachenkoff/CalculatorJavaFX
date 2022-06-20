package ru.isachenkoff.calculator.operations;

import ru.isachenkoff.calculator.Statement;
import ru.isachenkoff.calculator.util.FormatUtil;

public class BinaryStatement implements Statement {
    
    private Double firstOperand;
    private Double secondOperand;
    private BinaryOperation operation;
    
    public BinaryStatement(BinaryOperation operation) {
        this(null, null, operation);
    }
    
    public BinaryStatement(Double firstOperand, Double secondOperand, BinaryOperation operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }
    
    @Override
    public String prepareStatement() {
        String statement = FormatUtil.format(firstOperand) + " " + operation.getSign() + " ";
        if (hasSecondOperand()) {
            statement += FormatUtil.format(secondOperand) + " = ";
        }
        return statement;
    }
    
    @Override
    public CalculationResult calc() {
        double result = operation.apply(firstOperand, secondOperand);
        String statement = prepareStatement();
        return new CalculationResult(result, statement);
    }
    
    public boolean hasSecondOperand() {
        return secondOperand != null;
    }
    
    public void setFirstOperand(Double firstOperand) {
        this.firstOperand = firstOperand;
    }
    
    public Double getFirstOperand() {
        return firstOperand;
    }
    
    public Double getSecondOperand() {
        return secondOperand;
    }
    
    public void setSecondOperand(Double secondOperand) {
        this.secondOperand = secondOperand;
    }
    
    public void setOperation(BinaryOperation operation) {
        this.operation = operation;
    }
}
