package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Arrays;

public class CalculatorController {

    @FXML
    private TextField text;

    public void insert(String toInsert) {
        text.setText(text.getText() + toInsert);
    }

    public void handleButtonAction(MouseEvent event) {

        Button button = (Button) event.getSource();
        String number = button.getText();

        if ("=".equals(number)) {
        } else {
            insert(number);
        }

    }
}
