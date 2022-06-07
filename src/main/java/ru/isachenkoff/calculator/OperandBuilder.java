package ru.isachenkoff.calculator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.isachenkoff.calculator.operations.AbstractOperation;

import java.text.ParseException;

public class OperandBuilder {
    
    private final StringProperty operand = new SimpleStringProperty("0");
    private final static String POINT = ",";
    private boolean newValue;
    
    public void addNumber(String number) {
        if (newValue || operand.getValue().equals("0")) {
            operand.setValue(number);
        } else {
            operand.setValue(operand.getValue() + number);
        }
        newValue = false;
    }
    
    public void addPoint() {
        if (!operand.getValue().contains(POINT)) {
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
            operand.setValue("0");
        }
    }
    
    public StringProperty getOperand() {
        return operand;
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
}
