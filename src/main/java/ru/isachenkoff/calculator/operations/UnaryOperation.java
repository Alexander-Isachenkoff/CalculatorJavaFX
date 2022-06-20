package ru.isachenkoff.calculator.operations;

abstract class UnaryOperation extends AbstractOperation {
    
    private final boolean needParentheses;
    
    UnaryOperation(String sign) {
        this(sign, false);
    }
    
    UnaryOperation(String sign, boolean needParentheses) {
        super(sign);
        this.needParentheses = needParentheses;
    }
    
    abstract double apply(double operand);
    
    abstract SignPlace getSignPlace();
    
    boolean needParentheses() {
        return needParentheses;
    }
    
    enum SignPlace {
        BEFORE, AFTER
    }
}
