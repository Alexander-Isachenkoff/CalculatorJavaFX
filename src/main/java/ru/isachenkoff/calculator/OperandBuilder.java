package ru.isachenkoff.calculator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.isachenkoff.calculator.operations.AbstractOperation;

import java.text.ParseException;

public class OperandBuilder {
    
    private static final String DEFAULT = "0";
    private final StringProperty operand = new SimpleStringProperty(DEFAULT);
    private final static String POINT = ",";
    private boolean newValue;
    
    public void clear() {
        operand.setValue(DEFAULT);
    }
    
    public void addNumber(String number) {
        if (newValue || operand.getValue().equals(DEFAULT)) {
            operand.setValue(number);
        } else {
            operand.setValue(operand.getValue() + number);
        }
        newValue = false;
    }
    
    public void addPoint() {
        if (!newValue && !operand.getValue().contains(POINT)) {
            operand.setValue(operand.getValue() + POINT);
        }
    }
    
    public void deleteLastChar() {
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
    
    public StringProperty getOperand() {
        return operand;
    }
    
    public void setValue(double value) {
        operand.setValue(AbstractOperation.format(value));
    }
    
    public double getOperandDouble() {
        try {
            return AbstractOperation.DECIMAL_FORMAT.parse(operand.getValue()).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public void setNewValue() {
        newValue = true;
    }
    
    public boolean isNewValue() {
        return newValue;
    }
}
