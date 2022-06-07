module ru.isachenkoff.calculatorjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    
    
    opens ru.isachenkoff.calculator to javafx.fxml;
    exports ru.isachenkoff.calculator;
    exports ru.isachenkoff.calculator.operations;
    opens ru.isachenkoff.calculator.operations to javafx.fxml;
}