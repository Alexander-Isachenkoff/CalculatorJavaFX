package ru.isachenkoff.calculator;

import javafx.scene.control.TextField;
import ru.isachenkoff.calculator.operations.*;

import java.util.function.Consumer;

public class Calculator {
    
    private Statement statement;
    
    public void addNewOperation(OperationType type, Consumer<CalculationResult> resultConsumer, OperandBuilder operandBuilder, TextField statementField) {
        Operation newOperation = OperationType.createOperation(type);
        
        if (newOperation instanceof BinaryOperation) {
            statement = new BinaryStatement((BinaryOperation) newOperation);
            ((BinaryStatement) statement).setFirstOperand(operandBuilder.getOperandDouble());
            statementField.setText(statement.prepareStatement());
            operandBuilder.setNewValue();
        }
        if (newOperation instanceof UnaryOperation) {
            statement = new UnaryStatement(operandBuilder.getOperandDouble(), (UnaryOperation) newOperation);
            evaluate(resultConsumer, operandBuilder, statementField);
        }
    }
    
    public void evaluate(Consumer<CalculationResult> resultConsumer, OperandBuilder operandBuilder, TextField statementField) {
        if (statement instanceof BinaryStatement) {
            BinaryStatement binaryStatement = (BinaryStatement) statement;
            binaryStatement.setSecondOperand(operandBuilder.getOperandDouble());
        }
        CalculationResult result = statement.calc();
        statementField.setText(result.getStatement());
        operandBuilder.setValue(result.getResult());
        operandBuilder.setNewValue();
        statement = null;
        resultConsumer.accept(result);
    }
    
    public Statement getStatement() {
        return statement;
    }
    
    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
