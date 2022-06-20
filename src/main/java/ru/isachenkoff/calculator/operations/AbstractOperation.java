package ru.isachenkoff.calculator.operations;

public abstract class AbstractOperation implements Operation {
    
    private final String sign;
    
    public AbstractOperation(String sign) {
        this.sign = sign;
    }
    
    @Override
    public String getSign() {
        return sign;
    }
}
