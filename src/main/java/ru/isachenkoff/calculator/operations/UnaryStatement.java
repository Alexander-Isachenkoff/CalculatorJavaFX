package ru.isachenkoff.calculator.operations;

import ru.isachenkoff.calculator.util.FormatUtil;

class UnaryStatement implements Statement {
    
    private double operand;
    private UnaryOperation operation;
    
    UnaryStatement(double operand, UnaryOperation operation) {
        this.operand = operand;
        this.operation = operation;
    }
    
    @Override
    public String prepareStatement() {
        String statement = "";
        String operandPart = FormatUtil.format(operand);
        if (operation.isNeedParentheses()) {
            operandPart = "(" + operandPart + ")";
        }
        switch (operation.getSignPlace()) {
            case BEFORE:
                statement = operation.getSign() + operandPart;
                break;
            case AFTER:
                statement = operandPart + operation.getSign();
                break;
        }
        return statement + " = ";
    }
    
    @Override
    public CalculationResult calc() {
        double result = operation.apply(operand);
        String statement = prepareStatement();
        return new CalculationResult(result, statement);
    }
    
    void setOperand(double operand) {
        this.operand = operand;
    }
    
    
    void setOperation(UnaryOperation operation) {
        this.operation = operation;
    }
}
