package ru.isachenkoff.calculator.operations;

import java.text.DecimalFormat;

public abstract class AbstractOperation implements Operation {
    
    public final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.###############");
    
    public static String format(double value) {
        return DECIMAL_FORMAT.format(value);
    }
}
