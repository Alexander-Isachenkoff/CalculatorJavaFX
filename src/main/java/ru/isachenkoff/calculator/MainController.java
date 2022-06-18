package ru.isachenkoff.calculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import ru.isachenkoff.calculator.data.CalculationResultDAO;
import ru.isachenkoff.calculator.operations.*;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    
    @FXML
    private ListView<CalculationResult> logList;
    @FXML
    private VBox mainVbox;
    @FXML
    private VBox logPane;
    @FXML
    private TextField statementField;
    @FXML
    private TextField inputField;
    
    private final OperandBuilder operandBuilder = new OperandBuilder();
    private Operation operation;
    private final ObservableList<CalculationResult> log = FXCollections.observableArrayList();
    private static final int MAX_LOG_SIZE = 10;
    private final CalculationResultDAO dao = new CalculationResultDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inputField.textProperty().bindBidirectional(operandBuilder.getOperand());
        logList.setCellFactory(new LogListCellFactory());
        logPane.setManaged(false);
        logPane.setVisible(false);
        loadCalculationHistory();
    }
    
    private void loadCalculationHistory() {
        List<CalculationResult> calculationResults = dao.selectLast(MAX_LOG_SIZE);
        log.setAll(FXCollections.observableArrayList(calculationResults));
        logList.setItems(log);
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
        operandBuilder.clear();
        operation = null;
    }
    
    private void onOperation(OperationType type) {
        if (operation == null) {
            addNewOperation(type);
        } else {
            if (operandBuilder.isNewValue()) {
                Optional<Operation> optionalOperation = OperationType.createOperation(type);
                if (optionalOperation.isPresent()) {
                    if (optionalOperation.get() instanceof BinaryOperation) {
                        BinaryOperation binaryOperation = (BinaryOperation) optionalOperation.get();
                        binaryOperation.setFirstOperand(((BinaryOperation) this.operation).getFirstOperand());
                        statementField.setText(binaryOperation.prepareStatement());
                        this.operation = binaryOperation;
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
            if (operation instanceof BinaryOperation) {
                BinaryOperation binaryOperation = (BinaryOperation) operation;
                binaryOperation.setFirstOperand(operandBuilder.getOperandDouble());
                statementField.setText(binaryOperation.prepareStatement());
                operandBuilder.setNewValue();
            }
            if (operation instanceof UnaryOperation) {
                UnaryOperation unaryOperation = (UnaryOperation) operation;
                unaryOperation.setOperand(operandBuilder.getOperandDouble());
                evaluate();
            }
        }
    }
    
    private void evaluate() {
        if (operation instanceof BinaryOperation) {
            BinaryOperation binaryOperation = (BinaryOperation) operation;
            binaryOperation.setSecondOperand(operandBuilder.getOperandDouble());
        }
        CalculationResult result = operation.calc();
        statementField.setText(result.getStatement());
        operandBuilder.setValue(result.getResult());
        operandBuilder.setNewValue();
        operation = null;
        logCalcResult(result);
    }
    
    private void logCalcResult(CalculationResult result) {
        log.add(0, result);
        if (log.size() > MAX_LOG_SIZE) {
            log.remove(MAX_LOG_SIZE);
        }
        dao.save(result);
    }
    
    @FXML
    private void onLog() {
        double originalPrefWidth = mainVbox.getPrefWidth();
        double originalPrefHeight = mainVbox.getPrefHeight();
        mainVbox.setPrefSize(mainVbox.getWidth(), mainVbox.getHeight());
        boolean visible = logPane.isVisible();
        logPane.setVisible(!visible);
        logPane.setManaged(!visible);
        logPane.getScene().getWindow().sizeToScene();
        mainVbox.setPrefSize(originalPrefWidth, originalPrefHeight);
    }
    
    @FXML
    private void onCleanLog() {
        dao.deleteAll();
        loadCalculationHistory();
    }
}