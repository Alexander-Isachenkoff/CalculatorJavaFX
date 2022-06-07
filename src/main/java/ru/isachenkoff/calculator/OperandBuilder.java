package ru.isachenkoff.calculator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OperandBuilder {
    
    private final StringProperty operand = new SimpleStringProperty("0");
    private final static String POINT = ",";
    
    public void addNumber(String number) {
        if (operand.getValue().equals("0")) {
            operand.setValue(number);
        } else {
            operand.setValue(operand.getValue() + number);
        }
    }
    
    public void addPoint() {
        if (!operand.getValue().contains(POINT)) {
            operand.setValue(operand.getValue() + POINT);
        }
    }
    
    public void deleteLastChar() {
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
}