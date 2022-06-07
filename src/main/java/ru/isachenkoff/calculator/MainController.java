package ru.isachenkoff.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.isachenkoff.calculator.operations.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    
    @FXML
    private TextField statementField;
    @FXML
    private TextField inputField;
    
    private final OperandBuilder operandBuilder = new OperandBuilder();
    private Operation operation;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inputField.textProperty().bindBidirectional(operandBuilder.getOperand());
    }
    
    @FXML
    private void onNumberPressed(ActionEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource();
        String text = button.getText();
        operandBuilder.addNumber(text);
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
        createOperation(OperationType.ADDITION);
    }
    
    @FXML
    private void onSubtraction() {
        createOperation(OperationType.SUBTRACTION);
    }
    
    @FXML
    private void onProduct() {
        createOperation(OperationType.PRODUCT);
    }
    
    @FXML
    private void onDivision() {
        createOperation(OperationType.DIVISION);
    }
    
    @FXML
    private void onPower() {
        createOperation(OperationType.POWER);
    }
    
    @FXML
    private void onSqrt() {
        createOperation(OperationType.SQRT);
    }
    
    @FXML
    private void onSquare() {
        createOperation(OperationType.SQUARE);
    }
    
    @FXML
    private void onEquals() {
        evaluate();
    }
    
    private void createOperation(OperationType type) {
        if (operation == null) {
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
            } else {
                System.out.println("Operation type " + type.name() + " is not implemented");
            }
        }
    }
    
    private void evaluate() {
        if (operation instanceof BinaryOperation binaryOperation) {
            binaryOperation.setSecondOperand(operandBuilder.getOperandDouble());
        }
        CalculationResult result = operation.calc();
        statementField.setText(result.getStatement());
        inputField.setText(AbstractOperation.format(result.getResult()));
        operandBuilder.setNewValue();
        operation = null;
    }
}