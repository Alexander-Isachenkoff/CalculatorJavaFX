package ru.isachenkoff.calculator.operations;

import ru.isachenkoff.calculator.util.FormatUtil;

class BinaryStatement implements Statement {
    
    private Double firstOperand;
    private Double secondOperand;
    private BinaryOperation operation;
    
    BinaryStatement(BinaryOperation operation) {
        this(null, null, operation);
    }
    
    private BinaryStatement(Double firstOperand, Double secondOperand, BinaryOperation operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }
    
    public BinaryOperation getOperation() {
        return operation;
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
    
    private boolean hasSecondOperand() {
        return secondOperand != null;
    }
    
    void setFirstOperand(Double firstOperand) {
        this.firstOperand = firstOperand;
    }
    
    Double getFirstOperand() {
        return firstOperand;
    }
    
    Double getSecondOperand() {
        return secondOperand;
    }
    
    void setSecondOperand(Double secondOperand) {
        this.secondOperand = secondOperand;
    }
    
    void setOperation(BinaryOperation operation) {
        this.operation = operation;
    }
}
