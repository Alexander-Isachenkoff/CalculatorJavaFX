package ru.isachenkoff.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    
    @FXML
    private TextField inputField;
    
    private final OperandBuilder operandBuilder = new OperandBuilder();
    
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
    private void deleteLast() {
        operandBuilder.deleteLastChar();
    }
}