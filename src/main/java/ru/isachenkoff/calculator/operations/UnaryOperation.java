package ru.isachenkoff.calculator.operations;

public abstract class UnaryOperation extends AbstractOperation {
    
    private double operand;
    private final boolean needParentheses;
    
    public UnaryOperation(String sign) {
        this(sign, false);
    }
    
    public UnaryOperation(String sign, boolean needParentheses) {
        super(sign);
        this.needParentheses = needParentheses;
    }
    
    @Override
    public String prepareStatement() {
        String statement = "";
        String operandPart = format(operand);
        if (needParentheses) {
            operandPart = "(" + operandPart + ")";
        }
        switch (getSignPlace()) {
            case BEFORE:
                statement = getSign() + operandPart;
                break;
            case AFTER:
                statement = operandPart + getSign();
                break;
        }
        return statement + " = ";
    }
    
    @Override
    public CalculationResult calc() {
        double result = apply(operand);
        String statement = prepareStatement();
        return new CalculationResult(result, statement);
    }
    
    abstract double apply(double operand);
    
    public void setOperand(double operand) {
        this.operand = operand;
    }
    
    abstract SignPlace getSignPlace();
    
    enum SignPlace {
        BEFORE, AFTER
    }
}
