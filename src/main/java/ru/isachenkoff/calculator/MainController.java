package ru.isachenkoff.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.isachenkoff.calculator.operations.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    
    @FXML
    private TextField statementField;
    @FXML
    private TextField inputField;
    
    private final OperandBuilder operandBuilder = new OperandBuilder();
    private Operation operation;
    private final List<CalculationResult> log = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inputField.textProperty().bindBidirectional(operandBuilder.getOperand());
    }
    
    @FXML
    private void onNumberPressed(ActionEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource();
        String text = button.getText();
        operandBuilder.addNumber(text);
        if (operation == null) {
            statementField.clear();
        }
    }
    
    @FXML
    private void onPointPressed() {
        operandBuilder.addPoint();
    }
    
    @FXML
    private void onDeleteLast() {
        operandBuilder.deleteLastChar();
    }
    
    @FXML
    private void onAddition() {
        onOperation(OperationType.ADDITION);
    }
    
    @FXML
    private void onSubtraction() {
        onOperation(OperationType.SUBTRACTION);
    }
    
    @FXML
    private void onProduct() {
        onOperation(OperationType.PRODUCT);
    }
    
    @FXML
    private void onDivision() {
        onOperation(OperationType.DIVISION);
    }
    
    @FXML
    private void onPower() {
        onOperation(OperationType.POWER);
    }
    
    @FXML
    private void onSqrt() {
        onOperation(OperationType.SQRT);
    }
    
    @FXML
    private void onSquare() {
        onOperation(OperationType.SQUARE);
    }
    
    @FXML
    private void onEquals() {
        if (operation != null) {
            evaluate();
        }
    }
    
    @FXML
    private void onClear() {
        statementField.clear();
        operation = null;
    }
    
    private void onOperation(OperationType type) {
        if (operation == null) {
            addNewOperation(type);
        } else {
            if (operandBuilder.isNewValue()) {
                Optional<Operation> optionalOperation = OperationType.createOperation(type);
                if (optionalOperation.isPresent()) {
                    if (optionalOperation.get() instanceof BinaryOperation binaryOperation) {
                        binaryOperation.setFirstOperand(((BinaryOperation) operation).getFirstOperand());
                        statementField.setText(binaryOperation.prepareStatement());
                        operation = binaryOperation;
                    }
                }
            } else {
                evaluate();
                addNewOperation(type);
            }
        }
    }
    
    private void addNewOperation(OperationType type) {
        Optional<Operation> optionalOperation = OperationType.createOperation(type);
        if (optionalOperation.isPresent()) {
            operation = optionalOperation.get();
            if (operation instanceof BinaryOperation binaryOperation) {
                binaryOperation.setFirstOperand(operandBuilder.getOperandDouble());
                statementField.setText(binaryOperation.prepareStatement());
                operandBuilder.setNewValue();
            }
            if (operation instanceof UnaryOperation unaryOperation) {
                unaryOperation.setOperand(operandBuilder.getOperandDouble());
                evaluate();
            }
        }
    }
    
    private void evaluate() {
        if (operation instanceof BinaryOperation binaryOperation) {
            binaryOperation.setSecondOperand(operandBuilder.getOperandDouble());
        }
        CalculationResult result = operation.calc();
        statementField.setText(result.getStatement());
        operandBuilder.setValue(result.getResult());
        operandBuilder.setNewValue();
        operation = null;
        log.add(result);
    }
}