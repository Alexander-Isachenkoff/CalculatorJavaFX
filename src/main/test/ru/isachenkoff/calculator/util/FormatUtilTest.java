package ru.isachenkoff.calculator.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatUtilTest {
    
    @Test
    void format() {
        double sqrt = Math.sqrt(2.5);
        assertEquals("1,58113883008419", FormatUtil.format(sqrt));
    }
    
    @Test
    void formatNaN() {
        double sqrt = Math.sqrt(-1);
        assertEquals("не число", FormatUtil.format(sqrt));
    }
    
    @Test
    void format_null() {
        assertEquals("не число", FormatUtil.format(null));
    }
}