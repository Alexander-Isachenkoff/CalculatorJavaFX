package ru.isachenkoff.calculator.operations;

abstract class AbstractOperation implements Operation {
    
    private final String sign;
    
    AbstractOperation(String sign) {
        this.sign = sign;
    }
    
    @Override
    public String getSign() {
        return sign;
    }
}
