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

    public boolean verifyNoTwoOperators() {
        String[] letters = text.getText().split("");
        String lastLetter = letters[letters.length - 1];
        if (lastLetter.equals("*") || lastLetter.equals("/") || lastLetter.equals("+") || lastLetter.equals("-")) {
            return false;
        } else {
            return true;
        }
    }

    public void removeLastIndex() {
        String[] letters = text.getText().split("");
        String[] result = Arrays.copyOf(letters, letters.length - 1);
        text.setText(String.join("", result));
    }

    public void handleButtonAction(MouseEvent event) {

        Button button = (Button) event.getSource();
        String number = button.getText();

        switch (number) {
            case "=":
                break;
            case "+":
            case "-":
                if (!verifyNoTwoOperators()) {
                    insert("(" + number);
                } else {
                    insert(number);
                }
                break;
            case "/":
            case "*":
                if (verifyNoTwoOperators()) {
                    insert(number);
                }
                break;
            case "C":
                text.setText("");
                break;
            case "D":
                removeLastIndex();
                break;
            default:
                insert(number);
        }

    }
}
