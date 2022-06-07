package ru.isachenkoff.calculator.operations;

import java.text.DecimalFormat;

public abstract class AbstractOperation implements Operation {
    
    private final String sign;
    public final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.###############");
    
    public AbstractOperation(String sign) {
        this.sign = sign;
    }
    
    @Override
    public String getSign() {
        return sign;
    }
    
    public static String format(double value) {
        return DECIMAL_FORMAT.format(value);
    }
}
