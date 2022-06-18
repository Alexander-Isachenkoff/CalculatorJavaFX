package ru.isachenkoff.calculator;

import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Callback;
import ru.isachenkoff.calculator.operations.CalculationResult;

public class LogListCellFactory implements Callback<ListView<CalculationResult>, ListCell<CalculationResult>> {
    @Override
    public ListCell<CalculationResult> call(ListView<CalculationResult> param) {
        return new LogListCell();
    }
}

class LogListCell extends ListCell<CalculationResult> {
    
    @Override
    public void updateSelected(boolean selected) {
        super.updateSelected(selected);
    }
    
    @Override
    protected void updateItem(CalculationResult item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            VBox vBox = new VBox();
            setGraphic(vBox);
            
            TextField textField1 = new TextField(item.getStatement());
            TextField textField2 = new TextField(item.getFormattedResult());
            
            textField1.setBackground(Background.EMPTY);
            textField2.setBackground(Background.EMPTY);
    
            textField1.setStyle("-fx-font-weight: regular; -fx-text-fill: #666; -fx-padding: 2px");
            textField2.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-padding: 2px");
            
            textField1.setAlignment(Pos.CENTER_RIGHT);
            textField2.setAlignment(Pos.CENTER_RIGHT);
            
            vBox.getChildren().addAll(textField1, textField2);
        }
    }
    
}
