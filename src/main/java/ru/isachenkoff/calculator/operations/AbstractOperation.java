package ru.isachenkoff.calculator.operations;

import java.text.DecimalFormat;

public abstract class AbstractOperation implements Operation {
    
    private final String sign;
    private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.###############");
    
    public AbstractOperation(String sign) {
        this.sign = sign;
    }
    
    @Override
    public String getSign() {
        return sign;
    }
    
    static String format(double value) {
        return DECIMAL_FORMAT.format(value);
    }
}
