package ru.isachenkoff.calculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import ru.isachenkoff.calculator.data.CalculationResultDAO;
import ru.isachenkoff.calculator.operations.CalculationResult;
import ru.isachenkoff.calculator.operations.Calculator;
import ru.isachenkoff.calculator.operations.OperationType;
import ru.isachenkoff.calculator.operations.Unit;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    
    @FXML
    private ToggleButton radButton;
    @FXML
    private ToggleButton degButton;
    @FXML
    private TitledPane titledPane;
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
    
    
    private final ObservableList<CalculationResult> log = FXCollections.observableArrayList();
    private static final int MAX_LOG_SIZE = 10;
    private final CalculationResultDAO dao = new CalculationResultDAO();
    private final Calculator calculator = new Calculator();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        calculator.setOnEvaluateAction(this::logCalcResult);
        inputField.textProperty().bindBidirectional(calculator.getOperandStringProperty());
        statementField.textProperty().bindBidirectional(calculator.getStatementStringProperty());
        logList.setCellFactory(new LogListCellFactory());
        titledPane.setExpanded(false);
        logPane.setManaged(false);
        logPane.setVisible(false);
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().add(degButton);
        toggleGroup.getToggles().add(radButton);
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            for (Toggle toggle : toggleGroup.getToggles()) {
                ((ToggleButton) toggle).setDisable(toggle == newValue);
            }
            if (radButton.isSelected()) {
                calculator.setUnit(Unit.RAD);
            }
            if (degButton.isSelected()) {
                calculator.setUnit(Unit.DEG);
            }
        });
        degButton.setSelected(true);
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
        calculator.getOperandBuilder().addNumber(text);
    }
    
    @FXML
    private void onPointPressed() {
        calculator.getOperandBuilder().addPoint();
    }
    
    @FXML
    private void onDeleteLast() {
        calculator.getOperandBuilder().deleteLastChar();
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
    private void onSin() {
        onOperation(OperationType.SIN);
    }
    
    @FXML
    private void onCos() {
        onOperation(OperationType.COS);
    }
    
    @FXML
    private void onTan() {
        onOperation(OperationType.TAN);
    }
    
    @FXML
    private void onLn() {
        calculator.setOperation(OperationType.LN);
    }
    
    @FXML
    private void onLog10() {
        calculator.setOperation(OperationType.LOG);
    }
    
    @FXML
    private void onFactorial() {
        calculator.setOperation(OperationType.FACTORIAL);
    }
    
    @FXML
    private void onPercent() {
    
    }
    
    private void onOperation(OperationType operationType) {
        calculator.setOperation(operationType);
    }
    
    @FXML
    private void onPi() {
    
    }
    
    @FXML
    private void onE() {
    
    }
    
    @FXML
    private void onEquals() {
        calculator.evaluate();
    }
    
    @FXML
    private void onClear() {
        calculator.clear();
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
    
    @FXML
    private void onExpand() {
        titledPane.setExpanded(!titledPane.isExpanded());
    }
}