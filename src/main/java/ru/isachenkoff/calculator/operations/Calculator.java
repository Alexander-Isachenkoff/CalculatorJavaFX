package ru.isachenkoff.calculator.operations;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.function.Consumer;

public class Calculator {
    
    private final OperandBuilder operandBuilder = new OperandBuilder();
    private final StringProperty statementString = new SimpleStringProperty();
    private Statement statement;
    private Consumer<CalculationResult> onEvaluateAction = result -> {};
    private Unit unit = Unit.DEG;
    
    public Calculator() {
        operandBuilder.getOperand().addListener((observable, oldValue, newValue) -> {
            if (statement == null) {
                statementString.setValue("");
            }
        });
    }
    
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    
    public void setOperation(OperationType type) {
        if (operandBuilder.getOperandDouble() == null) {
            clear();
            return;
        }
        if (statement == null) {
            addNewOperation(type);
        } else {
            if (operandBuilder.isNewValue()) {
                Operation newOperation = OperationType.createOperation(type);
                if (newOperation instanceof BinaryOperation) {
                    BinaryOperation binaryOperation = (BinaryOperation) newOperation;
                    if (statement instanceof BinaryStatement) {
                        ((BinaryStatement) statement).setOperation(binaryOperation);
                    }
                    statementString.setValue(statement.prepareStatement());
                }
                if (newOperation instanceof UnaryOperation) {
                    statement = new UnaryStatement(((BinaryStatement) statement).getFirstOperand(), ((UnaryOperation) newOperation));
                    evaluate();
                }
            } else {
                evaluate();
                addNewOperation(type);
            }
        }
    }
    
    private void addNewOperation(OperationType type) {
        Operation newOperation = OperationType.createOperation(type);
        
        if (newOperation instanceof BinaryOperation) {
            statement = new BinaryStatement((BinaryOperation) newOperation);
            ((BinaryStatement) statement).setFirstOperand(operandBuilder.getOperandDouble());
            statementString.setValue(statement.prepareStatement());
            operandBuilder.setNewValue();
        }
        if (newOperation instanceof UnaryOperation) {
            statement = new UnaryStatement(operandBuilder.getOperandDouble(), (UnaryOperation) newOperation);
            evaluate();
        }
    }
    
    public void evaluate() {
        if (statement == null) {
            return;
        }
        if (statement instanceof BinaryStatement) {
            BinaryStatement binaryStatement = (BinaryStatement) statement;
            binaryStatement.setSecondOperand(operandBuilder.getOperandDouble());
        }
        if (statement instanceof UnaryStatement) {
            UnaryOperation operation = ((UnaryStatement) statement).getOperation();
            if (operation instanceof TrigonometricalFunction) {
                ((TrigonometricalFunction) operation).setUnit(unit);
            }
        }
        CalculationResult result = statement.calc();
        statementString.setValue(result.getStatement());
        operandBuilder.setValue(result.getResult());
        operandBuilder.setNewValue();
        statement = null;
        onEvaluateAction.accept(result);
    }
    
    public void percent() {
        if (statement instanceof BinaryStatement) {
            BinaryStatement binaryStatement = (BinaryStatement) statement;
            BinaryOperation operation = binaryStatement.getOperation();
            if (operation instanceof Percentage) {
                operandBuilder.setValue(((Percentage) operation).toPercentage(binaryStatement.getFirstOperand(), operandBuilder.getOperandDouble()));
            }
            evaluate();
        }
    }
    
    public void clear() {
        statementString.setValue("");
        operandBuilder.clear();
        statement = null;
    }
    
    public void setNumber(double number) {
        operandBuilder.setValue(number);
    }
    
    public void addNumber(String number) {
        operandBuilder.addNumber(number);
    }
    
    public void addPoint() {
        operandBuilder.addPoint();
    }
    
    public void deleteLastChar() {
        if (operandBuilder.getOperandDouble() == null) {
            clear();
            return;
        }
        operandBuilder.deleteLastChar();
    }
    
    public StringProperty getOperandStringProperty() {
        return operandBuilder.getOperand();
    }
    
    public StringProperty getStatementStringProperty() {
        return statementString;
    }
    
    public void setOnEvaluateAction(Consumer<CalculationResult> onEvaluateAction) {
        this.onEvaluateAction = onEvaluateAction;
    }
    
    String getCurrentOperandValue() {
        return operandBuilder.getOperand().getValue();
    }
    
    String getCurrentStatementString() {
        return statementString.getValue();
    }
}
