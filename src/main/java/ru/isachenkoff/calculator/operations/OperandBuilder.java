package ru.isachenkoff.calculator.operations;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.isachenkoff.calculator.util.FormatUtil;

import java.text.ParseException;

public class OperandBuilder {
    
    private static final String DEFAULT = "0";
    private final StringProperty operand = new SimpleStringProperty(DEFAULT);
    private final static String POINT = ",";
    private boolean newValue;
    
    void clear() {
        operand.setValue(DEFAULT);
    }
    
    void addNumber(String number) {
        if (newValue || operand.getValue().equals(DEFAULT)) {
            operand.setValue(number);
        } else {
            operand.setValue(operand.getValue() + number);
        }
        newValue = false;
    }
    
    void addPoint() {
        if (!newValue && !operand.getValue().contains(POINT)) {
            operand.setValue(operand.getValue() + POINT);
        }
    }
    
    void deleteLastChar() {
        if (newValue) {
            return;
        }
        String value = operand.getValue();
        if (value.length() > 1) {
            operand.setValue(value.substring(0, value.length() - 1));
        } else {
            operand.setValue(DEFAULT);
        }
    }
    
    StringProperty getOperand() {
        return operand;
    }
    
    void setValue(Double value) {
        operand.setValue(FormatUtil.format(value));
    }
    
    Double getOperandDouble() {
        try {
            return FormatUtil.parse(operand.getValue());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    void setNewValue() {
        newValue = true;
    }
    
    boolean isNewValue() {
        return newValue;
    }
}
