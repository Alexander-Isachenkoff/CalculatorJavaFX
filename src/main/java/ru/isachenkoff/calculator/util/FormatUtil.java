package ru.isachenkoff.calculator.util;

import java.text.DecimalFormat;
import java.text.ParseException;

public class FormatUtil {
    
    private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.###############");
    private static final String NaN_STRING = "не число";
    
    public static String format(Double value) {
        if (value == null || Double.isNaN(value)) {
            return NaN_STRING;
        }
        return DECIMAL_FORMAT.format(value);
    }
    
    public static Double parse(String source) throws ParseException {
        if (source.equals(NaN_STRING)) {
            return null;
        }
        return DECIMAL_FORMAT.parse(source).doubleValue();
    }
    
}
