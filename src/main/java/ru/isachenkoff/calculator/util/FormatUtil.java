package ru.isachenkoff.calculator.util;

import java.text.DecimalFormat;
import java.text.ParseException;

public class FormatUtil {
    
    private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.###############");
    private static final String NaN_STRING = "не число";
    
    public static String format(double value) {
        if (Double.isNaN(value)) {
            return NaN_STRING;
        }
        return DECIMAL_FORMAT.format(value);
    }
    
    public static double parse(String source) throws ParseException {
        return DECIMAL_FORMAT.parse(source).doubleValue();
    }
    
}
