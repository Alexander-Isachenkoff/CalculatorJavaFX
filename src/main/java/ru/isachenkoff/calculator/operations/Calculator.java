package ru.isachenkoff.calculator.operations;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.function.Consumer;

public class Calculator {
    
    private Statement statement;
    private final OperandBuilder operandBuilder = new OperandBuilder();
    private final StringProperty statementString = new SimpleStringProperty();
    private Consumer<CalculationResult> onEvaluateAction = result -> {};
    private Unit unit = Unit.DEG;
    
    public void setUnit(Unit unit) {
        this.unit = unit;
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
    
    public void setOperation(OperationType type) {
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
    
    public OperandBuilder getOperandBuilder() {
        return operandBuilder;
    }
    
    public StringProperty getOperandStringProperty() {
        return operandBuilder.getOperand();
    }
    
    public StringProperty getStatementStringProperty() {
        return statementString;
    }
    
    public void clear() {
        statementString.setValue("");
        operandBuilder.clear();
        statement = null;
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
