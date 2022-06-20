package ru.isachenkoff.calculator.operations;

public abstract class UnaryOperation extends AbstractOperation {
    
    private final boolean needParentheses;
    
    public UnaryOperation(String sign) {
        this(sign, false);
    }
    
    public UnaryOperation(String sign, boolean needParentheses) {
        super(sign);
        this.needParentheses = needParentheses;
    }
    
    abstract double apply(double operand);
    
    abstract SignPlace getSignPlace();
    
    public boolean isNeedParentheses() {
        return needParentheses;
    }
    
    enum SignPlace {
        BEFORE, AFTER
    }
}
